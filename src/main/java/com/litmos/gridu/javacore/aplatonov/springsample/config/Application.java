package com.litmos.gridu.javacore.aplatonov.springsample.config;

import com.litmos.gridu.javacore.aplatonov.springsample.entities.Item;
import com.litmos.gridu.javacore.aplatonov.springsample.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@Configuration
@ComponentScan(basePackages = "com.litmos.gridu.javacore.aplatonov.springsample")
@EntityScan("com.litmos.gridu.javacore.aplatonov.springsample")
@EnableGlobalMethodSecurity(securedEnabled = false)
@EnableJpaRepositories("com.litmos.gridu.javacore.aplatonov.springsample.repository")
public class Application {

	@Autowired
	ItemRepository itemRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		itemRepository.save(new Item("White Polo",13.33, 23));
		itemRepository.save(new Item("Black Polo",15.55, 45));
		itemRepository.save(new Item("Yellow Polo",14.33, 8));
		itemRepository.save(new Item("Green Polo",16.33, 45));
		return null;
	}

}


