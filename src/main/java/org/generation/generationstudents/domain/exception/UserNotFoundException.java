package org.generation.generationstudents.domain.exception;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException() {
        super("Usuário não encontrado!");
    }
}
