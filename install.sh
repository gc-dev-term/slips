#!/bin/bash
# eduslip-vs <subject> <slip-no>
# Example: eduslip-vs java 10

SUBJECT=$1
SLIP=$2
USER="gc-dev-term"
REPO="slips"
API="https://api.github.com/repos/$USER/$REPO/contents/$SUBJECT/slip$SLIP"
RAW="https://raw.githubusercontent.com/$USER/$REPO/main"
DEST="$HOME"

if [ -z "$SUBJECT" ] || [ -z "$SLIP" ]; then
    echo "Usage: eduslip-vs <subject> <slip-no>"
    exit 1
fi

echo "📥 Fetching files for $SUBJECT slip$SLIP ..."

download_recursive() {
    local folder_url="$1"
    local path_prefix="$2"

    # Get JSON list of files/folders
    local items=$(curl -s "$folder_url" | grep '"download_url"' -A 2 | sed -n 's/."download_url": "\(.\)".*/\1/p')

    if [ -z "$items" ]; then
        echo "⚠ No direct files here, checking for subfolders..."
        local subfolders=$(curl -s "$folder_url" | grep '"url"' | sed -n 's/."url": "\(.\)".*/\1/p' | grep -vE 'contents/$|git/')
        for sub in $subfolders; do
            download_recursive "$sub" "$path_prefix"
        done
    else
        for url in $items; do
            local filename=$(basename "$url")
            echo "⬇  Downloading $filename ..."
            curl -s -L -o "$DEST/$filename" "$url"
        done
    fi
}

download_recursive "$API" ""

echo "✨ All done! Files saved to: $DEST"
