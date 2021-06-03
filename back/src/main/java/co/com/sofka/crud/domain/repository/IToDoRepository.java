package co.com.sofka.crud.domain.repository;

import co.com.sofka.crud.domain.ToDoDTO;
import co.com.sofka.crud.persistence.entity.ToDo;

public interface IToDoRepository {

    public Iterable<ToDoDTO> list();
    public ToDoDTO save(ToDoDTO toDoDTO);
    public void delete(Long id);
    public ToDoDTO get(Long id);

}
