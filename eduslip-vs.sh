#!/bin/bash
# Usage: eduslip-vs <subject> <slip-no>
# Example: eduslip-vs java 10

SUBJECT=$1
SLIP=$2
REPO_USER="gc-dev-term"
REPO_NAME="slips"
BRANCH="main"
API_BASE="https://api.github.com/repos/${REPO_USER}/${REPO_NAME}/contents"
RAW_BASE="https://raw.githubusercontent.com/${REPO_USER}/${REPO_NAME}/${BRANCH}"

if [ -z "$SUBJECT" ] || [ -z "$SLIP" ]; then
    echo "Usage: eduslip-vs <subject> <slip-no>"
    exit 1
fi

DEST="$HOME"
START_PATH="${SUBJECT}/slip${SLIP}"

echo "📥 Downloading all files from ${START_PATH} ..."
mkdir -p "$DEST"

# Recursive function
download_folder() {
    local FOLDER_PATH="$1"
    local API_URL="${API_BASE}/${FOLDER_PATH}"

    # Get file list (JSON)
    CONTENTS=$(curl -s "$API_URL")

    echo "$CONTENTS" | grep '"path":' | cut -d '"' -f 4 | while read -r PATH; do
        TYPE=$(echo "$CONTENTS" | grep -A 5 "\"path\": \"$PATH\"" | grep '"type":' | head -n 1 | cut -d '"' -f 4)
        if [ "$TYPE" == "file" ]; then
            FILE_URL="${RAW_BASE}/${PATH}"
            LOCAL_PATH="${DEST}/${PATH}"
            mkdir -p "$(dirname "$LOCAL_PATH")"
            echo "⬇️  Downloading $PATH"
            curl -s -L -o "$LOCAL_PATH" "$FILE_URL"
        elif [ "$TYPE" == "dir" ]; then
            download_folder "$PATH"
        fi
    done
}

download_folder "$START_PATH"

echo "✅ All files (including subfolders) downloaded to: $DEST"
