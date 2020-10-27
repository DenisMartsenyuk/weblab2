package ru.lab.weblab2.services.validators.exceptions;

public final class ValidationException extends Exception {
    public ValidationException() {
        super("Введенные данные не входят в нужные ограничения.");
    }
}
