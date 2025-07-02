package br.com.home.ia.chat.services;

import java.util.Map;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.stereotype.Service;

import br.com.home.ia.chat.models.RecipeRequest;

@Service
public class RecipeService {

    private final ChatModel chatModel;

    public RecipeService(ChatModel chatModel) {
        this.chatModel = chatModel;
    }

     public String createRecipe(RecipeRequest recipeRequest){

        //https://spring.io/blog/2025/04/14/spring-ai-prompt-engineering-patterns
        var template = """
             Crie uma receita de comida com os seguintes ingredientes: {ingredients}.
             As instruções devem ser: {instructions}.
             As restrições dietéticas são: {dietaryRestrictions}
        """;

        PromptTemplate promptTemplate = new PromptTemplate(template);
        Map<String, Object> params = Map.of(
            "ingredients", recipeRequest.getIngredients(),
            "instructions", recipeRequest.getInstructions(),
            "dietaryRestrictions", recipeRequest.getDietaryRestrictions()
        );

        Prompt prompt = promptTemplate.create(params);

        return chatModel.call(prompt).getResult().getOutput().getText();
     }

}
