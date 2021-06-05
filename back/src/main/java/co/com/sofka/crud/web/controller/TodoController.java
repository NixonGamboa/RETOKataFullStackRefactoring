package co.com.sofka.crud.web.controller;

import co.com.sofka.crud.domain.dto.CategoryDto;
import co.com.sofka.crud.domain.dto.ToDoDto;
import co.com.sofka.crud.domain.services.CategoryDTOService;
import co.com.sofka.crud.domain.services.ToDoDTOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class TodoController {

    @Autowired
    private ToDoDTOService service;

    @Autowired
    private CategoryDTOService categoryService;

    @GetMapping(value = "/todos")
    public Iterable<ToDoDto> list(){
        return service.list();
    }
    
    @PostMapping(value = "/save")
    public Iterable<CategoryDto> save(@RequestBody ToDoDto toDoDTO){
        service.save(toDoDTO);
        return categoryService.list() ;
    }

    @PutMapping(value = "/todo")
    public ToDoDto update(@RequestBody ToDoDto toDoDTO){
        if(toDoDTO.getId() != null){
            return service.save(toDoDTO);
        }
        throw new RuntimeException("No existe el id para actualziar");
    }

    @DeleteMapping(value = "/{id}/todo")
    public void delete(@PathVariable("id")Long id){
        service.delete(id);
    }

    @GetMapping(value = "/{id}/todo")
    public ToDoDto get(@PathVariable("id") Long id){
        return service.get(id);
    }

}
