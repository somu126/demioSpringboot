# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-alpine

# Set the working directory
WORKDIR /app

# Copy the built JAR file into the container
COPY target/*.jar app.jar

# Expose the application port (adjust if needed)
EXPOSE 8085

# Run the application
CMD ["java", "-jar", "app.jar"]
