import java.util.ArrayList;
import java.util.Scanner;

public class Management {
    private ArrayList<Document> documents;
    private ArrayList<Author> authors;
    private ArrayList<DocumentAuthor> authorDocuments;
    Scanner s = new Scanner(System.in);

    public Management(ArrayList<Document> documents, ArrayList<Author> authors, ArrayList<DocumentAuthor> authorDocuments) {
        this.documents = documents;
        this.authors = authors;
        this.authorDocuments = authorDocuments;
    }

    public void addDocument() {
        System.out.println("Enter the title of the document");
        String title = s.nextLine();
        System.out.println("Enter the publication year of the document");
        int publicationYear = s.nextInt();
        s.nextLine();
        System.out.println("Enter the id of the document");
        int id = s.nextInt();
        s.nextLine();
        System.out.println("Enter the type of the document: BOOK|MAGAZINE|ARTICLE|PAPER");
        String type = s.nextLine();
        documents.add(new Document(title, publicationYear, id, type));
    }

    public void addDocument(Document document) {
        documents.add(document);
    }

    public void addAuthor(Document document) {
        documents.add(document);
    }

    public void addAuthor() {
        System.out.println("Enter the name of the author");
        String name = s.nextLine();
        System.out.println("Enter the last name of the author");
        String lastName = s.nextLine();
        System.out.println("Enter the id of the author");
        int id = s.nextInt();
        s.nextLine();
        authors.add(new Author(name, lastName, id));
        listAuthors();
    }

    public void addAuthor(Author author){
        authors.add(author);
    }

    public void addRelationship(int documentId, int authorId, String type) {
        Author author = findAuthorById(authorId);
        Document document = findDocumentById(documentId);
    
        if (author != null && document != null) {
            authorDocuments.add(new DocumentAuthor(authorId, documentId, type));
            System.out.println("Relationship added successfully.");
        } else {
            System.out.println("Error: Author or Document not found.");
        }
    }

    public void listAuthors(){
        for(Author author : authors){
            System.out.println(author.toString());
        }
    }

    public void listDocuments(){
        for(Document document : documents){
            System.out.println(document.toString());
        }
    }

    public void listAuthorDocumentRelationships() {
        for (DocumentAuthor authorDocument : authorDocuments) {
            Author author = findAuthorById(authorDocument.getAuthorId());
            Document document = findDocumentById(authorDocument.getDocumentId());
            if (author != null && document != null) {
                System.out.println("Relationship: " + authorDocument.getType() + " - Author: " + author + ", Document: " + document.getTitle());
            }
        }
    }

    public void updateAuthor(int authorId, String newName, String newLastName) {
        Author author = findAuthorById(authorId);
        if (author != null) {
            author.setName(newName);
            author.setLastName(newLastName);
        } else {
            System.out.println("Author not found.");
        }
    }

    public void deleteAuthor(int authorId) {
        Author authorToDelete = findAuthorById(authorId);
        if (authorToDelete != null) {
            authors.remove(authorToDelete);
            authorDocuments.removeIf(authorDocument -> authorDocument.getAuthorId() == authorId);
        } else {
            System.out.println("Author not found.");
        }
    }

    public void deleteDocument(int documentId) {
        Document documentToDelete = findDocumentById(documentId);
        if (documentToDelete != null) {
            documents.remove(documentToDelete);
            authorDocuments.removeIf(authorDocument -> authorDocument.getDocumentId() == documentId);
        } else {
            System.out.println("Document not found.");
        }
    }

    public void deleteRelationship(int documentId, int authorId) {
        boolean deleted = authorDocuments.removeIf(authorDocument -> authorDocument.getDocumentId() == documentId && authorDocument.getAuthorId() == authorId);
        if (deleted) {
            System.out.println("The relationship has been deleted successfully.");
        } else {
            System.out.println("The specified relationship was not found.");
        }
    }

    public Document findDocumentByTitle(String title) {
        for (Document document : documents) {
            if (document.getTitle().equalsIgnoreCase(title)) {
                return document;
            }
        }
        return null;
    }

    public ArrayList<Document> getDocumentsByAuthorId(int authorId){
        ArrayList<Document> documentsByAuthor = new ArrayList<Document>();
        for (DocumentAuthor authorDocument : authorDocuments){
            if (authorDocument.getAuthorId() == authorId){
                documentsByAuthor.add(findDocumentById(authorDocument.getDocumentId()));
            }
        }
        return documentsByAuthor;
    }

    public ArrayList<Author> getAuthorsByDocumentId(int documentId){
        ArrayList<Author> authorsByDocument = new ArrayList<Author>();
        for (DocumentAuthor authorDocument : authorDocuments){
            if (authorDocument.getDocumentId() == documentId){
                authorsByDocument.add(findAuthorById(authorDocument.getAuthorId()));
            }
        }
        return authorsByDocument;
    }

    public Document findDocumentById(int documentId){
        for (Document document : documents){
            if (document.getId() == documentId){
                return document;
            }
        }
        return null;
    }

    public Author findAuthorById(int authorId){
        for (Author author : authors){
            if (author.getId() == authorId){
                return author;
            }
        }
        return null;
    }
}