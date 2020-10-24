package com.lobanova.electroniclibrary.services.impl;

import com.lobanova.electroniclibrary.dtos.AddressDto;
import com.lobanova.electroniclibrary.entities.Address;
import com.lobanova.electroniclibrary.repositories.AddressRepository;
import com.lobanova.electroniclibrary.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class AddressServiceImpl implements AddressService{

    private final AddressRepository addressRepository;
    private final ConversionService conversionService;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository, ConversionService conversionService) {
        this.addressRepository = addressRepository;
        this.conversionService = conversionService;
    }

    @Override
    public AddressDto create(AddressDto dto) {
        Address address = conversionService.convert(dto, Address.class);
        address = addressRepository.save(address);
        return conversionService.convert(address, AddressDto.class);
    }

    @Override
    public AddressDto read(Long id) {
        Address address = addressRepository.findById(id).orElseThrow(RuntimeException::new);
        return conversionService.convert(address, AddressDto.class);
    }

    @Override
    public AddressDto update(AddressDto dto) {
        Address address = conversionService.convert(dto, Address.class);
        address = addressRepository.save(address);
        return conversionService.convert(address, AddressDto.class);
    }

    @Override
    public void delete(Long id) {
        addressRepository.deleteById(id);
    }

    @Override
    public Set<AddressDto> getAll() {
        List<Address> addresses = (List<Address>) addressRepository.findAll();
        return addresses.stream().map(author -> conversionService.convert(author, AddressDto.class)).collect(Collectors.toSet());
    }

    @Override
    public Address getOrCreateAddress(String country, String city) {
        Address address = addressRepository.findByCountryAndCity(country, city);
        if (address != null) {
            return address;
        } else {
            return addressRepository.save(new Address(country, city));
        }
    }
}

