package com.github.chatgptsample.chatgptsample.service;

import com.github.chatgptsample.chatgptsample.client.ChatGPTClient;
import com.github.chatgptsample.chatgptsample.config.ChatGPTClientConfig;
import com.github.chatgptsample.chatgptsample.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class ChatGPTService {

    private final ChatGPTClient chatGPTClient;
    private final ChatGPTClientConfig chatGPTClientConfig;

    private final static String ROLE_USER = "user";

    public ChatResponse chat(ChatRequest chatRequest) {
        Message message = Message.builder()
                .role(ROLE_USER)
                .content(chatRequest.getQuestion())
                .build();
        ChatGPTRequest chatGPTRequest = ChatGPTRequest.builder()
                .model(chatGPTClientConfig.getModel())
                .messages(Collections.singletonList(message))
                .build();
        ChatGPTResponse chatGPTResponse = chatGPTClient.chat(chatGPTRequest);
        return ChatResponse.builder().answer(chatGPTResponse.getChoices().get(0).getMessage().getContent()).build();
    }
}