#!/bin/bash
# Usage: eduslip-vs <subject> <slip-no>
# Example: eduslip-vs java 10

SUBJECT=$1
SLIP=$2
REPO="https://github.com/gc-dev-term/slips"
RAW="https://raw.githubusercontent.com/gc-dev-term/slips/main"

if [ -z "$SUBJECT" ] || [ -z "$SLIP" ]; then
    echo "Usage: eduslip-vs <subject> <slip-no>"
    exit 1
fi

DEST="$HOME"
TMP="/tmp/eduslip-temp"

rm -rf "$TMP"
mkdir -p "$TMP"

echo "📥 Fetching files for ${SUBJECT} slip${SLIP} ..."

API_URL="https://api.github.com/repos/gc-dev-term/slips/contents/${SUBJECT}/slip${SLIP}"

# Recursive function to fetch all file download URLs
get_files() {
    local api_url=$1
    local rel_path=$2

    curl -s "$api_url" | while read -r line; do
        if [[ "$line" == *'"type": "dir"'* ]]; then
            dir=$(echo "$line" | grep -o '"path": *"[^"]*"' | cut -d '"' -f 4)
            get_files "https://api.github.com/repos/gc-dev-term/slips/contents/$dir" "$rel_path"
        elif [[ "$line" == *'"download_url":'* ]]; then
            echo "$line" | cut -d '"' -f 4
        fi
    done
}

# Save all download URLs
get_files "$API_URL" > "$TMP/list.txt"

echo "⬇️  Downloading all files ..."
while read -r FILE_URL; do
    if [ -n "$FILE_URL" ]; then
        REL_PATH=$(echo "$FILE_URL" | sed "s|$RAW/||")
        DEST_PATH="${DEST}/${REL_PATH}"
        mkdir -p "$(dirname "$DEST_PATH")"
        echo "   ➤ $(basename "$FILE_URL")"
        curl -s -L -o "$DEST_PATH" "$FILE_URL"
    fi
done < "$TMP/list.txt"

echo "✨ All done! Files saved to: $DEST"
