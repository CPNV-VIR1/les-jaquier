#!/bin/bash

# Variables
TAR_FILE="kezboards.tar"
PRODUCTION_SCRIPT="production.sh"
COMPOSE_FILE="compose-production.yaml"
REMOTE_DIR="~/"
AWS_PRIVATE_KEY_PATH="C:\Users\pk45jin\.ssh\VIR1_DEB12_DOCKER_LESJACQUIERS.pem" # Update this to your actual private key path
AWS_HOST="15.188.181.147" # Update this to your EC2 instance public DNS
AWS_USER="admin" # Update this to your EC2 username (e.g., ec2-user, ubuntu)

# Transfer files to the EC2 instance
echo "Transferring files to $AWS_HOST..."
scp -i $AWS_PRIVATE_KEY_PATH $TAR_FILE $AWS_USER@$AWS_HOST:$REMOTE_DIR/
scp -i $AWS_PRIVATE_KEY_PATH $PRODUCTION_SCRIPT $AWS_USER@$AWS_HOST:$REMOTE_DIR/
scp -i $AWS_PRIVATE_KEY_PATH $COMPOSE_FILE $AWS_USER@$AWS_HOST:$REMOTE_DIR/

# Connect to the EC2 instance and execute the production script
echo "Connecting to $AWS_HOST and executing $PRODUCTION_SCRIPT..."
ssh -i $AWS_PRIVATE_KEY_PATH $AWS_USER@$AWS_HOST << EOF
  chmod +x $REMOTE_DIR/$PRODUCTION_SCRIPT
  chmod 644 $REMOTE_DIR/$COMPOSE_FILE
  cd $REMOTE_DIR
  sudo ./$(basename $PRODUCTION_SCRIPT)
EOF

echo "Deployment completed."
