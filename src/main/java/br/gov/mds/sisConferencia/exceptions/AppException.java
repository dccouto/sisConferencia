package br.gov.mds.sisConferencia.exceptions;

/**
 * Classe de exceção do aplicativo. Esta classe lance uma exceção do tipo
 * RuntimeException
 * 
 */
public class AppException extends RuntimeException {

    public AppException(String message) {
        super(message);
    }
    
    public AppException() {
        super();
    }

}
