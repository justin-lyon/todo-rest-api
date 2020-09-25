package com.jlyon.todorestapi.unittest;

import com.jlyon.todorestapi.entity.Todo;
import com.jlyon.todorestapi.repository.TodoRepository;
import com.jlyon.todorestapi.service.TodoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class TodoServiceTest {
	@InjectMocks
	private TodoService service;
	@Mock
	private TodoRepository repository;

	@BeforeEach
	public void setup() {
		initMocks(this);
	}

	@Test
	public void createAll_givenTodos_shouldSaveTodos() {
		final int TODO_COUNT = 2;
		List<Todo> newTodos = createTodos(TODO_COUNT);

		when(repository.saveAll(newTodos)).thenReturn(newTodos);
		List<Todo> savedTodos = service.createAll((newTodos));
		verify(repository).saveAll(newTodos);

		assertEquals(TODO_COUNT, savedTodos.size());
	}

	private List<Todo> createTodos(int count) {
		List<Todo> todos = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			todos.add(new Todo("subject" + i, "description" + i));
		}
		return todos;
	}
}
