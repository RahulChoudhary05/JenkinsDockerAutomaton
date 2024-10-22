# Use an official Gradle image with JDK as the base image for building
FROM gradle:7.6.0-jdk17 AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the entire project to the container
COPY . .

# Ensure the Gradle wrapper has execute permissions (if applicable)
RUN chmod +x gradlew

# Run the Gradle build to compile the Java files
RUN ./gradlew build --stacktrace --info --no-daemon

# Use a smaller JDK image for the runtime environment
FROM openjdk:17-jdk-slim

# Set the working directory for the runtime environment
WORKDIR /app

# Copy the built classes from the build stage
COPY --from=build /app/build/classes/java/main/ .  

# Specify the command to run the Java application
CMD ["java", "_Gradle_Project.testsell"]
