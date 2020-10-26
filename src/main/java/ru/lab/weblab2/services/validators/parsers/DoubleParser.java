package ru.lab.weblab2.services.validators.parsers;

import ru.lab.weblab2.services.validators.parsers.exceptions.ParserException;

public final class DoubleParser implements Parser<Double> {
    @Override
    public Double parse(String value) throws ParserException {
        value = value.replace(',','.');
        try {
            return Double.parseDouble(value);
        } catch (Exception e) {
            throw new ParserException();
        }
    }
}
