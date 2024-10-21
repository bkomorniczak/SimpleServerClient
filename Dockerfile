# TCP server
FROM arm64v8/openjdk:17 AS server-build
WORKDIR /app
COPY target/tcp-server-0.0.1-SNAPSHOT.jar /app/tcp-server.jar

# TCP client
FROM arm64v8/openjdk:17 AS client-build
WORKDIR /app
COPY target/tcp-client-0.0.1-SNAPSHOT.jar /app/tcp-client.jar

# Final image for server
FROM arm64v8/openjdk:17 AS server
WORKDIR /app
COPY --from=server-build /app/tcp-server.jar /app/tcp-server.jar
ENTRYPOINT ["java", "-jar", "/app/tcp-server.jar"]

# Final image for client
FROM arm64v8/openjdk:17 AS client
WORKDIR /app
COPY --from=client-build /app/tcp-client.jar /app/tcp-client.jar
ENTRYPOINT ["java", "-jar", "/app/tcp-client.jar"]