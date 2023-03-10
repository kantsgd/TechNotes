FROM eclipse-temurin:19-jdk-alpine
ENV OTEL_METRICS_EXPORTER none
COPY target/example-0.0.1-SNAPSHOT.jar example.jar
COPY ../agent/opentelemetry-javaagent.jar opentelemetry-javaagent.jar
EXPOSE 8080
ENTRYPOINT ["java","-javaagent:opentelemetry-javaagent.jar", "-Dotel.exporter.otlp.endpoint=http://otel-collector:4317","-jar", "example.jar"]