
FROM openjdk:19


ADD jar/management-employee.jar management-employee.jar
COPY src/main/resources/templates/fragment/alert /alert
COPY src/main/resources/templates/fragment/input /input
COPY src/main/resources/templates/fragment/layout /layout
COPY src/main/resources/templates/fragment/manage /manage
COPY src/main/resources/templates/fragment/modal /modal
ADD /upload /upload
EXPOSE 8080
ENTRYPOINT ["java","-jar","management-employee.jar"]
