package com.dstodo.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dstodo.todolist.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long>{

}
