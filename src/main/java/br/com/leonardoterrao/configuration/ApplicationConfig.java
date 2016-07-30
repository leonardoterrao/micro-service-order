package br.com.leonardoterrao.configuration;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import javax.inject.Named;

@Configuration
public class ApplicationConfig {

    @Named
    static class JerseyConfig extends ResourceConfig {
        public JerseyConfig() {
            this.packages("br.com.leonardoterrao.rest");
        }
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
