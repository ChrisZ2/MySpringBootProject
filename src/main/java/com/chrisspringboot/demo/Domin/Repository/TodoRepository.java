package com.chrisspringboot.demo.Domin.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.chrisspringboot.demo.Domin.Model.Todo;
@Repository
public interface TodoRepository extends MongoRepository<Todo, String> {

}
