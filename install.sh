#!/bin/bash
# Installer for eduslip-vs (non-root version)

INSTALL_PATH="$HOME/.local/bin"

mkdir -p "$INSTALL_PATH"
curl -L -o "$INSTALL_PATH/eduslip-vs" https://raw.githubusercontent.com/gc-dev-term/slips/main/eduslip-vs.sh
chmod +x "$INSTALL_PATH/eduslip-vs"

# Add to PATH if not already there
if [[ ":$PATH:" != *":$INSTALL_PATH:"* ]]; then
    echo "export PATH=\$PATH:$INSTALL_PATH" >> ~/.bashrc
    echo "✅ Added $INSTALL_PATH to PATH. Please restart terminal or run: source ~/.bashrc"
fi

echo "✅ eduslip-vs installed successfully!"
echo "Now you can run: eduslip-vs <subject> <slip-no>"
