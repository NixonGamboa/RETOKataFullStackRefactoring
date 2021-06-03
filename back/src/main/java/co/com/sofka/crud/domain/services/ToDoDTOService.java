package co.com.sofka.crud.domain.services;

import co.com.sofka.crud.domain.dto.ToDoDto;
import co.com.sofka.crud.domain.repository.IToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToDoDTOService {

    @Autowired
    private IToDoRepository toDoRepository;

    public Iterable<ToDoDto> list(){
        return toDoRepository.list();
    }
    public ToDoDto save(ToDoDto toDoDTO){
        return toDoRepository.save(toDoDTO);
    }
    public void delete(Long id){
        toDoRepository.delete(id);
    }
    public ToDoDto get(Long id){
        return toDoRepository.get(id);
    }

}
