package com.mpk;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.mpk.entities.card.CharacterCard;
import com.mpk.entities.card.trait.Clan;
import com.mpk.entities.card.trait.PersonTrait;
import com.mpk.services.CharacterCardService;
import liquibase.integration.spring.SpringLiquibase;
import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.sql.DataSource;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
@EnableJpaRepositories("com.mpk.repositories")
@EnableSwagger2
public class Application extends SpringBootServletInitializer {
    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(Application.class, args);
    }
    @Autowired
    CharacterCardService characterCardService;
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }
    /*@Bean
    public String fillDataCharacterCard() throws Exception {
        Set<PersonTrait> personTraits = new HashSet<>();
        personTraits.add(PersonTrait.BUSHI);
        personTraits.add(PersonTrait.SHUGENJA);
        personTraits.add(PersonTrait.CHAMPION);
        CharacterCard card1 = new CharacterCard("Togashi Jokuni", "Action: Choose a triggered ability printed on another character – this character gains that ability until the end of the phase. (Max 1 per round.)", Clan.DRAGON, 5, 5, 5, 3, "What transpires in our mountains is a mere pebble against the avalanche that is coming.", personTraits, false);
        characterCardService.saveCard(card1);
        personTraits = new HashSet<>();
        personTraits.add(PersonTrait.COURTIER);
        characterCardService.saveCard(new CharacterCard("Bayushi Kachiko", "While this character is participating in a Political conflict, choose a participating character with lower Political skill than this character – move the chosen character home. Then, you may bow it.", Clan.SCORPION, 5, 3, 6, 3, "Which of us would bid this game to end? We are nearly perfectly matched, but there can only be one victor.", personTraits, true));
        return "Model complited";
    }*/
    @Bean
    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
        MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        jsonConverter.setObjectMapper(objectMapper);
        return jsonConverter;
    }

    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select().apis(RequestHandlerSelectors.basePackage("com.pracownia.spring.controllers"))
                .build();
    }
}
