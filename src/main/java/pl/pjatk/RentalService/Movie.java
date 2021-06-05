package pl.pjatk.RentalService;


public class Movie {

    private Long Id;

    private String Name;

    private Category category;

    private Boolean isAvailable=false;

    public Movie() {

    }

    public Movie(Long id, String name, Category category, Boolean isAvailable) {
        Id = id;
        Name = name;
        this.category = category;
        this.isAvailable = isAvailable;
    }

    public enum Category{
        Horror,
        Comedy,
        Fantasy,
        Action
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }
}
