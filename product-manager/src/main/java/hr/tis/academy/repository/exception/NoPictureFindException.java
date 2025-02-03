package hr.tis.academy.repository.exception;

public class NoPictureFindException extends RuntimeException {

    public NoPictureFindException(String message) {
        super(message);
    }

    public NoPictureFindException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoPictureFindException(Throwable cause) {
        super(cause);
    }
}
