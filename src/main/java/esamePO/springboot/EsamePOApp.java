package esamePO.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"esamePO.springboot"})

public class EsamePOApp {
	public static void main(String[] args) {
		SpringApplication.run(EsamePOApp.class, args);
	}
}
