package ru.lab.weblab2.model.storages;

import ru.lab.weblab2.model.entities.Point;

import java.util.*;

public final class PointsStorage {
    private List<Point> allPoints;

    public PointsStorage() {
        this.allPoints = new ArrayList<>();
    }

    public void addPoint(Point point) {
        this.allPoints.add(point);
    }

    public List<Point> getAllPoints() {
        return allPoints;
    }
}
