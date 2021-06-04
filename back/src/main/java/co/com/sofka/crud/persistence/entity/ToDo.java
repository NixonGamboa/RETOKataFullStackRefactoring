package co.com.sofka.crud.persistence.entity;

import javax.persistence.*;

@Entity
@Table (name = "toDos")
public class ToDo {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private boolean completed;
    private Long categoryId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
