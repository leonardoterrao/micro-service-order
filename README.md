# Microservice Order
## Microservices example

This is a very simple implementation about a project that works with microserives.

This example have five projects


| Project | Description |
|----|
|  [Parent Project](https://github.com/leonardoterrao/micro-service-customer/)  | Only maven configurations for the others projects |
|  [Model Project](https://github.com/leonardoterrao/micro-service-model/)  | The model classes used between the projects, to send and recive by interface rest |
|  [Customer Project](https://github.com/leonardoterrao/micro-service-customer/)  | This project control the Customers for the Order, and communicate with Order Project |
|  [Product Project](https://github.com/leonardoterrao/micro-service-product/)  | This project control the Products for the Order, and communicate with Order Project |
|  [Order Project](https://github.com/leonardoterrao/micro-service-order/)  | This project builds the order, and to build it need communicate with Customers and Products projects  |

To run this example you need checkout all these projects and run maven install.
Command to maven install:
`$ mvn install`

And after checkout and install, run the Customer Project, Product Project and Order Project.
Command to run:
`$ mvn spring-boot:run`

I have configured each project to run on different ports.
See: _src/main/resources/application.resources_

| Project | Port | Link |
|---|
| Customer Project | 8081 | localhost:8081/customer?id={id} |
| Product Project | 8082 | localhost:8082/product?id={id} |
| Order Project | 8083 | localhost:8083/order?idCustomer={idCustomer}&idProduct={idProduct}&amount={amount} |

Reference: [DZone](https://dzone.com/articles/spring-boot-creating)
