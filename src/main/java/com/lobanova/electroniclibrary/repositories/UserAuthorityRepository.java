package com.lobanova.electroniclibrary.repositories;

import com.lobanova.electroniclibrary.entities.UserAuthority;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAuthorityRepository extends CrudRepository<UserAuthority, Long>{
}
