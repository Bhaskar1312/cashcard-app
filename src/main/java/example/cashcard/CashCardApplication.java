package example.cashcard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CashCardApplication {

    public static void main(String[] args) {
        SpringApplication.run(CashCardApplication.class, args);
    }

}

//./gradlew clean build test
// ./gradlew bootRun
// curl http://localhost:8080/banner
// curl http://localhost:8080/list