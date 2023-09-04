package Hibernate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppForAccessToHibernate {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(AppForAccessToHibernate.class);
        application.run(args);
    }
}
