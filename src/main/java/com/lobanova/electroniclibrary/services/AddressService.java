package com.lobanova.electroniclibrary.services;

import com.lobanova.electroniclibrary.dtos.AddressDto;
import com.lobanova.electroniclibrary.entities.Address;

public interface AddressService extends Service<AddressDto> {

    Address getOrCreateAddress(String country, String city);
}
