FROM eclipse-temurin:21.0.2_13-jdk-jammy AS builder
WORKDIR /app

COPY .mvn .mvn/
COPY mvnw pom.xml ./
COPY order-service-application/pom.xml order-service-application/pom.xml
COPY order-service-container/pom.xml order-service-container/pom.xml
COPY order-service-domain/pom.xml order-service-domain/pom.xml
COPY order-service-infrastructure/pom.xml order-service-infrastructure/pom.xml
COPY order-service-infrastructure/order-service-jpa/pom.xml order-service-infrastructure/order-service-jpa/pom.xml
RUN --mount=type=cache,target=/root/.m2 ./mvnw dependency:go-offline

COPY order-service-application/src/ order-service-application/src/
COPY order-service-container/src/ order-service-container/src/
COPY order-service-domain/src/ order-service-domain/src/
COPY order-service-infrastructure/order-service-jpa/src/ order-service-infrastructure/order-service-jpa/src/
RUN --mount=type=cache,target=/root/.m2 ./mvnw clean install
RUN ls -la /app/order-service-container/

FROM eclipse-temurin:21.0.2_13-jre-jammy AS final
WORKDIR /app
EXPOSE 8080
COPY --from=builder /app/order-service-container/target/*.jar /app/*.jar
ENTRYPOINT ["java", "-jar", "/app/*.jar"]