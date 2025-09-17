# Use official OpenJDK runtime as base image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the Java source file to the container
COPY . /app

# Compile the Java program
RUN javac helloWorld.java

# Command to run when the container starts
CMD ["java", "helloWorld"]