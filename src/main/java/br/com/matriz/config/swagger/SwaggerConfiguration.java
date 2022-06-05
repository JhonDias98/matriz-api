package br.com.matriz.config.swagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public GroupedOpenApi matrizApi() {
        return GroupedOpenApi.builder()
                .group("matriz-service")
                .pathsToMatch("/**")
                .build();
    }

    @Bean
    public OpenAPI matrizOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Matriz API")
                        .description("API para rotacionar uma matriz quadrada")
                        .version("v0.0.1")
                        .contact(contact()));
    }

    private Contact contact() {
        Contact contact = new Contact();
        contact.setName("Jonathan Dias");
        contact.setUrl("https://github.com/JhonDias98");
        contact.setEmail("jonathan.dias.p98@gmail.com");

        return contact;
    }
}
