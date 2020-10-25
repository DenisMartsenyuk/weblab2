package ru.lab.weblab2.services.validators.limiters;

public final class rLimiter implements Limiter<Double> {
    @Override
    public boolean isLimit(Double value) {
        if(value == 1 || value == 1.5 || value == 2 || value == 2.5 || value == 3) {
            return true;
        }
        return false;
    }
}
