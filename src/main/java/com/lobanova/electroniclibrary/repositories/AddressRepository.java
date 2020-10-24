package com.lobanova.electroniclibrary.repositories;

import com.lobanova.electroniclibrary.entities.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends CrudRepository<Address, Long> {

    Address findByCountryAndCity(String country, String city);
}
