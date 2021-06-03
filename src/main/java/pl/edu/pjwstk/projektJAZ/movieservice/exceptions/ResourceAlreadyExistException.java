package pl.edu.pjwstk.projektJAZ.movieservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@ResponseStatus(HttpStatus.FOUND)
@RestControllerAdvice
public class ResourceAlreadyExistException extends RuntimeException {

    @ExceptionHandler(ResourceAlreadyExistException.class)
    public ResponseEntity<Object> handleRuntimeException(ResourceAlreadyExistException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.FOUND);
    }
}