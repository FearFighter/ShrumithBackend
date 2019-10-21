package shruthi.amith;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(exclude= HibernateJpaAutoConfiguration.class)
public class ShrumithBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShrumithBackendApplication.class,args);
    }
}
