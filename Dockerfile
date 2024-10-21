# Use an official OpenJDK 8 runtime as a base image
FROM openjdk:8

# Expose port 8080
EXPOSE 8080

# Add the JAR file from the target directory to the root of the container and rename it
ADD target/JenkinsDockerAutomation.jar /JenkinsDockerAutomation.jar

# Specify the command to run on container startup
ENTRYPOINT ["java", "-jar", "/JenkinsDockerAutomation.jar"]
