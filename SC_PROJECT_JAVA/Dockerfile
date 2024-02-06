# Use an official OpenJDK runtime as the base image
FROM openjdk:8-jdk-alpine

# Set the working directory to /app
WORKDIR /app

# Copy the current directory contents into the container at /app
COPY . /app

# Compile the application
RUN mvn clean package

# Set the command to run the application
CMD ["java", "-jar", "target/SpringFolderTaskApplication.jar"]