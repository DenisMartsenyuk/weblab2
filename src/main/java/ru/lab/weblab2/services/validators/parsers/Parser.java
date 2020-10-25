package ru.lab.weblab2.services.validators.parsers;

import ru.lab.weblab2.services.validators.parsers.exceptions.ParserException;

public interface Parser<T> {
    T parse(String value) throws ParserException;
}
