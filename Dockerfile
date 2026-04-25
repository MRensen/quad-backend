# Build fase
FROM eclipse-temurin:21-jdk-alpine as build

# Install Maven
RUN apk add --no-cache maven

# Set working dir
WORKDIR /app

# Copy source files
COPY pom.xml .
COPY src ./src

# Build the jar using Spring Boot's repackage goal
RUN mvn clean package spring-boot:repackage -DskipTests

# Runtime fase
FROM eclipse-temurin:21-jre-alpine

# Set working dir
WORKDIR /app

# Copy only the necessary JAR from the build stage
COPY --from=build /app/target/*.jar app.jar

# Expose the port Spring Boot listens on
EXPOSE 8080

# Run the actual JAR
ENTRYPOINT ["java", "-jar", "app.jar"]