package DIOProjetoDesignPattern.Spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Projeto Design Pattern com Spring
 * Usado Intellij com os plugins:
 * Plugin JPA Buddy
 * Plugin Spring Initializr and Assistant
 *
 * @author Wallid
 */

@EnableFeignClients
@SpringBootApplication

public class DesignPatternSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesignPatternSpringApplication.class, args);
	}

}
