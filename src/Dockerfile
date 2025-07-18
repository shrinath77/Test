# Start with OpenJDK base image
FROM openjdk:17-jdk-alpine

# Set working directory inside the container
WORKDIR /app

# Copy Maven wrapper and POM file
COPY .mvn/ .mvn
COPY mvnw mvnw
COPY pom.xml .

# Make mvnw executable & pre-download dependencies
RUN chmod +x mvnw && ./mvnw dependency:go-offline

# Copy source code
COPY src src

# Build the app
RUN ./mvnw clean package -DskipTests

# Run the app
CMD ["java", "-jar", "target/springboot-simple-api-1.0.0.jar"]
