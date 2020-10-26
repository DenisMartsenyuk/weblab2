package ru.lab.weblab2.model.entities;

public final class Point {
    private final Double x;
    private final Double y;
    private final Double r;
    private Boolean hit;

    public Point(Double x, Double y, Double r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }

    public void setHit(Boolean hit) {
        this.hit = hit;
    }

    public Boolean getHit() {
        return hit;
    }

    public Double getR() {
        return r;
    }
}
