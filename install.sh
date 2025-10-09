#!/bin/bash
# Installer for eduslip-vs

# Step 1: Download the main script from your GitHub
sudo curl -L -o /usr/local/bin/eduslip-vs https://raw.githubusercontent.com/gc-dev-term/slips/main/eduslip-vs.sh

# Step 2: Make it executable
sudo chmod +x /usr/local/bin/eduslip-vs

# Step 3: Success message
echo "✅ eduslip-vs installed successfully!"
echo "You can now use it like: eduslip-vs <subject> <slip-no>"
