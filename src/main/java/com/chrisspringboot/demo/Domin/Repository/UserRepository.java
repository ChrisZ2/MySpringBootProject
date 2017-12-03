package com.chrisspringboot.demo.Domin.Repository;

import com.chrisspringboot.demo.Domin.Model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository implements MongoRepository<User, String> {
}
