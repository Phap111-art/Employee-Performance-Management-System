FROM openjdk:19

# Thêm tệp JAR vào hệ thống
ADD jar/management-employee.jar management-employee.jar

# Mở cổng cho ứng dụng
EXPOSE 8080

# Chạy ứng dụng
ENTRYPOINT ["java","-jar","management-employee.jar"]