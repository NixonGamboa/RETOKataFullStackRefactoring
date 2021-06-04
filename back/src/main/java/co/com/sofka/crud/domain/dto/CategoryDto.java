package co.com.sofka.crud.domain.dto;


import java.util.List;

public class CategoryDto {
    private Long categoryId;
    private String categoryName;
    private List<ToDoDto> toDos;

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<ToDoDto> getToDos() {
        return toDos;
    }

    public void setToDos(List<ToDoDto> toDos) {
        this.toDos = toDos;
    }
}
