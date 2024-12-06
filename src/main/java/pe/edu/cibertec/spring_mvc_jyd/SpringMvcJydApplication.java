package pe.edu.cibertec.spring_mvc_jyd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pe.edu.cibertec.spring_mvc_jyd.entity.Film;
	import pe.edu.cibertec.spring_mvc_jyd.repository.FilmRepository;


@SpringBootApplication
public class SpringMvcJydApplication {

	@Autowired
	FilmRepository filmRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringMvcJydApplication.class, args);
	}



}
