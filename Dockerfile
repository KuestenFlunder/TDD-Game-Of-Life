# Use a generic Maven image with JDK 17
FROM maven:3.8.3-openjdk-17-slim as build

# Set working directory
WORKDIR /app

# Copy the pom.xml and src code to the container
COPY ./pom.xml ./pom.xml
COPY ./src ./src

# Package the application
RUN mvn clean package -DskipTests

# Use the official OpenJDK image as the base image for the runtime environment
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy the jar file built in the build stage
COPY --from=build /app/target/*.jar /app/app.jar

# Command to run the application
CMD ["java", "-jar", "app.jar"]
