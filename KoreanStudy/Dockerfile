# Use official OpenJDK image
FROM eclipse-temurin:17-jdk

# Set working directory
WORKDIR /app

# Copy project files
COPY . .

# Build the app
RUN ./gradlew clean build -x test

# Run the app
CMD ["java", "-jar", "build/libs/KoreanStudy-0.0.1-SNAPSHOT.jar"]