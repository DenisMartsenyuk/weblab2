package ru.lab.weblab2.services.factories;

import ru.lab.weblab2.model.entities.Point;
import ru.lab.weblab2.services.checkers.HitChecker;
import ru.lab.weblab2.services.validators.DoubleValidator;
import ru.lab.weblab2.services.validators.ValidationException;
import ru.lab.weblab2.services.validators.limiters.rLimiter;
import ru.lab.weblab2.services.validators.limiters.xyLimiter;
import ru.lab.weblab2.services.validators.parsers.ParserException;

public final class FactoryPoint {

    //todo singleton
    private final HitChecker field;
    private final DoubleValidator xyValidator;
    private final DoubleValidator rValidator;

    public FactoryPoint(HitChecker field) {
        this.field = field;
        this.xyValidator = new DoubleValidator(new xyLimiter());
        this.rValidator = new DoubleValidator(new rLimiter());
    }

    public Point buildPoint(String xValue, String yValue, String rValue) throws ValidationException, ParserException {
        Double x = xyValidator.getValidValue(xValue);
        Double y = xyValidator.getValidValue(yValue);
        Double r = xyValidator.getValidValue(rValue);
        Point point = new Point(x, y, r);
        point.setHit(field.isHit(point));
        return point;
    }
}
