#!/bin/bash

# Get the directory of the current script
SCRIPT_DIR=$(dirname "$0")

# Load environment variables from .env file
if [ -f "$SCRIPT_DIR/../.env" ]; then
  # Remove any carriage return characters from the .env file
  sed -i 's/\r$//' "$SCRIPT_DIR/../.env"
  # Export environment variables
  set -a
  source "$SCRIPT_DIR/../.env"
  set +a
else
  echo ".env file not found!"
  exit 1
fi

# TODO : Get latest .tars from GitHub

# Ensure necessary environment variables are set
if [ -z "$AWS_PRIVATE_KEY_PATH" ] || [ -z "$AWS_HOST" ] || [ -z "$AWS_USER" ] || [ -z "$REMOTE_DIR" ] || [ -z "$GET_TAR_FILE" ] || [ -z "$PUT_TAR_FILE" ] || [ -z "$POST_TAR_FILE" ] || [ -z "$DELETE_TAR_FILE" ] || [ -z "$DB_TAR_FILE" ] || [ -z "$API_GATEWAY_TAR_FILE" ] || [ -z "$PRODUCTION_SCRIPT" ] || [ -z "$COMPOSE_PRODUCTION_FILE" ] || [ -z "$AWS_SSH_PORT" ] || [ -z "$NGINX_CONFIG_FILE" ]; then
  echo "One or more environment variables are missing!"
  exit 1
fi

# Transfer files to the EC2 instance
echo "Transferring files to $AWS_HOST on port $AWS_SSH_PORT..."
scp -P "$AWS_SSH_PORT" -i "$AWS_PRIVATE_KEY_PATH" "$GET_TAR_FILE" "$AWS_USER@$AWS_HOST:$REMOTE_DIR/"
scp -P "$AWS_SSH_PORT" -i "$AWS_PRIVATE_KEY_PATH" "$PUT_TAR_FILE" "$AWS_USER@$AWS_HOST:$REMOTE_DIR/"
scp -P "$AWS_SSH_PORT" -i "$AWS_PRIVATE_KEY_PATH" "$POST_TAR_FILE" "$AWS_USER@$AWS_HOST:$REMOTE_DIR/"
scp -P "$AWS_SSH_PORT" -i "$AWS_PRIVATE_KEY_PATH" "$DELETE_TAR_FILE" "$AWS_USER@$AWS_HOST:$REMOTE_DIR/"
scp -P "$AWS_SSH_PORT" -i "$AWS_PRIVATE_KEY_PATH" "$DB_TAR_FILE" "$AWS_USER@$AWS_HOST:$REMOTE_DIR/"
scp -P "$AWS_SSH_PORT" -i "$AWS_PRIVATE_KEY_PATH" "$API_GATEWAY_TAR_FILE" "$AWS_USER@$AWS_HOST:$REMOTE_DIR/"
scp -P "$AWS_SSH_PORT" -i "$AWS_PRIVATE_KEY_PATH" "$PRODUCTION_SCRIPT" "$AWS_USER@$AWS_HOST:$REMOTE_DIR/"
scp -P "$AWS_SSH_PORT" -i "$AWS_PRIVATE_KEY_PATH" "$COMPOSE_PRODUCTION_FILE" "$AWS_USER@$AWS_HOST:$REMOTE_DIR/"
scp -P "$AWS_SSH_PORT" -i "$AWS_PRIVATE_KEY_PATH" "$NGINX_CONFIG_FILE" "$AWS_USER@$AWS_HOST:$REMOTE_DIR/"

# Connect to the EC2 instance and execute the production script
echo "Connecting to $AWS_HOST and executing $PRODUCTION_SCRIPT..."
ssh -p "$AWS_SSH_PORT" -i "$AWS_PRIVATE_KEY_PATH" "$AWS_USER@$AWS_HOST" << EOF
  chmod +x $REMOTE_DIR/$PRODUCTION_SCRIPT
  chmod 644 $REMOTE_DIR/$COMPOSE_PRODUCTION_FILE
  cd $REMOTE_DIR
  sudo ./$(basename $PRODUCTION_SCRIPT)
EOF

echo "Deployment completed."
