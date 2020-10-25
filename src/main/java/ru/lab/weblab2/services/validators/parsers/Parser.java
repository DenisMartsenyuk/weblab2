package ru.lab.weblab2.services.validators.parsers;

public interface Parser<T> {
    T parse(String value) throws ParserException;
}
