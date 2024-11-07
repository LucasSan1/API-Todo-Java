package com.dstodo.desafio_todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dstodo.desafio_todolist.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long>{

}
