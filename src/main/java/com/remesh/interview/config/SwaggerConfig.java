package com.remesh.interview.config;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
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
		return new Docket(DocumentationType.SWAGGER_2).groupName("interview").apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.remesh.interview.controller")).paths(regex("/.*"))
				.build();
	}

	private ApiInfo apiInfo() {
		final Contact contact = new Contact("HN", "", "hasitha.nekkalapu@gmail.com");
		final ApiInfoBuilder info = new ApiInfoBuilder();
		info.contact(contact);
		info.title("Message Filter");
		info.description(
				"This Controller provides the API for filtering messages by  any combination of users, ages, sexes, incomes, or living environments.");
		return info.build();
	}
}