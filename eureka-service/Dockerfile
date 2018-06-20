FROM openjdk:8-jdk-alpine
RUN apk --no-cache add netcat-openbsd
COPY eureka-entrypoint.sh /opt/spring-cloud-samples/bin/
COPY target/eureka-service-1.0.0.RELEASE.jar /opt/spring-cloud-samples/lib/
RUN chmod 755 /opt/spring-cloud-samples/bin/eureka-entrypoint.sh