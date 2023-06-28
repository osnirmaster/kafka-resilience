package br.com.osnirmaster.producer.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
//@EnableSpringDataWebSupport
//@EnableCaching
/* For war file artifact
 * public class ForumApplication extends SpringBootServletInitializer {
 */
public class AppApplication {
    public static void main(String[] args) {
        SpringApplication.run(AppApplication.class, args);
    }

}