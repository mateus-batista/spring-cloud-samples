FROM openjdk:8-jdk-alpine
COPY target/config-service-1.0.0.RELEASE.jar /opt/spring-cloud-samples/lib/
ENTRYPOINT ["/usr/bin/java"]
CMD ["-jar", "/opt/spring-cloud-samples/lib/config-service-1.0.0.RELEASE.jar"]