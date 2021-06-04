package co.com.sofka.crud.persistence.mapper;

import co.com.sofka.crud.domain.dto.CategoryDto;
import co.com.sofka.crud.persistence.entity.Category;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {ToDoMapper.class})
public interface CategoryMapper {
    @Mappings({
            @Mapping(source = "categoryId", target = "categoryId"),
            @Mapping(source = "categoryName", target = "categoryName"),
            @Mapping(source = "toDos", target = "toDos")
    })
    CategoryDto toCategoryDTO(Category category);
    Iterable<CategoryDto> toCategoryDTOs (Iterable<Category> categories);

    @InheritInverseConfiguration
    Category toCategory(CategoryDto categoryDTO);
}
