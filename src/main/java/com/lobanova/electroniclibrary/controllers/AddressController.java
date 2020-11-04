package com.lobanova.electroniclibrary.controllers;

import com.lobanova.electroniclibrary.dtos.AddressDto;
import com.lobanova.electroniclibrary.services.AddressService;
import com.lobanova.electroniclibrary.services.impl.AddressServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/addresses")
public class AddressController {

    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping
    public Set<AddressDto> getAllAddresses() {
        return addressService.getAll();
    }

    @PostMapping
    public AddressDto create(@RequestBody @NonNull AddressDto newAddress) {
        return addressService.create(newAddress);
    }

    @GetMapping(path = "/{id}")
    public AddressDto read(@PathVariable("id") @NonNull Long id) {
        return addressService.read(id);
    }


    @PutMapping
    public AddressDto updateAddress(@RequestBody @NonNull AddressDto updatedAddress) {
        return addressService.update(updatedAddress);
    }

    @PutMapping(path = "/delete/{id}")
    public void deleteAddresses(@PathVariable("id") @NonNull Long id) {
        addressService.delete(id);
    }
}
