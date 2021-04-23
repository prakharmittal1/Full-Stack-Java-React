Dependencies:
•	Spring Web
•	Lombok
•	MySQL Driver
•	Spring Data JPA

VS code extensions used:
•	Java Extension Pack
•	Spring Boot extension
•	Lombok Annotations Support

Database: MySQL database hosted on Docker:
1.	docker pull mysql
2.	docker run --name mysqldb -e MYSQL_ROOT_PASSWORD=Password -e MYSQL_DATABASE=myd –d –p 3306:3306 mysql:latest

Steps to run the project:
Clone the project: git clone https://github.com/prakharmittal1/Full-Stack-Java-React

For Backend: 
1.	cd backend
2.	mvn spring-boot:run

For Frontend:
1.	cd frontend
2.	npm install
3.	npm start

You can check the API responses on: http://localhost:8080/api/
React Server on: http://localhost:3000/

Helpful Links and Resources:
•	https://materializecss.com/
•	https://github.com/thombergs/code-examples/tree/master/spring-boot/spring-boot-testing
•	https://reflectoring.io/unit-testing-spring-boot/
•	https://www.npmjs.com/package/axios
•	https://www.postman.com/
•	https://code.visualstudio.com/docs/java/java-testing
