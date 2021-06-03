package co.com.sofka.crud.domain.services;

import co.com.sofka.crud.domain.ToDoDTO;
import co.com.sofka.crud.domain.repository.IToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToDoDTOService {

    @Autowired
    private IToDoRepository toDoRepository;

    public Iterable<ToDoDTO> list(){
        return toDoRepository.list();
    }
    public ToDoDTO save(ToDoDTO toDoDTO){
        return toDoRepository.save(toDoDTO);
    }
    public void delete(Long id){
        toDoRepository.delete(id);
    }
    public ToDoDTO get(Long id){
        return toDoRepository.get(id);
    }

}
