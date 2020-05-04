package com.springmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.springmongo.model.User;

@Repository
@CrossOrigin(origins = "http://localhost:4200")
public interface UserRepository extends MongoRepository<User, Long>{

}
