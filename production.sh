#!/bin/bash

# Define variables
GET_TAR_FILE="kezboards-get.tar"
PUT_TAR_FILE="kezboards-put.tar"
POST_TAR_FILE="kezboards-post.tar"
DELETE_TAR_FILE="kezboards-delete.tar"
DB_TAR_FILE="kezboards-db.tar"
API_GATEWAY_TAR_FILE="kezboards-api-gateway.tar"
COMPOSE_FILE="compose-production.yaml"

# Load the Docker image from the tar file
echo "Loading Docker images..."
docker load -i ${GET_TAR_FILE}
docker load -i ${PUT_TAR_FILE}
docker load -i ${POST_TAR_FILE}
docker load -i ${DELETE_TAR_FILE}
docker load -i ${DB_TAR_FILE}
docker load -i ${API_GATEWAY_TAR_FILE}

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
