package ir.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class MyControllerAdvice {


    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericException(Exception ex) {
        return ResponseEntity
                .status(500)
                .body("خطای ناشناخته - تماس با ادمین !!!");
    }

    @ExceptionHandler(HttpClientErrorException.NotFound.class)
    public ResponseEntity<String> handleNotFoundException(HttpClientErrorException.NotFound ex) {
        return ResponseEntity
                .status(404)
                .body("صفحه درخواستی وجود ندارد !!!");
    }

    @ExceptionHandler(HttpServerErrorException.class)
    public ResponseEntity<String> handleServerErrorException(HttpServerErrorException ex) {
        return ResponseEntity
                .status(500)
                .body("خطای سرور");
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<String> handleNoHandlerFoundException(NoHandlerFoundException ex) {
        return ResponseEntity
                .status(404)
                .body("صفحه درخواستی وجود ندارد !!!");
    }
}
