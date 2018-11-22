package pvt.web.security.exception;

import org.springframework.http.HttpStatus;

public class CustomException extends RuntimeException{
    private static final long serialVersionUID = 3382451789103157597L;

    private HttpStatus status;

    private String message;

    public CustomException(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
