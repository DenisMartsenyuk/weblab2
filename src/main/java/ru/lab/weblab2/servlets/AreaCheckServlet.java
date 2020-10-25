package ru.lab.weblab2.servlets;

import ru.lab.weblab2.model.entities.Point;
import ru.lab.weblab2.model.storages.PointsStorage;
import ru.lab.weblab2.services.checkers.Field;
import ru.lab.weblab2.services.factories.FactoryPoint;
import ru.lab.weblab2.services.validators.ValidationException;
import ru.lab.weblab2.services.validators.parsers.ParserException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//TODO add logging with log4j2
public class AreaCheckServlet extends HttpServlet {

    //TODO block request with non POST method

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = getServletContext();
        PointsStorage pointsStorage = (PointsStorage) context.getAttribute("pointsStorage");
        if (pointsStorage == null) {
            pointsStorage = new PointsStorage();
        } //todo мб тоже не робит

        String x = request.getParameter("x");
        String y = request.getParameter("y");
        String r = request.getParameter("r");

        FactoryPoint factoryPoint = FactoryPoint.getInstance(new Field());
        try {
            Point point = factoryPoint.buildPoint(x, y, r);
            pointsStorage.addPoint(point);
            request.setAttribute("result", point.getHit());
            request.getRequestDispatcher("/result.jsp").forward(request, response);
        } catch (ParserException e) {
            System.out.println("не число");
        } catch (ValidationException e) {
            System.out.println("не всходит в ограничения");
            //todo страница ошибки
        }
    }
}
