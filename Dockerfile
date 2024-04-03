# Use AdoptOpenJDK base image for Java
FROM eclipse-temurin:21

# Set the working directory inside the container
WORKDIR /app

# Copy the packaged Spring Boot JAR file into the container at /app
COPY target/dailyRJava-0.0.1-SNAPSHOT.jar /app/dailyRJava.jar

# Specify the command to run your Spring Boot application when the container starts
CMD ["java", "-jar", "dailyRJava.jar"]