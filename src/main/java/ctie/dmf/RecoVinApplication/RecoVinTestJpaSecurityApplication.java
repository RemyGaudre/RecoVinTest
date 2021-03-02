package ctie.dmf.RecoVinApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import ctie.dmf.RecoVinApplication.repository.UserRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class RecoVinTestJpaSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecoVinTestJpaSecurityApplication.class, args);
	}

}
