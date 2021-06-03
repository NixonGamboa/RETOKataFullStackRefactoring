package co.com.sofka.crud.persistence;

import co.com.sofka.crud.domain.dto.CategoryDto;
import co.com.sofka.crud.domain.repository.ICategoryRepository;
import co.com.sofka.crud.persistence.crud.ICategoryCrudRepository;
import co.com.sofka.crud.persistence.entity.Category;
import co.com.sofka.crud.persistence.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryRepository implements ICategoryRepository {
    @Autowired
    private ICategoryCrudRepository categoryCrudRepository;

    @Autowired
    private CategoryMapper mapper;

    @Override
    public Iterable<CategoryDto> list(){
        Iterable<Category> categories = categoryCrudRepository.findAll();
        return mapper.toCategoryDTOs(categories);
    }

    @Override
    public CategoryDto save(CategoryDto categoryDto){
        Category category = mapper.toCategory(categoryDto);
        return mapper.toCategoryDTO(categoryCrudRepository.save(category));
    }

    @Override
    public void delete(Long id){
        categoryCrudRepository.delete(mapper.toCategory(get(id)));
    }

    @Override
    public CategoryDto get(Long id){
        Category category = categoryCrudRepository.findById(id).orElseThrow();
        return mapper.toCategoryDTO(category);
    }
}
