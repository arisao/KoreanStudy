FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY gradlew ./
COPY gradle ./gradle
COPY build.gradle settings.gradle ./

RUN ./gradlew dependencies --no-daemon || return 0

COPY . .

RUN ./gradlew build -x test --no-daemon

CMD ["java", "-Dserver.port=$PORT", "-jar", "build/libs/KoreanStudy-0.0.1-SNAPSHOT.jar"]
