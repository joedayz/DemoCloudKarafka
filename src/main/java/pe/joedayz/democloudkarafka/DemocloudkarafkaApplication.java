package pe.joedayz.democloudkarafka;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemocloudkarafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemocloudkarafkaApplication.class, args);
	}

	@Bean
	public ApplicationRunner runner(Producer producer){
		return (args) -> {
			for (int i = 0; i < 20; i++) {
				producer.send(new SampleMessage(i, "A simple message"));
			}
		};
	}
}
