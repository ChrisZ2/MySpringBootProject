package com.chrisspringboot.demo.webController;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chrisspringboot.demo.Domin.Model.Todo;
import com.chrisspringboot.demo.service.TodoService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class Controller {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Controller.class);
	
	private TodoService todoService;
	
	@Autowired
	public Controller(TodoService todoService) {
		this.todoService = todoService;
	}
	
	@GetMapping("/")
    public List<Todo> HomePage() {
        List<Todo> list = null;
        try {
        	list = todoService.getAllTodos();
        }catch(Exception ex) {
        	LOGGER.info(ex.getMessage());
        }
        return list;
    }
}
