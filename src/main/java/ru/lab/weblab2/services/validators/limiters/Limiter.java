package ru.lab.weblab2.services.validators.limiters;

public interface Limiter<T> {
    boolean isLimit(T value);
}
