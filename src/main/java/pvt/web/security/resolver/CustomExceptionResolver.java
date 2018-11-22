package pvt.web.security.resolver;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import pvt.web.security.exception.CustomException;

@ControllerAdvice(annotations = RestController.class)
public class CustomExceptionResolver {

    @ExceptionHandler
    public ResponseEntity<String> resolve(CustomException e){
        return new ResponseEntity<>(e.getMessage(), e.getStatus());
    }
}
