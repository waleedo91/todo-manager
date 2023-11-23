package com.waleed.todomanager.repository;

import com.waleed.todomanager.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TodoRepository extends JpaRepository<Todo, Long> {
}
