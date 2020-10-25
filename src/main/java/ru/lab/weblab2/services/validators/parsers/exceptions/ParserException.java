package ru.lab.weblab2.services.validators.parsers.exceptions;

public final class ParserException extends Exception {
    public ParserException() {
        super("Введенные данные не соответствуют требуемым типам данных.");
    }
}
