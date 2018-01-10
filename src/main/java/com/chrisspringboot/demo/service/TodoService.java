package com.chrisspringboot.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.chrisspringboot.demo.Domin.Model.Todo;
import com.chrisspringboot.demo.Domin.Repository.TodoRepository;

@Service
public class TodoService {

	@Autowired
	private TodoRepository todoRepository;

	public List<Todo> getAllTodos() {
		Sort sortByCreatedAtDesc = new Sort(Sort.Direction.DESC, "createdAt");
		return todoRepository.findAll(sortByCreatedAtDesc);
	}

	public Todo CreateTodo(Todo todo) {
		todo.setCompleted(false);
		return todoRepository.save(todo);
	}

	public Todo getTodoById(String id) {
		return todoRepository.findOne(id);
	}
	
	public Todo updateTodo(Todo todo) {
		return todoRepository.save(todo);
	}
	
	public void deleteTodo(String id) {
		todoRepository.delete(id);
	}

}
