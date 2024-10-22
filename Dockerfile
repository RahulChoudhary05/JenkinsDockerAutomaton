 
FROM openjdk
WORKDIR /app
COPY . /app
RUN javac testsell.java
CMD ["java" , "testsell"]
