package com.github.chatgptsample.chatgptsample.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ChatResponse {

    private String answer;
}
