package co.com.sofka.crud.persistence.crud;

import co.com.sofka.crud.persistence.entity.ToDo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IToDoCrudRepository extends CrudRepository<ToDo, Long> {
}
