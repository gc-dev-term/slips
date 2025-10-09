#!/bin/bash
# eduslip-vs <subject> <slip-no>
# Example: eduslip-vs os 11

SUBJECT=$1
SLIP=$2
REPO="https://api.github.com/repos/gc-dev-term/slips/contents/${SUBJECT}/slip${SLIP}"

DEST="$HOME"

if [ -z "$SUBJECT" ] || [ -z "$SLIP" ]; then
    echo "Usage: eduslip-vs <subject> <slip-no>"
    exit 1
fi

echo "📥 Fetching all files from ${SUBJECT}/slip${SLIP} to $DEST ..."

# Get list of files in the GitHub folder via API
FILES=$(curl -s $REPO | grep '"download_url":' | cut -d '"' -f 4)

if [ -z "$FILES" ]; then
    echo "⚠️ No files found or folder does not exist!"
    exit 1
fi

# Download each file
for FILE_URL in $FILES; do
    FILE_NAME=$(basename $FILE_URL)
    echo "⬇️ Downloading $FILE_NAME ..."
    curl -s -L -o "${DEST}/${FILE_NAME}" "$FILE_URL"
    if [ $? -eq 0 ]; then
        echo "✅ Downloaded: ${DEST}/${FILE_NAME}"
    else
        echo "⚠️ Failed: $FILE_NAME"
    fi
done

echo "✨ All files saved to: $DEST"
