# spring-cloud-samples

Simple implementations of some of [Spring Cloud] services

- Each service calls [config-service] to get their configuration files.
- Each service register itself with [Netflix] Eureka.
- The [gateway-service] adds proxy and load balancing to greeting services registered with Eureka.
- The [admin-server] brings up an easy way to consult [actuator] services.

# Installation
This project has no extra external dependencies, you just need to import as a maven project and then run in the root project:

```sh 
mvn clean install
```
# Starting

To start the project, you have two options:

## Manually

The boot order is:
1. config-service
2. eureka-service
3. greeting-instance
4. gateway-service
5. admin-service


## With [Docker Compose] 

First, initialize the [Swarm] mode:

```
docker swarm init
```

Then create the overlay network:

```
docker network create -d overlay spring-cloud-network
```

In the first run and after a project re-build, use:

```
docker-compose up --build --force-recreate --scale greeting-instance=3
```

After that, you can just use:

```
docker-compose up --scale greeting-instance=3
```

The `--scale greeting-instance=3` option will start tree instances of that service, you can choose the number you want.

# Services and panels

Greeting service can be called through gateway-service at localport 8080
```sh
curl http://localhost:8080/greeting
```
To see the currently registered services you can navigate in your preferred browser to the address:
```sh
http://localhost:8761
```
The admin portal will show you all the info from the exposed actuator services. In this sample they all are exposed with no security. (Never replicate this in a production scenario).

Admin portal has a basic auth system:

|   user    |   password   |
| --------- | ------------ |
|   admin   |    secret    |

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
[Docker Compose]: <https://docs.docker.com/compose/install/>
[Swarm]: <https://docs.docker.com/engine/swarm/>
