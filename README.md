

# REST Sakila Database Web Service

### Description
- This API allow  to access and retrieve data from many categories such as actor,film and others
  it build recently using Rest

### Documentation 
- https://documenter.getpostman.com/view/14564420/2s93XyU3Dy


# Database
- mysql> SOURCE C:/temp/sakila-db/sakila-schema.sql;
- mysql> SOURCE C:/temp/sakila-db/sakila-data.sql;

##  Technologies
- ORM
- Maven
- Tomcat(apache-maven-3.8.6)
- JAX-WS Metro
- Mapstruct
- Lombok

##  EndPoints
 - actor
 - film
 - category
 - address
 - city
 - country
 - staff
 - customer
 - store

## Run with Maven

- pom.xml.
Change the configuration of Tomcat 
     http://localhost:port/manager/text

- cmd 
mvn clean compile tomcat7:redeploy





