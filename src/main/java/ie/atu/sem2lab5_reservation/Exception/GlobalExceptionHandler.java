package ie.atu.sem2lab5_reservation.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidation(MethodArgumentNotValidException ex){

        Map<String, String> errors = new HashMap<>();

        for(FieldError fieldError : ex.getBindingResult().getFieldError()){
            errors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ReservtionConflictException.class)
    public ResponseEntity<String> handleConflict(ReservtionConflictException ex){


        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
    }
}