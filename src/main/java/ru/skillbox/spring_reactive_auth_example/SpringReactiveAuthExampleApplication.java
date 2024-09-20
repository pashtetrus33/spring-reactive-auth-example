package ru.skillbox.spring_reactive_auth_example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@SpringBootApplication
public class SpringReactiveAuthExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringReactiveAuthExampleApplication.class, args);
    }

}
