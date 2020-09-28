package com.lobanova.electroniclibrary.dtos;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class AddressDto {

    private Integer id;
    private String country;
    private String city;
}
