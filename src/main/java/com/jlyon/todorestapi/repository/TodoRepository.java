package com.jlyon.todorestapi.repository;

import com.jlyon.todorestapi.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Integer> {
	Todo findOneBySubject(String subject);
}
