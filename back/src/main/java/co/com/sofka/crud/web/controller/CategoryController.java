package co.com.sofka.crud.web.controller;

import co.com.sofka.crud.domain.dto.CategoryDto;
import co.com.sofka.crud.domain.services.CategoryDTOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/categories")
@CrossOrigin(origins = "http://localhost:3000")
public class CategoryController {
    @Autowired
    private CategoryDTOService service;

    @GetMapping()
    public Iterable<CategoryDto> list(){
        return service.list();
    }

    @PostMapping(value = "/save")
    public CategoryDto save(@RequestBody CategoryDto categoryDto){
        return service.save(categoryDto);
    }

    /* @PutMapping(value = "/update")
    public CategoryDto update(@RequestBody CategoryDto categoryDto){
        if(categoryDto.getCategoryId() != null){
            return service.save(categoryDto);
        }
        throw new RuntimeException("No existe el id para actualziar");
    }*/

    @DeleteMapping(value = "/delete/{id}")
    public void delete(@PathVariable("id")Long id){
        service.delete(id);
    }

    @GetMapping(value = "/{id}")
    public CategoryDto get(@PathVariable("id") Long id){
        return service.get(id);
    }

}
