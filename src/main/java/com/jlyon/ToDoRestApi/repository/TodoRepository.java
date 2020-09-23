package com.jlyon.ToDoRestApi.repository;

import com.jlyon.ToDoRestApi.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Integer> {
	Todo findOneBySubject(String subject);
}
