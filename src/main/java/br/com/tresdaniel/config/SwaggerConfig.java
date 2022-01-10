package br.com.tresdaniel.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("br.com.tresdaniel"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(apiInfo());
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfo("RESTFul API With Spring Boot 2.1.3", 
				"Some description about your API", 
				"v1", 
				"Terms of Service Url", 
				new Contact("Daniel Silva", "github.com/tresdaniel", "tres.daniel.s@gmail.com"),
				"License of API",
				"License of URL", 
				Collections.emptyList());
	}
}
