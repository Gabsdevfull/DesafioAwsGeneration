package org.generation.generationstudents.infra.springdoc;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfigurations {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info()
                        .title("Alunos Generation Brasil")
                        .description(" Esta API armazena dados dos alunos de uma escola. Os dados" +
                                "a serem armazenados são: ID, nome, idade, notas, nome do professor" +
                                "e numero da sala")
                        .version("0.0.1")
                        .contact(new Contact()
                                .name("por email")
                                .email("gabrielpvarandas1995@gmail.com"))
                        .license(new License()
                                .name("Licença MIT")
                                .url("https://www.mit.edu/~amini/LICENSE.md"))

                );
    }

}
