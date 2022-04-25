package com.example.todo_app.Exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFound extends RuntimeException{

    private static final long serialVersionUID =1L;
    private String resourceName;
    private String fieldName;
    private Object fieldValue;

    public ResourceNotFound(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String resourceName) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.resourceName = resourceName;
    }

    public String getResourceName() {
        return resourceName;
    }
}
