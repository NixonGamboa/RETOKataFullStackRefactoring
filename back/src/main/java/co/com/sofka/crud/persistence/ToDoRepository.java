package co.com.sofka.crud.persistence;

import co.com.sofka.crud.domain.ToDoDTO;
import co.com.sofka.crud.domain.repository.IToDoRepository;
import co.com.sofka.crud.persistence.crud.IToDoCrudRepository;
import co.com.sofka.crud.persistence.entity.ToDo;
import co.com.sofka.crud.persistence.mapper.ToDoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public class ToDoRepository implements IToDoRepository {

    @Autowired
    private IToDoCrudRepository toDoCrudRepository;

    @Autowired
    private ToDoMapper mapper;

    //El controlador pide una lista de objetos de dominio,
    // se hace la solicitud al CrudRepository quien devuelve entidades, (almacenamos las entidades en la lista todos)
    //  estas entidades las convertimos (mapeamos) en objetos de dominio para retornarlas al controlador.
    @Override
    public Iterable<ToDoDTO> list(){
        Iterable<ToDo> toDos = toDoCrudRepository.findAll();
        System.out.println("Exportando lista###############");
        System.out.println(toDos);
        return mapper.toTodoDTOs(toDos);
    }

    //El controlador envía un objeto de dominio para ser guardado y espera de vuelta el mismo objeto de dominio
    // debemos transformar este DTO a una entidad, enviarsela al crudRepository que nos regresa una entidad,
    // mapeamos esta entidad de vuelta a DTo para retornarla al controller
    @Override
    public ToDoDTO save(ToDoDTO toDoDTO){
        ToDo toDo = mapper.toTodo(toDoDTO);
        return mapper.toTodoDTO(toDoCrudRepository.save(toDo));
    }

    //Aqui aplica validacion usando el metodo get, para confirmar si existe ese objeto con ese id
    @Override
    public void delete(Long id){
        toDoCrudRepository.delete(mapper.toTodo(get(id)));
    }

    @Override
    public ToDoDTO get(Long id){
        ToDo toDo = toDoCrudRepository.findById(id).orElseThrow();
         return mapper.toTodoDTO(toDo);
    }

}