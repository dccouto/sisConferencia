package br.gov.mds.sisConferencia.exceptions;

/**
 * Classe de exceção do sistema. Esta classe lance uma exceção do tipo
 * RuntimeException
 * 
 */
public class SisConferenciaNotFoundException extends RuntimeException {

    public SisConferenciaNotFoundException(String message) {
        super(message);
    }
    
    public SisConferenciaNotFoundException() {
        super();
    }

}
