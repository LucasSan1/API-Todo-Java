package com.dstodo.todolist.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.dstodo.todolist.entity.Todo;
import com.dstodo.todolist.repository.TodoRepository;

@Service
public class TodoService {
    private TodoRepository todoRepository; // Declara a dependência do repositório de tarefas

    // Construtor da classe, inicializa o repositório de tarefas via injeção de dependência
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository; 
    }

    // Método para criar uma nova tarefa e retornar a lista de tarefas ordenadas
    public List<Todo> create(Todo todo){
        todoRepository.save(todo); 
        return list(); 
    }

    // Método para listar todas as tarefas, ordenadas por prioridade (decrescente) e nome (crescente)
    public List<Todo> list(){
        Sort sort = Sort.by("prioridade").descending() 
                .and(Sort.by("nome").ascending()); 
        return todoRepository.findAll(sort); 
    }

    // Método para atualizar uma tarefa existente com base no ID
    public List<Todo> update(Long id, Todo todo){
        Todo todoExistente = todoRepository.findById(id).orElse(null);

        if (todoExistente == null) { // Se a tarefa não for encontrada, lança uma exceção
            throw new RuntimeException("Tarefa não encontrada com id: " + id); 
        }

        // Atualiza os campos da tarefa existente com os valores da nova tarefa
        todoExistente.setNome(todo.getNome());
        todoExistente.setDescricao(todo.getDescricao());
        todoExistente.setRealizado(todo.getRealizado());
        todoExistente.setPrioridade(todo.getPrioridade());

        todoRepository.save(todoExistente); 
        return list(); 
    }

    // Método para deletar uma tarefa pelo ID
    public List<Todo> delete(Long id){
        todoRepository.deleteById(id); 
        return list(); 
    }
}
