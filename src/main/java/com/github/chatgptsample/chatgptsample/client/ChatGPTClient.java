package com.github.chatgptsample.chatgptsample.client;

import com.github.chatgptsample.chatgptsample.config.ChatGPTClientConfig;
import com.github.chatgptsample.chatgptsample.dto.ChatGPTRequest;
import com.github.chatgptsample.chatgptsample.dto.ChatGPTResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "openai",
        url = "${openai.urls.base-url}",
        configuration = ChatGPTClientConfig.class
)
public interface ChatGPTClient {

    @PostMapping(value = "${openai.urls.chat-url}", headers = {"Content-Type=application/json"})
    ChatGPTResponse chat(@RequestBody ChatGPTRequest chatGPTRequest);

}