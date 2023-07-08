
FROM openjdk:19

COPY jar/management-employee.jar management-employee.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","management-employee.jar"]