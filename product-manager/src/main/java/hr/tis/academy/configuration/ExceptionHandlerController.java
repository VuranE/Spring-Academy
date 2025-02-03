package hr.tis.academy.configuration;

import hr.tis.academy.repository.exception.InputIsNullException;
import hr.tis.academy.repository.exception.WrongInputException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@ControllerAdvice
public class ExceptionHandlerController {
    private static final Logger LOGGER =
            LoggerFactory.getLogger(ExceptionHandlerController.class);

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<String> handleAnyException(Exception exception) {
        var uuid = UUID.randomUUID().toString();
        LOGGER.error("Unhandled exception uuid: '{}'", uuid, exception);
        String errorMessage = String.format("An unexpected error occurred. Reference ID: %s", uuid);
        return ResponseEntity.internalServerError().body(errorMessage);
    }

    @ExceptionHandler(WrongInputException.class)
    public final ResponseEntity<String> handleWrongInputException(WrongInputException exception)
    {
        var uuid = UUID.randomUUID().toString();
        LOGGER.error("Wrong input has been sent: '{}'", uuid, exception);
        String errorMessage = String.format("Wrong input has been sent. Reference ID: %s %s", uuid, LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
    }

    @ExceptionHandler(InputIsNullException.class)
    public final ResponseEntity<String> handleWrongInputException(InputIsNullException exception)
    {
        var uuid = UUID.randomUUID().toString();
        LOGGER.error("Input is null: '{}'", uuid, exception);
        String errorMessage = String.format("Input is null. Reference ID: %s %s", uuid, LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }

}
