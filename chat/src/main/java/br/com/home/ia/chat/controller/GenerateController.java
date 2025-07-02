package br.com.home.ia.chat.controller;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import br.com.home.ia.chat.models.RecipeRequest;
import br.com.home.ia.chat.services.ChatService;
import br.com.home.ia.chat.services.RecipeService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class GenerateController {

    
    private final ChatService chatService;
    private final RecipeService recipeService;

    public GenerateController(ChatService chatService, RecipeService recipeService) {
        this.chatService = chatService;
        this.recipeService = recipeService;
    }

    @GetMapping("/chat/ai")
    public ResponseEntity<String> getResponse(@RequestParam String param) {
        String resposta = chatService.getResponse(param);
        return ResponseEntity.ok(resposta);
    }

    @GetMapping("/chat/ai/options")
    public ResponseEntity<String> getResponseWithOptions(@RequestParam String param) {
        String resposta = chatService.getResponseWithOptions(param);
        return ResponseEntity.ok(resposta);
    }
 
    @PostMapping("/recipes")
    public ResponseEntity<String> createRecipe(@RequestBody RecipeRequest params) {
        System.out.println(params);
        return ResponseEntity.ok(recipeService.createRecipe(params));
    }
}
