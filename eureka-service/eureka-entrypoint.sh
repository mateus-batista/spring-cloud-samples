#!/bin/sh

while ! nc -z config-service 8888 ; do
    echo "Waiting for upcoming Config Server"
    sleep 2
done

java -jar /opt/spring-cloud-samples/lib/eureka-service-1.0.0.RELEASE.jar