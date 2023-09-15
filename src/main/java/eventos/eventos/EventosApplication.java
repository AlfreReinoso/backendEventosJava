package eventos.eventos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@SpringBootApplication
public class EventosApplication {

	public static void main(String[] args) {

		// SpringApplication.run(EventosApplication.class, args);
		SpringApplication app = new SpringApplication(EventosApplication.class);
		String port = System.getenv("PORT");
		app.setDefaultProperties(Collections.singletonMap("server.port", port == null ? "8080" : port));
		app.run(args);
	}
}
