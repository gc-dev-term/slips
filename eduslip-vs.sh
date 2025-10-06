#!/bin/bash
# Usage: eduslip-vs <subject> <slip-no>
# Example: eduslip-vs os 11

SUBJECT=$1
SLIP=$2
REPO="https://github.com/gc-dev-term/slips/raw/main"
DEST="$HOME/Downloads/slips"

if [ -z "$SUBJECT" ] || [ -z "$SLIP" ]; then
    echo "Usage: eduslip-vs <subject> <slip-no>"
    exit 1
fi

mkdir -p "$DEST"

echo "📥 Downloading ${SUBJECT}/slip${SLIP}..."
curl -L -o "${DEST}/${SUBJECT}_slip${SLIP}.zip" \
"${REPO}/${SUBJECT}/slip${SLIP}.zip"

if [ $? -eq 0 ]; then
    echo "✅ Saved to ${DEST}/${SUBJECT}_slip${SLIP}.zip"
else
    echo "❌ Failed to download. Check if file exists in your repo."
fi
