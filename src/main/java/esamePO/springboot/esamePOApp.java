package esamePO.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"esamePO.springboot"})

public class esamePOApp {
	public static void main(String[] args) {
		SpringApplication.run(esamePOApp.class, args);
	}
}
