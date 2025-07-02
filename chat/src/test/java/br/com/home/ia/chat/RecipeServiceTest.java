package br.com.home.ia.chat;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import br.com.home.ia.chat.services.RecipeService;
import br.com.home.ia.chat.models.RecipeRequest;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.model.Generation;
import org.springframework.ai.chat.messages.AssistantMessage;
import org.springframework.ai.chat.prompt.Prompt;

public class RecipeServiceTest {
    @Mock
    private ChatModel chatModel;
    @Mock
    private ChatResponse chatResponse;
    @Mock
    private Generation generation;
    @Mock
    private AssistantMessage assistantMessage;
    private RecipeService recipeService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        recipeService = new RecipeService(chatModel);
    }

    @Test
    public void exemploTeste() {
        // Exemplo simples de teste
        assertTrue(true);
    }

    @Test
    public void testCreateRecipe() {
        // Arrange
        RecipeRequest request = new RecipeRequest();
        request.setIngredients("frango, arroz");
        request.setInstructions("assar o frango, cozinhar o arroz");
        request.setDietaryRestrictions("sem glúten");

        String expectedRecipe = "Receita gerada pela IA";

        System.out.println("[TEST] Iniciando testCreateRecipe");
        System.out.println("[TEST] Request: " + request);

        when(chatModel.call(any(Prompt.class))).thenReturn(chatResponse);
        when(chatResponse.getResult()).thenReturn(generation);
        when(generation.getOutput()).thenReturn(assistantMessage);
        when(assistantMessage.getText()).thenReturn(expectedRecipe);

        // Act
        String result = recipeService.createRecipe(request);

        // Assert
        System.out.println("[TEST] Resultado retornado: " + result);
        assertTrue(result.equals(expectedRecipe));
        verify(chatModel, times(1)).call(any(Prompt.class));
        System.out.println("[TEST] testCreateRecipe finalizado com sucesso!");
    }
}
