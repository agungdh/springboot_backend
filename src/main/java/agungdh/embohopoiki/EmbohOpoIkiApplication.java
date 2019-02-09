package agungdh.embohopoiki;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class EmbohOpoIkiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmbohOpoIkiApplication.class, args);
	}

}

