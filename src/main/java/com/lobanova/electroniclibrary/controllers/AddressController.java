package com.lobanova.electroniclibrary.controllers;

import com.lobanova.electroniclibrary.entities.Address;
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
@RequestMapping("/address")
public class AddressController {

    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping(path ="/get-all")
    public List<Address> getAllAddresss() {
        return addressService.getAllAddresses();
    }

    @GetMapping(path = "{id}")
    public Address getAddressById(@PathVariable("id") Integer id) {
        return addressService.getAddressById(id);
    }

    @PostMapping
    public Address addAddress(@RequestBody Address newAddress) {
        return newAddress != null && addressService.addAddress(newAddress) ? newAddress : null;
    }

    @PutMapping
    public Address updateAddress(@RequestBody Address updatedAddress) {
        return addressService.updateAddress(updatedAddress) ? updatedAddress : null;
    }

    @PutMapping(path = "/delete/{id}")
    public void deleteAddresses(@PathVariable("id") Integer id) {
        addressService.deleteAddresses(id);
    }
}
