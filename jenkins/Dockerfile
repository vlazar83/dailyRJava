FROM jenkins/jenkins

# Expose ports 8080 and 50000 for Jenkins web UI and agent communication
EXPOSE 8080 50000

# Define a volume for Jenkins home directory
VOLUME /var/jenkins_home

# Set restart policy to 'on-failure'
# Note: This restart policy requires Docker 1.12 or higher
# If you are using an older version of Docker, you may need to handle restarts externally
CMD ["--restart=on-failure"]

USER root
RUN apt-get update && apt-get install -y openjdk-19-jdk
USER jenkins