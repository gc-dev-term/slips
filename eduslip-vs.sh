#!/bin/bash
# eduslip-vs <subject> <slip-no>
# Example: eduslip-vs os 11

SUBJECT=$1
SLIP=$2
REPO="https://raw.githubusercontent.com/gc-dev-term/slips/main"

# Check arguments
if [ -z "$SUBJECT" ] || [ -z "$SLIP" ]; then
    echo "Usage: eduslip-vs <subject> <slip-no>"
    exit 1
fi

# Destination (user home)
DEST="$HOME"

# File names to download
FILES=("q1.c" "q2.c")

echo "📥 Downloading ${SUBJECT}/slip${SLIP} files to $DEST ..."

for FILE in "${FILES[@]}"; do
    FILE_URL="${REPO}/${SUBJECT}/slip${SLIP}/${FILE}"
    echo "⬇️  Fetching $FILE ..."
    curl -s -L -o "${DEST}/${FILE}" "$FILE_URL"
    if [ $? -eq 0 ]; then
        echo "✅ Downloaded: ${DEST}/${FILE}"
    else
        echo "⚠️ Failed: ${FILE}"
    fi
done

echo "✨ All done! Files saved to: $DEST"
