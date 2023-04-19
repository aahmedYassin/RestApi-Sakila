

# REST Sakila Database Web Service

### Description
- This API allow  to access and retrieve data from many categories such as actor,film and others
  it build recently using Rest

### Documentation 
- https://documenter.getpostman.com/view/14564420/2s93XyU3Dy



##  Technologies
- ORM
- Maven
- Tomcat(apache-maven-3.8.6)
- JAX-WS Metro
- Mapstruct
- Lombok

## Getting Started
- Clone the repository to your computer
- open project in vscode
- Configure pom.xml
      <plugin>
        <groupId>org.apache.tomcat.maven</groupId>
        <artifactId>tomcat7-maven-plugin</artifactId>
        <version>2.2</version>
        <configuration>
          <username>{Tomcat userName}</username>
          <password>{Tomcat password}</password>
          <url>http://localhost:{Tomcat port}/manager/text</url>
          <path>/SakilaApplication</path>
        </configuration>
      </plugin>
 - persistence.xml
         <properties>
            <property name="jakarta.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/sakila"/>
            <property name="jakarta.persistence.jdbc.user" value="{database userName}"/>
            <property name="jakarta.persistence.jdbc.password" value="database password"/>
          </properties>

Deploy the application on tomcat server using command "mvn clean install tomcat7:deploy"

The web services will now be available at http://localhost:9090/Sakila. You can use a tool like Postman to interact with the services.

##  EndPoints
 - Actor
 - Film
 - Category
 - Address
 - City
 - Country
 - Staff
 - Customer
 - Store

## Run with Maven


- cmd 
mvn clean compile tomcat7:redeploy





