FROM openjdk:19

# Thêm tệp JAR vào hệ thống
ADD jar/myapp.jar myapp.jar

# Mở cổng cho ứng dụng
EXPOSE 8080

# Chạy ứng dụng
ENTRYPOINT ["java","-jar","myapp.jar"]