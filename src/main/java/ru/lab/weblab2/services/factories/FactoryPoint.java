package ru.lab.weblab2.services.factories;

import ru.lab.weblab2.model.entities.Point;
import ru.lab.weblab2.services.checkers.HitChecker;
import ru.lab.weblab2.services.validators.DoubleValidator;
import ru.lab.weblab2.services.validators.ValidationException;
import ru.lab.weblab2.services.validators.limiters.rLimiter;
import ru.lab.weblab2.services.validators.limiters.xyLimiter;
import ru.lab.weblab2.services.validators.parsers.ParserException;

public final class FactoryPoint {
    private static FactoryPoint instance;

    private final HitChecker field;
    private final DoubleValidator xyValidator;
    private final DoubleValidator rValidator;

    private FactoryPoint(HitChecker field) {
        this.field = field;
        this.xyValidator = new DoubleValidator(new xyLimiter());
        this.rValidator = new DoubleValidator(new rLimiter());
    }

    public static FactoryPoint getInstance(HitChecker field) {
        if (instance == null) {
            instance = new FactoryPoint(field);
        }
        return instance;
    }

    public Point buildPoint(String xValue, String yValue, String rValue) throws ValidationException, ParserException {
        Double x = xyValidator.getValidValue(xValue);
        Double y = xyValidator.getValidValue(yValue);
        Double r = rValidator.getValidValue(rValue);
        Point point = new Point(x, y, r);
        point.setHit(field.isHit(point));
        return point;
    }
}
