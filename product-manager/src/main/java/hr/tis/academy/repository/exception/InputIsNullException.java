package hr.tis.academy.repository.exception;

public class InputIsNullException extends RuntimeException
{
    public InputIsNullException() {
    }

    public InputIsNullException(String message) {
        super(message);
    }

    public InputIsNullException(String message, Throwable cause) {
        super(message, cause);
    }

    public InputIsNullException(Throwable cause) {
        super(cause);
    }
}
