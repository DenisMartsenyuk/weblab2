package ru.lab.weblab2.services.validators;

import ru.lab.weblab2.services.limiters.Limiter;
import ru.lab.weblab2.services.validators.exceptions.ValidationException;

public final class Validator<T, U, V> {
    private final Limiter<T> xLimiter;
    private final Limiter<U> yLimiter;
    private final Limiter<V> rLimiter;

    public Validator(Limiter<T> xlimiter, Limiter<U> yLimiter, Limiter<V> rLimiter) {
        this.xLimiter = xlimiter;
        this.yLimiter = yLimiter;
        this.rLimiter = rLimiter;
    }
    public void valid(T x, U y, V r) throws ValidationException {
        if (!xLimiter.isLimit(x) || !yLimiter.isLimit(y) || !rLimiter.isLimit(r)) {
            throw new ValidationException();
        }
    }
}
