import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        ArrayList<Document> documents = new ArrayList<>();
        ArrayList<Author> authors = new ArrayList<>();
        ArrayList<DocumentAuthor> authorDocuments = new ArrayList<>();
        Management management = new Management(documents, authors, authorDocuments);
        
        while (true) {
            System.out.println("\u001B[31m\nMain Menu:\u001B[0m");
            System.out.println("\u001B[34m1. Manage Documents\u001B[0m");
            System.out.println("\u001B[34m2. Manage Authors\u001B[0m");
            System.out.println("\u001B[34m3. Manage Author-Document Relationship\u001B[0m");
            System.out.println("\u001B[33m4. Exit\u001B[0m");
            System.out.print("\u001B[32mSelect an option: \u001B[0m");
            int option = s.nextInt();

            switch (option) {
                case 1:
                    manageDocuments(management, s);
                    break;
                case 2:
                    manageAuthors(management, s);
                    break;
                case 3:
                    manageAuthorDocument(management, s);
                    break;
                case 4:
                    System.out.println("\u001B[31mExiting the program.\u001B[0m");
                    return;
                default:
                    System.out.println("\u001B[31mInvalid option. Please try again.\u001B[0m");
            }
        }
    }

    private static void manageDocuments(Management management, Scanner s) {
        while (true) {
            System.out.println("\nDocument Management:");
            System.out.println("\u001B[36m1. Add Document\u001B[0m");
            System.out.println("\u001B[36m2. List Documents\u001B[0m");
            System.out.println("\u001B[36m3. Search Document by Title\u001B[0m");
            System.out.println("\u001B[36m4. Delete Document\u001B[0m");
            System.out.println("\u001B[33m5. Back to Main Menu\u001B[0m");
            System.out.print("\u001B[32mSelect an option: \u001B[0m");
            int option = s.nextInt();

            switch (option) {
                case 1:
                    management.addDocument();
                    break;
                case 2:
                    management.listDocuments();
                    break;
                case 3:
                    System.out.println("Enter the title of the document to search:");
                    String title = s.nextLine();
                    Document foundDocument = management.findDocumentByTitle(title);
                    if (foundDocument != null) {
                        System.out.println("Document found: " + foundDocument);
                    } else {
                        System.out.println("Document not found.");
                    }
                    break;
                case 4:
                    System.out.println("Enter the ID of the document to delete:");
                    int documentId = s.nextInt();
                    management.deleteDocument(documentId);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void manageAuthors(Management management, Scanner sc) {
        while (true) {
            System.out.println("\nAuthor Management:");
            System.out.println("\u001B[36m1. Add Author\u001B[0m");
            System.out.println("\u001B[36m2. List Authors\u001B[0m");
            System.out.println("\u001B[36m3. Update Author\u001B[0m");
            System.out.println("\u001B[36m4. Delete Author\u001B[0m");
            System.out.println("\u001B[33m5. Back to Main Menu\u001B[0m");
            System.out.print("\u001B[32mSelect an option: \u001B[0m");
            int option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    management.addAuthor();
                    break;
                case 2:
                    management.listAuthors();
                    break;
                case 3:
                    System.out.println("Enter the ID of the author to update:");
                    int authorId = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter the new name of the author:");
                    String newName = sc.nextLine();
                    System.out.println("Enter the new last name of the author:");
                    String newLastName = sc.nextLine();
                    management.updateAuthor(authorId, newName, newLastName);
                    break;
                case 4:
                    System.out.println("Enter the ID of the author to delete:");
                    int authorIdToDelete = sc.nextInt();
                    management.deleteAuthor(authorIdToDelete);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void manageAuthorDocument(Management management, Scanner sc) {
        while (true) {
            System.out.println("\nAuthor-Document Relationship Management:");
            System.out.println("\u001B[36m1. Add Author-Document Relationship\u001B[0m");
            System.out.println("\u001B[36m2. List Author-Document Relationships\u001B[0m");
            System.out.println("\u001B[33m3. Back to Main Menu\u001B[0m");
            System.out.print("\u001B[32mSelect an option: \u001B[0m");
            int option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    System.out.println("Enter the ID of the author:");
                    int authorId = sc.nextInt();
                    System.out.println("Enter the ID of the document:");
                    int documentId = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter the relationship type (BOOK|MAGAZINE|ARTICLE|PAPER):");
                    String type = sc.nextLine();
                    management.addRelationship(documentId, authorId, type);
                    break;
                case 2:
                    management.listAuthorDocumentRelationships();
                    break;
                case 3:
                    return;
                case 5:
                    System.out.println("Enter the author ID:");
                    int author_Id = sc.nextInt();
                    System.out.println("Enter the document ID:");
                    int document_Id = sc.nextInt();
                    management.deleteRelationship(document_Id, author_Id);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
    
}