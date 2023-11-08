# demo-spring-boot-jpa-w-postgresql

## Description
This is a simple project that builds a Spring Boot backend with JPA and PostgreSQL. Using API Level, Service Layer and Data Access Layer and only one table.
It was created a few JUnit5 tests so I could learn how it would be configurated.
To execute this project you can try just Running DemoApplication.java, if you want to buil a jar you can package the project and it will be generated inside target folder.

## Project Structure
```
> src
> > main
> > > java
> > > > com.example.demo
> > > > > student
> > > > > > Student.class (This is @Entity and @Table)
> > > > > > StudentController.class (Student entity controller API Level)
> > > > > > StudentService.class (Student entity services Service Layer)
> > > > > > StudentRepository.class (Student entity repository Data Access Layer)
> > > > > > StudentConfig.class (Student entity init configurations, a runnable that inserts two users onto database in case they doesn't exist)
> > > > > DemoApplication.java (Just the SpringBootApplication where app is initiated)
> > > resources
> > > > application.properties (This is the file that's going to store some information about application and database connections. (Can be used outside the project using a command and a parameter: --spring.config.location={file location})
> > test
> > > java
> > > > com.example.demo
> > > > > DemoApplicationTests.java (Main test class that's is going to call other test using @ContextConfiguration)
> > > > > HttpRequestTest.java (Test class that's going to validate with MockMvc if '/' has connection OK)
> > > > > StudentTest.java (Test that checks if service and controller file exists and tries a connection with /api/v1/student)
> pom.xml (File that stores project configurations)
```

## Maven Dependecies
```
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-web</artifactId>
</dependency>

<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>

<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-test</artifactId>
  <scope>test</scope>
</dependency>

<dependency>
  <groupId>org.postgresql</groupId>
  <artifactId>postgresql</artifactId>
</dependency>
```

## Starting out:
You will need an IDE, I used IntelliJ, the Java Version used on this project was 21.0.1.

## Authors:
``` Octávio Marques ```

## License:
[MIT](https://choosealicense.com/licenses/mit/)
