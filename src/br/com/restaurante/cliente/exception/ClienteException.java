package br.com.restaurante.cliente.exception;

public class ClienteException extends Exception {
	private static final long serialVersionUID = 1L;
    public ClienteException(String message) {
        super(message);
    }

    public ClienteException(String message, Throwable cause) {
        super(message, cause);
    }
}