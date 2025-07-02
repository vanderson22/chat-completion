package br.com.home.ia.chat.services;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

    private final ChatModel chatModel;

    public ChatService(ChatModel chatModel) {
        this.chatModel = chatModel;
    }

     public String getResponse(String prompt){

        return chatModel.call(prompt);
     }

     public String getResponseWithOptions(String param) {
        var response = chatModel.call(
            new Prompt(
                param,
                OpenAiChatOptions.builder()
                    .model("gpt-4o")
                    .maxTokens(255)
                    .temperature(0.4)
                .build()
            )
        );
        return response.getResult().getOutput().getText();
     }
}
