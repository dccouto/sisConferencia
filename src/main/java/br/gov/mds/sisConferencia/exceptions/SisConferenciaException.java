package br.gov.mds.sisConferencia.exceptions;

/**
 * Classe de exceção do sistema. Esta classe lance uma exceção do tipo
 * RuntimeException
 * 
 */
public class SisConferenciaException extends RuntimeException {

    public SisConferenciaException(String message) {
        super(message);
    }
    
    public SisConferenciaException() {
        super();
    }

}
