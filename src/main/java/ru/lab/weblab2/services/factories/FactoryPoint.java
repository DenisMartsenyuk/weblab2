package ru.lab.weblab2.services.factories;

import ru.lab.weblab2.model.entities.Point;
import ru.lab.weblab2.services.checkers.HitChecker;
import ru.lab.weblab2.services.validators.ValidationException;
import ru.lab.weblab2.services.validators.Validator;
import ru.lab.weblab2.services.validators.limiters.IntervalLimiter;
import ru.lab.weblab2.services.validators.limiters.Limiter;
import ru.lab.weblab2.services.validators.limiters.ValueLimiter;
import ru.lab.weblab2.services.trash.xyLimiter;
import ru.lab.weblab2.services.validators.parsers.DoubleParser;
import ru.lab.weblab2.services.validators.parsers.Parser;
import ru.lab.weblab2.services.validators.parsers.exceptions.ParserException;

import java.util.HashSet;
import java.util.Set;

public final class FactoryPoint {
    private static FactoryPoint instance;

    private final HitChecker field;
    private final Parser<Double> doubleParser;
    private final Validator<Double, Double, Double> validator;

    private FactoryPoint(HitChecker field) {
        this.field = field;
        this.doubleParser = new DoubleParser();

        Set<Double> rValues = new HashSet<>(); //todo мб заполнить как-то иначе
        rValues.add(1.0);
        rValues.add(1.5);
        rValues.add(2.0);
        rValues.add(2.5);
        rValues.add(3.0);
        Limiter xyInterval = new IntervalLimiter(-5.0, 5.0, false, false);
        this.validator = new Validator<>(xyInterval, xyInterval, new ValueLimiter<>(rValues));
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
