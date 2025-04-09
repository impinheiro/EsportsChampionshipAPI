package fan.esports.championship.Esports.Championship.infrastructure.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<?> handleException(UserNotFoundException ex) {
        Map<String, String> response = new HashMap<>();
        response.put("Message", "Insert a valid ID");
        response.put("Error", ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidLoginParameterException.class)
    public ResponseEntity<?> handleException(InvalidLoginParameterException ex) {
        Map<String, String> response = new HashMap<>();
        response.put("Message", "Please enter valid email or password");
        response.put("Error", ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MissingPermissionException.class)
    public ResponseEntity<?> handleException(MissingPermissionException ex) {
        Map<String, String> response = new HashMap<>();
        response.put("Message", "You need to have permission to perform this action");
        response.put("Error", ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<?> handleException(UserAlreadyExistsException ex) {
        Map<String, String> response = new HashMap<>();
        response.put("Message", "Something went wrong");
        response.put("Error", ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(RegistrationNotFoundException.class)
    public ResponseEntity<?> handleException(RegistrationNotFoundException ex) {
        Map<String, String> response = new HashMap<>();
        response.put("Message", "Registration not found");
        response.put("Error", ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MatchNotFoundException.class)
    public ResponseEntity<?> handleException(MatchNotFoundException ex) {
        Map<String, String> response = new HashMap<>();
        response.put("Message", "Match not found");
        response.put("Error", ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
