package com.lobanova.electroniclibrary.repositories;

import com.lobanova.electroniclibrary.entities.CustomUserDetails;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDetailsRepository extends CrudRepository<CustomUserDetails, Long> {

    Optional<UserDetails> findByUsername(String userName);
}
