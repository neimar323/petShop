package br.com.tt.petshop.exception;

public class NomeInvalidoException extends RuntimeException {
    public NomeInvalidoException(String msg) {
        super(msg);
    }
}
