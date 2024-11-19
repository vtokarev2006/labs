package com.lt.spring.labs.repositories;

import com.lt.spring.labs.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {


}
