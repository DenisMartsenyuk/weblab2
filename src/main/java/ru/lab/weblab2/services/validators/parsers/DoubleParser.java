package ru.lab.weblab2.services.validators.parsers;

public final class DoubleParser implements Parser<Double> {
    @Override
    public Double parse(String value) throws ParserException {
        value = value.replace(',','.');
        try {
            Double result = Double.parseDouble(value);
            return result;
        } catch (Exception e) {
            throw new ParserException();
        }
    }
}
