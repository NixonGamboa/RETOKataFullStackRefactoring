package co.com.sofka.crud.persistence.mapper;

import co.com.sofka.crud.domain.ToDoDTO;
import co.com.sofka.crud.persistence.entity.ToDo;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;


@Mapper(componentModel = "spring")
public interface ToDoMapper {
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "completed", target = "completed"),
            @Mapping(source = "groupListId", target = "groupListId")
    })
    ToDoDTO toTodoDTO(ToDo toDo);
    Iterable<ToDoDTO> toTodoDTOs (Iterable<ToDo> toDos);

    @InheritInverseConfiguration
    ToDo toTodo(ToDoDTO toDoDTO);
}