package com.jlyon.ToDoRestApi.service;

import com.jlyon.ToDoRestApi.entity.Todo;
import com.jlyon.ToDoRestApi.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
public class TodoService {
	@Autowired
	private TodoRepository repository;

	// CREATE
	public Todo create(Todo newTodo) {
		return repository.save(newTodo);
	}

	public List<Todo> createAll(List<Todo> newTodos) {
		return repository.saveAll(newTodos);
	}

	// READ
	public List<Todo> getAll() {
		return repository.findAll();
	}

	public Todo getOneById(Integer id) {
		return repository.findById(id).orElse(null);
	}

	public Todo getOneByName(String name) {
		return repository.findOneByName(name);
	}

	// UPDATE
	public Todo updateTodo(Todo newTodo) {
		Todo oldTodo = repository.findById(newTodo.getId()).orElse(null);
		if (oldTodo == null) {
			// TODO: Throw Up Nicely
		}
		return this.create(newTodo);
	}

	// DELETE
	public String deleteTodo(Integer id) {
		repository.deleteById(id);
		return "successfully deleted todo with id: " + id;
	}
}
