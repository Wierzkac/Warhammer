# Use an OpenJDK base image
FROM openjdk:21-jdk

# Copy the JAR file from the host machine into the container
COPY Warhammer.jar /app/Warhammer.jar

# Set the working directory inside the container
WORKDIR /app

# Expose the port that Spring Boot application listens on
EXPOSE 8080

# Command to run the Spring Boot application when the container starts
CMD ["java", "-jar", "Warhammer.jar"]