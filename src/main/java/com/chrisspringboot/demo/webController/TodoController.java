package com.chrisspringboot.demo.webController;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chrisspringboot.demo.Domin.Model.Todo;
import com.chrisspringboot.demo.service.TodoService;

/**
 * 
 * @author rz73506
 *todo: please add controller exception handler
 */
@RestController
@RequestMapping("/api")
@CrossOrigin("localhost:4200")
public class TodoController {

	private TodoService todoService;

	@Autowired
	public TodoController(TodoService todoService) {
		this.todoService = todoService;
	}

	@GetMapping("/todos")
	public List<Todo> getAllTodos() {
		return todoService.getAllTodos();
	}

	@PostMapping("/todos")
	public Todo createTodo(@Valid @RequestBody Todo todo) {
		return todoService.CreateTodo(todo);
	}

	@GetMapping(value = "/todos/{id}")
	public ResponseEntity<Todo> getTodoById(@PathVariable("id") String id) {
		Todo todo = todoService.getTodoById(id);
		if (todo == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(todo, HttpStatus.OK);
		}
	}

	@PutMapping(value = "/todos/{id}")
	public ResponseEntity<Todo> updateTodo(@PathVariable("id") String id,
			@Valid @RequestBody Todo todo) {
		Todo todoData = todoService.getTodoById(id);
		if (todoData == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		todoData.setTitle(todo.getTitle());
		todoData.setCompleted(todo.getCompleted());
		Todo updatedTodo = todoService.updateTodo(todoData);
		return new ResponseEntity<>(updatedTodo, HttpStatus.OK);

	}

	@DeleteMapping(value = "/todos/{id}")
	public void deleteTodo(@PathVariable("id") String id) {
		todoService.deleteTodo(id);
	}
}
