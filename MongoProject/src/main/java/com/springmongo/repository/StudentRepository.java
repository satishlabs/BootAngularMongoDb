package com.springmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.springmongo.model.Student;

public interface StudentRepository extends MongoRepository<Student, Long>{

}
