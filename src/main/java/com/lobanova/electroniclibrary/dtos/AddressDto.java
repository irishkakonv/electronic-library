package com.lobanova.electroniclibrary.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = { "id", "usersIds"})
public class AddressDto {

    private Long id;
    private Set<Long> usersIds;
    private String country;
    private String city;
}
