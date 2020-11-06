package com.lambdaschool.todos.services;

import com.lambdaschool.todos.models.Todos;
import com.lambdaschool.todos.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Transactional
@Service(value = "todosService")
public class TodosServiceImpl implements TodosService {

    @Autowired
    private TodoRepository todoRepository;


    @Transactional
    @Override
    public Todos markComplete(Todos todos, long todoid)
    {
         Todos currentTodo = todoRepository.findById(todoid)
                .orElseThrow(() -> new EntityNotFoundException("Todo " + todoid + " Not Found" ));

       if (currentTodo.getDescription() != null)
       {
           currentTodo.setDescription(todos.getDescription());
       }
       if (currentTodo.getUsers() != null)
       {
           currentTodo.setUsers(todos.getUsers());
       }


       return todoRepository.save(currentTodo);
    }
}
