package com.estoque.controle.estoque.OpenAIChatGpt.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@Service
public class ChatGPTService {

    @Value("${openai.api.key}")
    private String apiKey;

    @Value("${openai.api.url}")
    private String apiUrl;

    public String askGPT(String prompt) {
        WebClient webClient = WebClient.builder()
                .baseUrl(apiUrl)
                .defaultHeader("Authorization", "Bearer " + apiKey)
                .build();

        Map<String, Object> requestBody = Map.of(
                "model", "gpt-4o-mini",
                "messages", new Object[]{
                        Map.of("role", "system", "content", "Você é um assistente que entende consultas sobre estoque de produtos."),
                        Map.of("role", "user", "content", prompt)
                }
        );

        Map response = webClient.post()
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(Map.class)
                .block();

        try {
            return (String) ((Map) ((Map) ((java.util.List) response.get("choices")).get(0)).get("message")).get("content");
        } catch (Exception e) {
            return "Erro ao processar resposta do ChatGPT";
        }
    }
}
