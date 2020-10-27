package ru.lab.weblab2.services.limiters;

public interface Limiter<T> {
    boolean isLimit(T value);
}
