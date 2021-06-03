package co.com.sofka.crud.domain.services;

import co.com.sofka.crud.domain.dto.CategoryDto;
import co.com.sofka.crud.domain.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryDTOService {

    @Autowired
    private ICategoryRepository categoryRepository;

    public Iterable<CategoryDto> list(){
        return categoryRepository.list();
    }
    public CategoryDto save(CategoryDto categoryDto){
        return categoryRepository.save(categoryDto);
    }
    public void delete(Long id){
        categoryRepository.delete(id);
    }
    public CategoryDto get(Long id){
        return categoryRepository.get(id);
    }
}
