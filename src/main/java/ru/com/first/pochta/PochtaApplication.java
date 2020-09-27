package ru.com.first.pochta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ru.com.first.pochta.repository.ParselsRepository;

@SpringBootApplication
public class PochtaApplication {

	public static void main(String[] args) {	    
		SpringApplication.run(PochtaApplication.class, args);
	}

}
