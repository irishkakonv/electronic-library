package com.lobanova.electroniclibrary.utils;

import com.lobanova.electroniclibrary.dtos.AddressDto;
import com.lobanova.electroniclibrary.entities.Address;

public class AddressUtil {

    public static final String country = "country";
    public static final String city = "city";

    public static AddressDto getInputAddress() {
        AddressDto inputAddress = new AddressDto();
        inputAddress.setCountry(country);
        inputAddress.setCity(city);
        return inputAddress;
    }

    public static AddressDto getOutputAddress() {
        AddressDto outputAddress = new AddressDto();
        outputAddress.setCountry(country);
        outputAddress.setCity(city);
        outputAddress.setId(1L);
        return outputAddress;
    }

    public static Address getConvertedAddress() {
        return new Address(country, city);
    }

    public static Address getSavedAddress() {
        Address savedAddress = new Address(country, city);
        savedAddress.setId(1L);
        return savedAddress;
    }
}
