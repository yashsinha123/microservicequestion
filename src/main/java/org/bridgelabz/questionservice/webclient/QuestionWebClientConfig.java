package org.bridgelabz.questionservice.webclient;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class QuestionWebClientConfig {
    @Bean
    public WebClient questionsWebClient() {
        return WebClient.create("http://localhost:8081"); // Assuming questionservice runs on port 8081
    }
}
