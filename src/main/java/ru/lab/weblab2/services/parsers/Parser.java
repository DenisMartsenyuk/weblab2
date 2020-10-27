package ru.lab.weblab2.services.parsers;

import ru.lab.weblab2.services.parsers.exceptions.ParserException;

public interface Parser<T> {
    T parse(String value) throws ParserException;
}
