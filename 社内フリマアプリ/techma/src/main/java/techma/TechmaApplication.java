package techma;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

@SpringBootApplication
public class TechmaApplication {

	public static void main(String[] args) {
		SpringApplication.run(TechmaApplication.class, args);
	}
}
