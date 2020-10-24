package ru.lab.weblab2.model;

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

        return diagram.isHit(new Point(x, y, r));
    }

}
