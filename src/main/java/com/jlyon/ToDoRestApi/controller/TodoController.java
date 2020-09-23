package com.jlyon.ToDoRestApi.controller;

import com.jlyon.ToDoRestApi.entity.Todo;
import com.jlyon.ToDoRestApi.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/todo")
public class TodoController {
	@Autowired
	private TodoService service;

	// CREATE
	@PostMapping
	public List<Todo> createTodos(@RequestBody List<Todo> newTodos) {
		return service.createAll(newTodos);
	}

	// READ
	@GetMapping
	public List<Todo> query(@RequestParam("subject") String subject) {
		if (subject == null || subject.isBlank()) return service.getAll();

		return (List<Todo>) service.getOneBySubject(subject);
	}

	@GetMapping("/{id}")
	public Todo findById(@PathVariable Integer id) {
		return service.getOneById(id);
	}

//	@GetMapping
//	public Todo findBySubject(@RequestParam("subject") String subject) {
//		return service.getOneBySubject(subject);
//	}

	// UPDATE
	@PostMapping("/{id}")
	public Todo updateTodo(@RequestBody Todo newTodo) {
		return service.updateTodo(newTodo);
	}

	// DELETE
	@DeleteMapping("/{id}")
	public String deleteTodo(@PathVariable Integer id) {
		return service.deleteTodo(id);
	}
}
