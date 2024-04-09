public class DocumentAuthor {
    private int authorId, documentId;
    private String type;

    public DocumentAuthor(int authorId, int documentId, String type) {
        this.authorId = authorId;
        this.documentId = documentId;
        this.type = type;
    }

    public int getAuthorId() {
        return authorId;
    }

    public int getDocumentId() {
        return documentId;
    }

    public String getType() {
        return type;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public void setDocumentId(int documentId) {
        this.documentId = documentId;
    }

    public void setType(String type) {
        this.type = type;
    }
}
