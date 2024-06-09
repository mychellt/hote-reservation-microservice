package gft.challenge.hotel.reservation.application;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "gft.challenge.hotel.reservation")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
