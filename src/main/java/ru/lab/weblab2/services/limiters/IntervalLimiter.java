package ru.lab.weblab2.services.limiters;

public final class IntervalLimiter<T extends Number & Comparable<T>> implements Limiter<T> {
    private final T leftLimit;
    private final T rightLimit;
    private final Boolean leftOccurrence;
    private final Boolean rightOccurrence;

    public IntervalLimiter(T leftLimit, T rightLimit, Boolean leftOccurrence, Boolean rightOccurrence) {
        this.leftLimit = leftLimit;
        this.rightLimit = rightLimit;
        this.leftOccurrence = leftOccurrence;
        this.rightOccurrence = rightOccurrence;
    }

    @Override
    public boolean isLimit(T value) {
        if (value.compareTo(leftLimit) < 0 || value.compareTo(rightLimit) > 0) { //[l;r]
            return false;
        }

        if (!leftOccurrence && value.compareTo(leftLimit) == 0) {
            return false;
        }

        if (!rightOccurrence && value.compareTo(rightLimit) == 0) {
            return false;
        }
        return true;
    }
}
