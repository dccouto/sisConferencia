package br.gov.mds.sisConferencia.exceptions;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.gov.mds.sisConferencia.exceptions.dto.ExceptionResponseDto;
import lombok.extern.log4j.Log4j2;

/**
 * Classe que captura as Exceptions do sistema
 */
@Log4j2
@RestControllerAdvice
public class AppExecptionHandler extends ResponseEntityExceptionHandler {

    /**
     * Sobrescreve handleMethodArgumentNotValid para poder capturar exceções do @Valid
     * 
     * */
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception,
            HttpHeaders headers, HttpStatus status, WebRequest request) {

        List<String> collect = exception.getBindingResult().getAllErrors().stream().map(ObjectError::getDefaultMessage)
                .collect(Collectors.toList());
        return sendResponseExceptionRequest(collect.toString(), request, status);
    }

    /**
     * Captura AppExceptions e retorna objeto Dto com as informações
     * 
     * @return {@link HttpStatus} Bad Request
     */
    @ExceptionHandler(AppException.class)
    public ResponseEntity<Object> badRequestException(Throwable exception, WebRequest request) {
        return sendResponseExceptionRequest(exception.getMessage(), request, HttpStatus.BAD_REQUEST);
    }

    /**
     * Captura Exceptions e retorna objeto Dto com as informações
     * 
     * @return {@link HttpStatus} Internal Error Server
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> internalServerErrorException(Throwable exception, WebRequest request) {
        return sendResponseExceptionRequest(exception.getMessage(), request, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Captura BadCredentialsException e retorna objeto Dto com as informações
     * 
     * @return {@link HttpStatus} FORBIDDEN
     */
    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<Object> badCredentialsException(Throwable exception, WebRequest request) {
        return sendResponseExceptionRequest(exception.getMessage(), request, HttpStatus.FORBIDDEN);
    }
    
    /**
     * Captura BadCredentialsException e retorna objeto Dto com as informações
     * 
     * @return {@link HttpStatus} FORBIDDEN
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> constraintViolationException(Throwable exception, WebRequest request) {
        return sendResponseExceptionRequest(exception.getMessage(), request, HttpStatus.BAD_REQUEST);
    }

    /**
     * Captura HttpClientErrorException e retorna objeto Dto com as informações
     * 
     * @return {@link HttpStatus} UNAUTHORIZED
     */
    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<Object> httpClientErrorException(Throwable exception, WebRequest request) {
        return sendResponseExceptionRequest(exception.getMessage(), request, HttpStatus.UNAUTHORIZED);
    }

    /**
     * Captura HttpClientErrorException e retorna objeto Dto com as informações
     * 
     * @return {@link HttpStatus} UNAUTHORIZED
     */
    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<Object> accessDeniedException(Throwable exception, WebRequest request) {
        return sendResponseExceptionRequest(exception.getMessage(), request, HttpStatus.UNAUTHORIZED);
    }

    /**
     * Monta o objeto com as informações da Exception
     * 
     * @return {@link HttpStatus}
     */
    private static ResponseEntity<Object> sendResponseExceptionRequest(String message, WebRequest request,
            HttpStatus status) {

        var exceptionResponseDto = new ExceptionResponseDto(LocalDateTime.now(), message,
                request.getDescription(false));
        log.error(message);
        return ResponseEntity.status(status).body(exceptionResponseDto);

    }

}
