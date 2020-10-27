package ru.lab.weblab2.services.trash;

import ru.lab.weblab2.services.validators.limiters.Limiter;

public final class xyLimiter implements Limiter<Double> {
    @Override
    public boolean isLimit(Double value) {
        if (value <= -5 || value >= 5) {
            return false;
        }
        return true;
    }
}
