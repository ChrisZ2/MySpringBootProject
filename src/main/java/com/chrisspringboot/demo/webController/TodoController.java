package com.chrisspringboot.demo.webController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chrisspringboot.demo.Domin.Repository.TodoRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class TodoController {
	
	
	@Autowired
	private TodoRepository todoRepository;
		
	
}
