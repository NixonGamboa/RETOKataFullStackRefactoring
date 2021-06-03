package co.com.sofka.crud.persistence.crud;

import co.com.sofka.crud.persistence.entity.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryCrudRepository extends CrudRepository<Category, Long> {
}
