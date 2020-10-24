package com.lobanova.electroniclibrary.convertors;

import com.lobanova.electroniclibrary.dtos.AddressDto;
import com.lobanova.electroniclibrary.entities.Address;
import com.lobanova.electroniclibrary.entities.User;
import com.lobanova.electroniclibrary.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AddressDtoToAddressConverter implements Converter<AddressDto, Address> {

    private final UserRepository userRepository;

    @Autowired
    public AddressDtoToAddressConverter(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Address convert(AddressDto addressDto) {
        Address address = new Address();
        address.setId(addressDto.getId());
        address.setUsers((List<User>) userRepository.findAllById(addressDto.getUsersIds()));
        address.setCountry(addressDto.getCountry());
        address.setCity(addressDto.getCity());
        return address;
    }
}
