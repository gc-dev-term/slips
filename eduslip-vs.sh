#!/bin/bash
# Usage: eduslip-vs <subject> <slip-no>
# Example: eduslip-vs java 10

SUBJECT=$1
SLIP=$2
REPO="https://github.com/gc-dev-term/slips"
RAW="https://raw.githubusercontent.com/gc-dev-term/slips/main"

# Check arguments
if [ -z "$SUBJECT" ] || [ -z "$SLIP" ]; then
    echo "Usage: eduslip-vs <subject> <slip-no>"
    exit 1
fi

# Destination
DEST="$HOME"
TMP="/tmp/eduslip-temp"

# Create temp folder
rm -rf "$TMP"
mkdir -p "$TMP"

echo "📥 Fetching file list from ${REPO}/tree/main/${SUBJECT}/slip${SLIP} ..."

# Get all file paths under slip folder using GitHub API
API_URL="https://api.github.com/repos/gc-dev-term/slips/contents/${SUBJECT}/slip${SLIP}"
curl -s "$API_URL" | grep '"download_url":' | cut -d '"' -f 4 > "$TMP/list.txt"

echo "⬇️ Downloading all files in slip${SLIP} ..."
while read -r FILE_URL; do
    if [ -n "$FILE_URL" ]; then
        FILE_NAME=$(basename "$FILE_URL")
        echo "  ➤ $FILE_NAME"
        curl -s -L -o "${DEST}/${FILE_NAME}" "$FILE_URL"
    fi
done < "$TMP/list.txt"

echo "✅ All files (including packages) downloaded to: $DEST"
