package com.lobanova.electroniclibrary.services;

import com.lobanova.electroniclibrary.DataBase;
import com.lobanova.electroniclibrary.entities.Address;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    public List<Address> getAllAddresses() {
        return DataBase.addresses;
    }

    public Address getAddressById(Integer id) {
        Optional<Address> oldAddress =  getAllAddresses().stream().filter(address -> address.getId().equals(id)).findFirst();
        return oldAddress.orElse(null);
    }

    public boolean addAddress(Address address) {
        return getAllAddresses().add(address);
    }

    public boolean updateAddress (Address address) {
        boolean isUpdated = false;
        Address oldAddress = getAddressById(address.getId());
        List<Address> addresss = getAllAddresses();
        if (oldAddress == null) {
            addresss.add(address);
            isUpdated = true;
        } else if (!oldAddress.equals(address)) {
            addresss.remove(addresss.indexOf(oldAddress));
            addresss.add(address);
            isUpdated = true;
        }
        return isUpdated;
    }

    public void deleteAddresses(Integer id) {
        Address addressForDelete = getAddressById(id);
        List<Address> addresses = getAllAddresses();
        if (addressForDelete != null) {
            addresses.remove(addresses.indexOf(addressForDelete));
        }
    }
}
