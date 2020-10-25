package ru.lab.weblab2.services.factories;

import ru.lab.weblab2.model.entities.Point;
import ru.lab.weblab2.services.checkers.HitChecker;
import ru.lab.weblab2.services.validators.ValidationException;
import ru.lab.weblab2.services.validators.Validator;
import ru.lab.weblab2.services.validators.limiters.rLimiter;
import ru.lab.weblab2.services.validators.limiters.xyLimiter;
import ru.lab.weblab2.services.validators.parsers.DoubleParser;
import ru.lab.weblab2.services.validators.parsers.Parser;
import ru.lab.weblab2.services.validators.parsers.exceptions.ParserException;

public final class FactoryPoint {
    private static FactoryPoint instance;

    private final HitChecker field;
    private final Parser<Double> doubleParser;
    private final Validator<Double, Double, Double> validator;

    private FactoryPoint(HitChecker field) {
        this.field = field;
        this.doubleParser = new DoubleParser();
        this.validator = new Validator<>(new xyLimiter(), new xyLimiter(), new rLimiter());
    }

    public static FactoryPoint getInstance(HitChecker field) {
        if (instance == null) {
            instance = new FactoryPoint(field);
        }
        return instance;
    }

    public Point buildPoint(String xValue, String yValue, String rValue) throws ValidationException, ParserException {
        Double x = doubleParser.parse(xValue);
        Double y = doubleParser.parse(yValue);
        Double r = doubleParser.parse(rValue);
        validator.valid(x, y, r);
        Point point = new Point(x, y, r);
        point.setHit(field.isHit(x, y, r));
        return point;
    }
}
