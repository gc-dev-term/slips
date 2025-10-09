#!/bin/bash
# eduslip-vs - download full slip folder (recursively)

USERNAME="gc-dev-term"
REPO="slips"
SUBJECT="$1"
SLIPNO="$2"

# Check if both arguments provided
if [ -z "$SUBJECT" ] || [ -z "$SLIPNO" ]; then
  echo "Usage: eduslip-vs <subject> <slip number>"
  exit 1
fi

# Build folder path
FOLDER_PATH="$SUBJECT/slip$SLIPNO"

echo "📥 Fetching all files for $SUBJECT slip$SLIPNO ..."

# GitHub API to list all files and folders recursively
API_URL="https://api.github.com/repos/$USERNAME/$REPO/contents/$FOLDER_PATH?ref=main"

download_recursive() {
  local url="$1"
  local path="$2"
  local response=$(curl -s "$url")

  for file in $(echo "$response" | grep '"download_url":' | cut -d '"' -f 4); do
    relpath="${file#*${FOLDER_PATH}/}"
    mkdir -p "$path/$(dirname "$relpath")"
    echo "⬇️  Downloading $relpath ..."
    curl -s -L "$file" -o "$path/$relpath"
  done
}

download_recursive "$API_URL" "$HOME"

echo "✅ All files (including folders) downloaded to: $HOME"
