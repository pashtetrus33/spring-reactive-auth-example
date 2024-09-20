package ru.skillbox.spring_reactive_auth_example.configuration;

import lombok.Data;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Data
@Configuration
@ConfigurationProperties(prefix = "app.security")
@ConditionalOnProperty(prefix = "app.security", name = "type", havingValue = "inMemory")
public class InMemoryUserProperties {

    private String type;
    private List<User> users;

    @Data
    public static class User {
        private String username;
        private String password;
        private List<String> roles;
    }
}