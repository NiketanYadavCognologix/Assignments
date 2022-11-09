package com.cognologix.HttpMethods.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

	@Bean
	public Docket postApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("com.cognologix.HttpMethods")  //package name where there is main class
				.apiInfo(apiInfo())
				.select()
				.paths(PathSelectors.any())				
				.build();
	}
	public ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("CRUD basic operations by Niketan")	//custom (user define) name for Page Title
				.description("Simple understandable swagger application")		//custom (user define) description
				.termsOfServiceUrl("http://www.cognocrud.com")			//custom (user define) url for terms
				.license("Licence @ Niketan")									//custom (user define) license name
				.licenseUrl("http://www.cognocrud.com/licence")					//custom (user define) license url
				.version("1.0")
				.build();
	}
}
