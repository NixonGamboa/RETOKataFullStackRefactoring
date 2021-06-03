package co.com.sofka.crud.domain.repository;

import co.com.sofka.crud.domain.dto.CategoryDto;

public interface ICategoryRepository {

    public Iterable<CategoryDto> list();
    public CategoryDto save(CategoryDto toDoDTO);
    public void delete(Long id);
    public CategoryDto get(Long id);
}
