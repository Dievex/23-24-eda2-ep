public class Document {
    private String title;
    private int publicationYear, id;
    private String type;

    public Document(String title, int publicationYear, int id, String type) {
        this.title = title;
        this.publicationYear = publicationYear;
        this.id = id;
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Title: " + title + " Publication Year: " + publicationYear + " Id: " + id + " Type: " + type;
    }
}
