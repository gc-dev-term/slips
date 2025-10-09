#!/bin/bash
# eduslip-vs - download an entire slip folder (including subfolders) from GitHub
# Usage: eduslip-vs <subject> <slip-no>
# Example: eduslip-vs java 10

set -euo pipefail

USERNAME="gc-dev-term"
REPO="slips"
BRANCH="main"

SUBJECT="${1:-}"
SLIPNO="${2:-}"

if [ -z "$SUBJECT" ] || [ -z "$SLIPNO" ]; then
  echo "Usage: eduslip-vs <subject> <slip-no>"
  exit 1
fi

ZIP_URL="https://github.com/${USERNAME}/${REPO}/archive/refs/heads/${BRANCH}.zip"
ZIP_TMP="$(mktemp -u 2>/dev/null || printf "/tmp/eduslip_%s.zip" "$RANDOM")"
ZIP_TMP="/tmp/eduslip_${RANDOM}.zip"
TMPDIR="$(mktemp -d 2>/dev/null || printf "/tmp/eduslip_tmp_%s" "$RANDOM")"
ZIP_ROOT="${REPO}-${BRANCH}"                    # e.g. slips-main
FOLDER_IN_ZIP="${ZIP_ROOT}/${SUBJECT}/slip${SLIPNO}"
DEST_BASE="$HOME"                              # result will be: $HOME/<subject>/slip<no>

echo "📥 Downloading repo zip from: $ZIP_URL"
curl -L -s -o "$ZIP_TMP" "$ZIP_URL"
if [ ! -s "$ZIP_TMP" ]; then
  echo "❌ Failed to download repo zip."
  rm -f "$ZIP_TMP"
  exit 1
fi

# prefer unzip if available (keeps paths)
if command -v unzip >/dev/null 2>&1; then
  echo "🔽 Extracting $FOLDER_IN_ZIP from zip..."
  # unzip supports extracting with pattern; extract into TMPDIR
  unzip -q "$ZIP_TMP" "${FOLDER_IN_ZIP}/*" -d "$TMPDIR" || true
else
  # fallback: use python to extract (works when unzip missing, e.g. in some Windows setups)
  if command -v python3 >/dev/null 2>&1; then
    echo "🔽 No 'unzip' found — using python to extract..."
    python3 - <<PYCODE
import zipfile,sys
z = zipfile.ZipFile("$ZIP_TMP")
prefix = "$FOLDER_IN_ZIP/"
for info in z.infolist():
    if info.filename.startswith(prefix) and not info.is_dir():
        target = "$TMPDIR/" + info.filename
        import os
        os.makedirs(os.path.dirname(target), exist_ok=True)
        with open(target, "wb") as f:
            f.write(z.read(info.filename))
z.close()
PYCODE
  else
    echo "❌ Neither 'unzip' nor 'python3' available to extract zip. Install unzip or python3."
    rm -f "$ZIP_TMP"
    rmdir --ignore-fail-on-non-empty "$TMPDIR" 2>/dev/null || true
    exit 1
  fi
fi

# Check extracted path exists
EXTRACTED_PATH="$TMPDIR/$FOLDER_IN_ZIP"
if [ ! -d "$EXTRACTED_PATH" ]; then
  echo "⚠️  Folder '$FOLDER_IN_ZIP' not found inside the repo zip."
  echo "Make sure the path exists in the repo: ${SUBJECT}/slip${SLIPNO}"
  rm -f "$ZIP_TMP"
  rm -rf "$TMPDIR"
  exit 1
fi

# Move extracted folder to destination preserving structure: ~/subject/slipN/...
DEST_DIR="$DEST_BASE/$SUBJECT/slip${SLIPNO}"
mkdir -p "$(dirname "$DEST_DIR")"
# remove existing target if you want a fresh copy
rm -rf "$DEST_DIR"
mv "$EXTRACTED_PATH" "$DEST_DIR"

# cleanup
rm -f "$ZIP_TMP"
# remove the rest of tmpdir (the parent folder e.g. tmpdir/slips-main/)
rm -rf "$TMPDIR"

echo "✅ All files and subfolders downloaded to: $DEST_DIR"
