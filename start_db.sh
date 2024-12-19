#!/bin/bash

# Variables
DB_NAME="my_db"
DB_USER="user"
DB_PASSWORD="password"
CONTAINER_NAME="postgres-container"
POSTGRES_PORT="5432"

# Pull the PostgreSQL image
echo "Pulling the PostgreSQL Docker image..."
docker pull postgres:latest

# Run the PostgreSQL container
echo "Starting the PostgreSQL container..."
docker run --name $CONTAINER_NAME -e POSTGRES_DB=$DB_NAME -e POSTGRES_USER=$DB_USER -e POSTGRES_PASSWORD=$DB_PASSWORD -p $POSTGRES_PORT:5432 -d postgres:latest
