package com.nbenja.springboot.app;

import com.nbenja.springboot.domain.Product;
import com.nbenja.springboot.repository.ProductRepository;

import org.apache.commons.lang3.RandomUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.stream.Stream;

@EnableJpaRepositories(basePackages = "com.nbenja.springboot.repository")
@EntityScan("com.nbenja.springboot.domain")
@SpringBootApplication(scanBasePackages = "com.nbenja.springboot")
public class ApiVersionApplication {

	@Bean
	public CommandLineRunner commandLineRunner(ProductRepository productRepository){
		return args -> {
			Stream.of("apple", "samsung", "pixel").forEach(p -> productRepository.save(new Product(p, RandomUtils.nextDouble(500, 800))));
			productRepository.findAll().forEach(System.out::println);
		};


	}

	public static void main(String[] args) {
		SpringApplication.run(ApiVersionApplication.class, args);
	}
}
