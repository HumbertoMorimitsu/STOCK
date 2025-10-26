package com.estoque.controle.estoque.OpenAIChatGpt;


import com.estoque.controle.estoque.OpenAIChatGpt.service.ChatGPTService;
import com.estoque.controle.estoque.product.jpa.Product;
import com.estoque.controle.estoque.product.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chat")

public class ChatGptController {
    private final ChatGPTService chatGPTService;
    private final ProductRepository produtoRepository;

    public ChatGptController(ChatGPTService chatGPTService, ProductRepository produtoRepository) {
        this.chatGPTService = chatGPTService;
        this.produtoRepository = produtoRepository;
    }

    @PostMapping("/buscar")
    public List<Product> buscarProdutos(@RequestBody String prompt) {
        String resposta = chatGPTService.askGPT(
                "Interprete a consulta a seguir e retorne apenas o nome do produto buscado, sem explicações: " + prompt
        );
        return produtoRepository.findByNameContainingIgnoreCase(resposta);
    }

    @PostMapping("/questions")
    public String Question(@RequestBody String question){
        var totalProdutos = produtoRepository.count();
        var context = "Você é um assistente que conhece o estoque da empresa. " +
                "Atualmente temos " + totalProdutos + " produtos cadastrados. " +
                "Responda de forma clara e útil à pergunta do usuário.";

        var response = chatGPTService.askGPT(context + "/nPergunta" + question);
        return response;
    }
}
