package co.com.sofka.crud.web.controller;

import co.com.sofka.crud.domain.ToDoDTO;
import co.com.sofka.crud.domain.repository.IToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class TodoController {

    @Autowired
    private IToDoRepository service;

    @GetMapping(value = "api/todos")
    public Iterable<ToDoDTO> list(){
        return service.list();
    }
    
    @PostMapping(value = "api/todo")
    public ToDoDTO save(@RequestBody ToDoDTO toDoDTO){
        return service.save(toDoDTO);
    }

    @PutMapping(value = "api/todo")
    public ToDoDTO update(@RequestBody ToDoDTO todo){
        if(todo.getId() != null){
            return service.save(todo);
        }
        throw new RuntimeException("No existe el id para actualziar");
    }

    @DeleteMapping(value = "api/{id}/todo")
    public void delete(@PathVariable("id")Long id){
        service.delete(id);
    }

    @GetMapping(value = "api/{id}/todo")
    public ToDoDTO get(@PathVariable("id") Long id){
        return service.get(id);
    }

}
