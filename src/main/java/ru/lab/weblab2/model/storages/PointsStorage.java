package ru.lab.weblab2.model.storages;

import ru.lab.weblab2.model.entities.Point;

import java.util.*;

public final class PointsStorage {
    private Map<Double, Set<Point>> dividedPoints;
    private List<Point> allPoints;

    public PointsStorage() {
        this.dividedPoints = new HashMap<>();
        this.allPoints = new ArrayList<>();
    }

    public void addPoint(Point point) {
        this.allPoints.add(point);
        if (point.getHit()) {
            addToDividedPoints(point);
        }
    }

    private void addToDividedPoints(Point point) {
        Double r = point.getR();
        Set<Point> updateSet = dividedPoints.get(r);
        if (updateSet == null) {
            updateSet = new HashSet<>();
        }
        updateSet.add(point);
        dividedPoints.remove(r);
        dividedPoints.put(r, updateSet);
    }

    public List<Point> getAllPoints() {
        return allPoints;
    }

    public List<Point> getDividedPoints(Double r) {
        if (dividedPoints.containsKey(r)) {
            return new ArrayList<>(dividedPoints.get(r));
        }
        return new ArrayList<>();
    }
}
