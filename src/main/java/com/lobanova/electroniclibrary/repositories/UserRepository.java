package com.lobanova.electroniclibrary.repositories;

import com.lobanova.electroniclibrary.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
