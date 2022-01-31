package br.com.calculadorarest.handler;

import br.com.calculadorarest.exceptions.ExceptionResponse;
import br.com.calculadorarest.exceptions.OperacaoMatematicaNaoSuportada;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityException extends ResponseEntityExceptionHandler {

    private static final long serialVersionUID = 1L;
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionResponse> handleAllException(Exception exception, WebRequest request){
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date()
                ,exception.getMessage(),request.getDescription(false));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(OperacaoMatematicaNaoSuportada.class)
    public final ResponseEntity<ExceptionResponse> handleBadResquestxception(Exception exception, WebRequest request){
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date()
                ,exception.getMessage(),request.getDescription(false));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
}
