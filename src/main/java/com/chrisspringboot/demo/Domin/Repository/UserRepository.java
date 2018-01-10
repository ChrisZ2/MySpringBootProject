package com.chrisspringboot.demo.Domin.Repository;

import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
