package ru.lab.weblab2.services.validators;

import ru.lab.weblab2.services.validators.parsers.ParserException;

public interface Validator<T> {
    T getValidValue(String value) throws ParserException, ValidationException;
}
