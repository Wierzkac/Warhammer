# Use Gradle to build the application
FROM gradle:8.5-jdk17 AS build

# Set working directory
WORKDIR /app

# Copy the entire project
COPY . .

# Build the application
RUN gradle build -x test

# Runtime stage
FROM eclipse-temurin:17-jre-jammy

# Create app user
RUN addgroup --system --gid 1001 appuser && \
    adduser --system --uid 1001 --ingroup appuser appuser

# Set working directory
WORKDIR /app

# Copy the built JAR from build stage
COPY --from=build /app/build/libs/Warhammer-0.0.1-SNAPSHOT.jar /app/Warhammer.jar

# Change ownership to app user
RUN chown -R appuser:appuser /app

# Switch to app user
USER appuser

# Expose the port
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "Warhammer.jar"]