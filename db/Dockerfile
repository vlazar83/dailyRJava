# Use the official PostgreSQL image from Docker Hub
FROM postgres:latest

# Set environment variables
ENV POSTGRES_USER=admin
ENV POSTGRES_PASSWORD=admin
ENV POSTGRES_DB=readings

# Copy SQL scripts to initialize the database
COPY init.sql /docker-entrypoint-initdb.d/