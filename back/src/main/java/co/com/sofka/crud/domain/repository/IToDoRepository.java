package co.com.sofka.crud.domain.repository;

import co.com.sofka.crud.domain.dto.ToDoDto;

public interface IToDoRepository {

    public Iterable<ToDoDto> list();
    public ToDoDto save(ToDoDto toDoDTO);
    public void delete(Long id);
    public ToDoDto get(Long id);

}
