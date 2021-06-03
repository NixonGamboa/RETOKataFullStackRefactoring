package co.com.sofka.crud.web.controller;

import co.com.sofka.crud.domain.ToDoDTO;
import co.com.sofka.crud.domain.repository.IToDoRepository;
import co.com.sofka.crud.domain.services.ToDoDTOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class TodoController {

    @Autowired
    private ToDoDTOService service;

    @GetMapping(value = "/todos")
    public Iterable<ToDoDTO> list(){
        return service.list();
    }
    
    @PostMapping(value = "/todo")
    public ToDoDTO save(@RequestBody ToDoDTO toDoDTO){
        return service.save(toDoDTO);
    }

    @PutMapping(value = "/todo")
    public ToDoDTO update(@RequestBody ToDoDTO todo){
        if(todo.getId() != null){
            return service.save(todo);
        }
        throw new RuntimeException("No existe el id para actualziar");
    }

    @DeleteMapping(value = "/{id}/todo")
    public void delete(@PathVariable("id")Long id){
        service.delete(id);
    }

    @GetMapping(value = "/{id}/todo")
    public ToDoDTO get(@PathVariable("id") Long id){
        return service.get(id);
    }

}
