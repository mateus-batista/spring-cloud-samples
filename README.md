# spring-cloud-samples

Simple implementations of some of [Spring Cloud] services

- Each service calls [config-service] to get their configuration files.
- Each service register itself with [Netflix] Eureka.
- The [gateway-service] adds proxy and load balancing to greeting services registered with Eureka.
- The [admin-server] brings up an easy way to consult [actuator] services.

# Installation
This project has no extra external dependencys, you just need to import as a maven project.
# Starting
For now, the project doesn't have a boot script so you need to do it manually.
The boot order is:
1. config-service
2. eureka-service
3. greeting-instance1
4. greeting-instance2
5. gateway-service
6. admin-service

# Services and panels

Greeting service can be called through gateway-service at localport 8080
```sh
curl http://localhost:8080/greeting
```
To see the currently registed services you can navigate in your preferred browser to the address:
```sh
http://localhost:8761
```
The admin portal will show you all the info from de exposed actuator services. In this sample they all are exposed with no security. (Never replicate this in a production cenario).

Admin portal has a basic auth system:
|   user    |   password   |
| --------- | ------------ |
|   user    |   password   |

In your preferred browser, navigate to:
```sh
http://localhost:8500
```
All the services here are simple examples of its on projects, configured to work together.
More services, tests, and examples will come.

[config-service]: <https://cloud.spring.io/spring-cloud-config/> 
[Netflix]: <https://cloud.spring.io/spring-cloud-netflix/>
[Spring Cloud]: <http://projects.spring.io/spring-cloud/>
[gateway-service]: <https://cloud.spring.io/spring-cloud-gateway/>
[admin-server]: <https://github.com/codecentric/spring-boot-admin>
[actuator]: <https://spring.io/guides/gs/actuator-service/>
