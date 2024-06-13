#!/bin/bash
#docker load -i kezboards.tar
#docker-compose -f compose-production.yaml down
#docker-compose -f compose-production.yaml up

# Define variables
GET_TAR_FILE="kezboards-get.tar"
PUT_TAR_FILE="kezboards-put.tar"
POST_TAR_FILE="kezboards-post.tar"
DELETE_TAR_FILE="kezboards-delete.tar"
COMPOSE_FILE="compose-production.yaml"

# Load the Docker image from the tar file
echo "Loading Docker images..."
docker load -i ${GET_TAR_FILE}
docker load -i ${PUT_TAR_FILE}
docker load -i ${POST_TAR_FILE}
docker load -i ${DELETE_TAR_FILE}

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
