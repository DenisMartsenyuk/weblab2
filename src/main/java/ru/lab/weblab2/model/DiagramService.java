package ru.lab.weblab2.model;

import ru.lab.weblab2.model.entities.Point;

import java.util.List;

public class DiagramService {
    private Diagram diagram;

    public DiagramService() {
        this.diagram = new Diagram();
    }

    public boolean isHit(String xValue, String yValue, String rValue) {
        //todo тут правильный парсер-валидатор, но потом
        Double x = Double.parseDouble(xValue);
        Double y = Double.parseDouble(yValue);
        Double r = Double.parseDouble(rValue);

        return diagram.isAddPoint(new Point(x, y, r));
    }

    public List<Point> getTablePoints() {
        return diagram.getAllPoints();
    }

    public List<Point> getGraphPoints(Double r) {
        return diagram.getDividedPoints(r);
    }

}
