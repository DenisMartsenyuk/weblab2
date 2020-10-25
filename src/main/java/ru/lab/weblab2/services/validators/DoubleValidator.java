package ru.lab.weblab2.services.validators;

import ru.lab.weblab2.services.validators.limiters.Limiter;
import ru.lab.weblab2.services.validators.parsers.DoubleParser;
import ru.lab.weblab2.services.validators.parsers.ParserException;

public final class DoubleValidator implements Validator<Double> {
    private final DoubleParser parser;
    private final Limiter<Double> limiter;

    public DoubleValidator(Limiter<Double> limiter) {
        this.parser = new DoubleParser();
        this.limiter = limiter;
    }

    @Override
    public Double getValidValue(String value) throws ParserException, ValidationException {
        Double result = parser.parse(value);
        if (!limiter.isLimit(result)) {
            throw new ValidationException();
        }
        return result;
    }
}
