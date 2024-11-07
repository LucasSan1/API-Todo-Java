package com.dstodo.desafio_todolist.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.dstodo.desafio_todolist.entity.Todo;
import com.dstodo.desafio_todolist.repository.TodoRepository;

@Service
public class TodoService {
    private TodoRepository todoRepository; 


    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }
    

    public List<Todo> create(Todo todo){
        todoRepository.save(todo);
        return list();
    }

    public List<Todo> list(){
        Sort sort = Sort.by("prioridade").descending().and(
            Sort.by("nome").ascending()
        );
        return todoRepository.findAll(sort);
    }

    public List<Todo> update(Long id, Todo todo){
        Todo todoExistente = todoRepository.findById(id).orElse(null);

        if (todoExistente == null) {
            throw new RuntimeException("Tarefa não encontrada com id: " + id);
        }

        todoExistente.setNome(todo.getNome());
        todoExistente.setDescricao(todo.getDescricao());
        todoExistente.setRealizado(todo.getRealizado());
        todoExistente.setPrioridade(todo.getPrioridade());

        todoRepository.save(todoExistente);
        return list();
    }

    public List<Todo> delete(Long id){
        todoRepository.deleteById(id);
        return list();
    }
}
