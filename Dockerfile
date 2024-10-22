# TCP server
# BUild jars
FROM arm64v8/openjdk:17 AS builder
WORKDIR /app
COPY . /app
RUN ./gradlew build

# Create server image
FROM arm64v8/openjdk:17 AS server
WORKDIR /app
COPY --from=builder /app/build/libs/tcp-server.jar /app/tcp-server.jar
ENTRYPOINT ["java", "-jar", "/app/tcp-server.jar"]

# Create client image
FROM arm64v8/openjdk:17 AS client
WORKDIR /app
COPY --from=builder /app/build/libs/tcp-client.jar /app/tcp-client.jar
ENTRYPOINT ["java", "-jar", "/app/tcp-client.jar"]