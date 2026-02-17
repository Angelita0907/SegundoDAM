package LitMindSpring.LitMindSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = { "LitMindSpring.LitMindSpring.models", "utils" })
public class LitMindSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(LitMindSpringApplication.class, args);
	}

}
