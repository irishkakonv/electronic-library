package com.lobanova.electroniclibrary.controllers;

import com.lobanova.electroniclibrary.dtos.AddressDto;
import com.lobanova.electroniclibrary.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/addresses")
public class AddressController {

    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping
    public List<AddressDto> getAllAddresses() {
        return addressService.getAllAddresses();
    }

    @GetMapping(path = "{id}")
    public AddressDto getAddressById(@PathVariable("id") Integer id) {
        return addressService.getAddressDtoById(id);
    }

    @PostMapping
    public AddressDto addAddress(@RequestBody AddressDto newAddress) {
        return newAddress != null && addressService.addAddress(newAddress) ? newAddress : null;
    }

    @PutMapping
    public AddressDto updateAddress(@RequestBody AddressDto updatedAddress) {
        return addressService.updateAddress(updatedAddress) ? updatedAddress : null;
    }

    @PutMapping(path = "/delete/{id}")
    public void deleteAddresses(@PathVariable("id") Integer id) {
        addressService.deleteAddresses(id);
    }
}
