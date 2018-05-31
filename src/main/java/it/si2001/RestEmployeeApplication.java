package it.si2001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class RestEmployeeApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestEmployeeApplication.class, args);
    }
}
