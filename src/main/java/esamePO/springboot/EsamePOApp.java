package esamePO.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"esamePO.springboot"})

/**
 * Questa classe è il main della nostra applicazione, l'applicazione sviluppata grazione al framework Spring.
 * E qui che avviene l'avvio dell'applicazione
 * 
 * @author denis bernovschi
 * 
 */
public class EsamePOApp {
	public static void main(String[] args) {
		SpringApplication.run(EsamePOApp.class, args);
	}
}
