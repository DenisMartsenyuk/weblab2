package ru.lab.weblab2.services.limiters;

import java.util.Set;

public class ValueLimiter<T> implements Limiter<T>{
    private final Set<T> values;

    public ValueLimiter(Set<T> values) {
        this.values = values;
    }

    @Override
    public boolean isLimit(T value) {
        return values.contains(value);
    }
}
