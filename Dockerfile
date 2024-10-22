 
FROM openjdk
WORKDIR /lib/src/main/java/_Gradle_Project
COPY ./app .
RUN javac testsell.java
CMD ["java" , "testsell"]
