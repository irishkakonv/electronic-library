package com.lobanova.electroniclibrary.dtos;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class TokenDto {
    private final  String token;
}
