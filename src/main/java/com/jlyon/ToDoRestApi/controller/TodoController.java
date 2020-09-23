package com.jlyon.ToDoRestApi.controller;

import com.jlyon.ToDoRestApi.entity.Todo;
import com.jlyon.ToDoRestApi.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class TodoController {
	@Autowired
	private TodoService service;

	// CREATE
	@PostMapping
	public Todo saveTodo(@RequestBody Todo newTodo) {
		return service.create(newTodo);
	}

	@PostMapping
	public List<Todo> saveTodos(@RequestBody List<Todo> newTodos) {
		return service.createAll(newTodos);
	}

	// https://youtu.be/IucFDX3RO9U?t=1352
//	public List<Todo> getAll()
}
