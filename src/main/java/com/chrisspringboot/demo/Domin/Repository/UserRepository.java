package com.chrisspringboot.demo.Domin.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.chrisspringboot.demo.Domin.Model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
