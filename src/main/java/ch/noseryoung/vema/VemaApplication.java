package ch.noseryoung.vema;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class VemaApplication {

	public static void main(String[] args) {
		SpringApplication.run(VemaApplication.class, args);
	}

}
