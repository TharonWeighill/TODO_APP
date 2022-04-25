package com.example.todo_app.Exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFound extends RuntimeException{

    @Serial
    private static final long serialVersionUID =1L;
    private String resourceName;
    private String fieldName;
    private Object fieldValue;

    public ResourceNotFound(String message, Long resourceName) {
        super(message);
        this.resourceName = String.valueOf(resourceName);
    }

    public String getResourceName() {
        return resourceName;
    }
}
