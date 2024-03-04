# Use an OpenJDK base image
FROM adoptopenjdk/openjdk21:alpine-jre

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file from the host machine into the container
COPY Warhammer.jar /app/Warhammer.jar

# Expose the port that Spring Boot application listens on
EXPOSE 8080

# Command to run the Spring Boot application when the container starts
CMD ["java", "-jar", "Warhammer.jar"]