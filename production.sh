#!/bin/bash
#docker load -i kezboards.tar
#docker-compose -f compose-production.yaml down
#docker-compose -f compose-production.yaml up

# Define variables
TAR_FILE="kezboards.tar"
COMPOSE_FILE="compose-production.yaml"

# Load the Docker image from the tar file
echo "Loading Docker image from ${TAR_FILE}..."
docker load -i ${TAR_FILE}

# Check if the load was successful
if [ $? -ne 0 ]; then
    echo "Failed to load the Docker image from ${TAR_FILE}!"
    exit 1
fi

# Run Docker Compose
echo "Starting services with Docker Compose..."
docker compose -f ${COMPOSE_FILE} up -d

# Check if Docker Compose was successful
if [ $? -ne 0 ]; then
    echo "Failed to start services with Docker Compose!"
    exit 1
fi

echo "Services started successfully."
