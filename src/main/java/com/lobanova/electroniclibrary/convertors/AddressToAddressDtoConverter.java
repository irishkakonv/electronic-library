package com.lobanova.electroniclibrary.convertors;

import com.lobanova.electroniclibrary.dtos.AddressDto;
import com.lobanova.electroniclibrary.entities.Address;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class AddressToAddressDtoConverter implements Converter<Address, AddressDto>{

    @Override
    public AddressDto convert(Address address) {
        return AddressDto.builder()
                .id(address.getId())
                .usersIds(address.getUsers().stream().map(user -> user.getId()).collect(Collectors.toSet()))
                .country(address.getCountry())
                .city(address.getCity())
                .build();
    }
}
