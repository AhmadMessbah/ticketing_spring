package ir;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class Spring03Application {
    public static void main(String[] args) {
        SpringApplication.run(Spring03Application.class, args);
        log.info("Spring Boot Application Started");

//        AppTest.firstTest();
    }
}
