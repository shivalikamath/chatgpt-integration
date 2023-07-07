package com.github.chatgptsample.chatgptsample.controller;

import com.github.chatgptsample.chatgptsample.dto.ChatRequest;
import com.github.chatgptsample.chatgptsample.dto.ChatResponse;
import com.github.chatgptsample.chatgptsample.service.ChatGPTService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/v1")
public class ChatController {

    private final ChatGPTService chatGPTService;

    @PostMapping(value = "/chat", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ChatResponse chat(@RequestBody ChatRequest chatRequest) {
        return chatGPTService.chat(chatRequest);
    }

}