package hr.tis.academy.db;

public class DatabaseException extends RuntimeException {
    public DatabaseException(String message) {
        super(message);
    }
    public DatabaseException(Exception e) {
        super(e);
    }
}
