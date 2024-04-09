public class Author {
    private String name, lastName;
    private int id;

    public Author(String name, String lastName, int id) {
        this.name = name;
        this.lastName = lastName;
        this.id = id;
    }
    
    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString(){
        return "Author: " + name + " Last Name: " + lastName + " Id: " + id;
    }
}
