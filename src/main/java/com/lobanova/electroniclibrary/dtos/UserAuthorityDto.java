package com.lobanova.electroniclibrary.dtos;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserAuthorityDto {

    private String userRole;
}
