package com.bradesco.teste.domain.exception;

public class NaoEncontradoException extends BusinessException {

    private static final long serialVersionUID = 1L;


    public NaoEncontradoException(String errorCode, String errorMsg, Throwable cause) {
        super(errorCode, errorMsg, cause);
    }

    public NaoEncontradoException(String errorCode, String errorMsg) {
        super(errorCode, errorMsg);
    }
}
