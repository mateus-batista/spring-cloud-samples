#!/bin/sh

while ! nc -z eureka-service 8761 ; do
    echo "Waiting for upcoming Eureka Server"
    sleep 2
done

java -jar -Dspring.profiles.active=docker,secure /opt/spring-cloud-samples/lib/admin-server-1.0.0.RELEASE.jar