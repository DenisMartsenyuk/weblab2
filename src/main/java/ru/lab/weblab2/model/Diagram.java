package ru.lab.weblab2.model;

import ru.lab.weblab2.model.entities.Point;
import ru.lab.weblab2.services.checkers.Field;
import ru.lab.weblab2.services.checkers.HitChecker;

import java.util.*;

//todo рассмотреть вариант синглтона
//todo о боги, надеюсь это работает
public class Diagram {
    private HitChecker graphField;
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

    public boolean isAddPoint(Point point) {
        Boolean hit = graphField.isHit(point);
        point.setHit(hit);
        allPoints.add(point);
        if (hit) {
            addToDividedPoints(point);
        }
        return hit;
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
}
