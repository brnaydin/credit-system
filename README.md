
Credit System Java Springboot backend project

Application requirements;

----------------------------------------------------------------------------------------------------------------
DB Server: 
Up and running postgresql server is required. Below configurations have to be adapted to your environment. 
database name : credit_system
port : 5432
spring.datasource.url=jdbc:postgresql://localhost:5432/credit_system
spring.datasource.username=postgres
spring.datasource.password=123456

OR 

H2 database can be used. Configuration must be done

After all, data.sql must be executed in order to create tables and load demo data. 
----------------------------------------------------------------------------------------------------------------

Swagger is implemented and is accessible with following url;
http://localhost:8080/api/swagger-ui.html

----------------------------------------------------------------------------------------------------------------


ER (Entitiy Relationship Diagram)

![image](https://user-images.githubusercontent.com/20181602/155897501-257972bb-b2ff-4163-ac03-8bdc9918a015.png)




