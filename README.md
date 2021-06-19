# Rest-Api-Practice
Rest Api Practice Using Spring Boot and Spring Data Jpa

In this small project we have created a small RestApi's that talk to in memory-database and give us the responses.

Below are few URL's of the Rest API

--> To get all students - GET Request
http://localhost:8081/students

--> To find student by roll_no -GET Request
http://localhost:8081/students/1
Here 1 is the roll_no, if student does not exists in table, it will throw exception and gives user friendly jsonmessage as shown below.
{
"message": "Student with RollNo 10 Not Found",
"timestamp": "2021-06-19T02:58:13.832+00:00",
"details": "uri=/students/10"
}


-->To add new student -POST Request
http://localhost:8081/

Input JSON:
{
"rollNo": 10,
"name": "Bhavesh",
"city": "Pune"
}

--> To Update the existing student details -> PUT Request
http://localhost:8081/students/1
First it will check, if student exists in table by his roll no. i.e. 1 in this case.
If not exists, it will throw the error Student_Not_Found.

If student exists in table it will update the details.
Input JSON:
{
"rollNo": 10,
"name": "Bhavesh",
"city": "Pune"
}

--> Delete a student from a table - DELETE Request
http://localhost:8081/students/2
First it will check, if student exists in table by his roll no. i.e. 2 in this case.
If not exists, it will throw the error Student_Not_Found.

If student exists in table it will delete the student from database.

Below URL give information about all Rest API's in this same project.
http://localhost:8081/swagger-ui/


As we are using embeded database 
Under resources we have create a data.sql file as below:

INSERT INTO STUDENT (ROLL_NO,CITY,NAME) VALUES(1,'Pune','Bhavesh');
INSERT INTO STUDENT (ROLL_NO,CITY,NAME) VALUES(2,'Pune','Adesh');
INSERT INTO STUDENT (ROLL_NO,CITY,NAME) VALUES(3,'Pune','Pooja');

In application.properties we have below property configurations:

server.port=8081
spring.h2.console.enabled=true
spring.datasource.url=jdbc:h2:mem:testdb
spring.data.jpa.repositories.bootstrap-mode=default
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=create
spring.jpa.defer-datasource-initialization=true
