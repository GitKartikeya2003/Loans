package com.example.Loans;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@OpenAPIDefinition(     //Swagger part
		info = @Info(
				title = "Loans microservice Rest api documentation",
				description = "YashBank Loans microservice REST Api documentation",
				version = "v1",
				contact = @Contact(
						name = "Kartikeya Gupta",
						email = "kartikeyayash4@gmail.com",
						url = "https://www.linkedin.com/in/kartikeya02112003/"
				),
				license = @License(
						name = "Apache 2.0",
						url = "http://LicenseLink"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "External Documentation ",
				url = "http://ExternalDocsLink"
		)
)
public class LoansApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoansApplication.class, args);
	}

}
