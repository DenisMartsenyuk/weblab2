package ru.lab.weblab2.model;

import java.util.*;

//todo рассмотреть вариант синглтона
//todo о боги, надеюсь это работает
public class Diagram {
    private Regional graphField;
    private Map<Double, Set<Point>> dividedPoints;
    private List<Point> allPoints;

    public Diagram() {
        this.graphField = new Field();
        this.dividedPoints = new HashMap<>();
        this.allPoints = new ArrayList<>();
    }

    public List<Point> getDividedPoints(Double r) {
        return new ArrayList<>(dividedPoints.get(r));
    }

    public List<Point> getAllPoints() {
        return allPoints;
    }

    public boolean isHit(Point point) {
        if (graphField.isHit(point)) {
            point.setIsHit(true);
            Double r = point.getR();
            Set<Point> updateSet = dividedPoints.get(r);
            if (updateSet == null) {
                updateSet = new HashSet<>();
            }
            updateSet.add(point);
            dividedPoints.remove(r);
            dividedPoints.put(r, updateSet);
            allPoints.add(point);
            return true;
        }
        point.setIsHit(false);
        allPoints.add(point);
        return false;
    }
}
