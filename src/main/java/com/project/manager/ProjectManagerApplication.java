package com.project.manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ImportAutoConfiguration(classes = {JerseyConfig.class, PersistenceConfig.class})
@ComponentScan(basePackages = {"com.project.manager"})
public class ProjectManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectManagerApplication.class, args);
    }
}
