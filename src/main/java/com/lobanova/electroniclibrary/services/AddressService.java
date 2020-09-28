package com.lobanova.electroniclibrary.services;

import com.lobanova.electroniclibrary.DataBase;
import com.lobanova.electroniclibrary.dtos.AddressDto;
import com.lobanova.electroniclibrary.entities.Address;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AddressService {

    private AddressDto convertAddressToAddressDto(Address address) {
        return AddressDto.builder().id(address.getId()).country(address.getCountry()).city(address.getCity()).build();
    }

    private Address convertAddressDtoToAddress(AddressDto addressDto) {
        return Address.builder().id(getAddressId()).city(addressDto.getCity()).country(addressDto.getCountry()).build();
    }

    public List<AddressDto> getAllAddresses() {
        return DataBase.addresses.stream()
                .map(this::convertAddressToAddressDto)
                .collect(Collectors.toList());
    }

    public AddressDto getAddressDtoById(Integer id) {
        Address address = getAddressById(id);
        return address != null ? convertAddressToAddressDto(address) : null;
    }

    private Address getAddressById(Integer id) {
        Optional<Address> oldAddress =  DataBase.addresses.stream().filter(address -> address.getId().equals(id)).findFirst();
        return oldAddress.orElse(null);
    }

    private Integer getAddressId() {
        return DataBase.addresses.get(DataBase.addresses.size()).getId() + 1;
    }

    public boolean addAddress(AddressDto addressDto) {
        return DataBase.addresses.add(convertAddressDtoToAddress(addressDto));
    }

    public boolean updateAddress (AddressDto addressDto) {
        boolean isUpdated = false;
        Address oldAddress = getAddressById(addressDto.getId());
        Address newAddress = convertAddressDtoToAddress(addressDto);
        List<Address> addresses = DataBase.addresses;
        if (oldAddress == null) {
            addresses.add(newAddress);
            isUpdated = true;
        } else if (!oldAddress.equals(newAddress)) {
            addresses.remove(addresses.indexOf(oldAddress));
            addresses.add(newAddress);
            isUpdated = true;
        }
        return isUpdated;
    }

    public void deleteAddresses(Integer id) {
        Address addressForDelete = getAddressById(id);
        List<Address> addresses = DataBase.addresses;
        if (addressForDelete != null) {
            addresses.remove(addresses.indexOf(addressForDelete));
        }
    }
}
