package ru.lab.weblab2.model;

public class Point {
    private Double x;
    private Double y;
    private Double r;
    private Boolean isHit;

    public Point(Double x, Double y, Double r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }

    public void setIsHit(Boolean isHit) {
        this.isHit = isHit;
    }

    public Boolean getIsHit() {
        return isHit;
    }

    public Double getR() {
        return r;
    }
}
