package univerranking.uz.univerranking.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class ExceptionHandling {

    @ExceptionHandler(UniversityNotFoundException.class)
    public ResponseEntity<Object> handleException(
            UniversityNotFoundException ex) {
        UniversityNotFoundExceptionRequest request = new UniversityNotFoundExceptionRequest(
                ex.getMessage(),
                HttpStatus.NOT_FOUND,
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        return new ResponseEntity<>(request, HttpStatus.NOT_FOUND);
    }
}
