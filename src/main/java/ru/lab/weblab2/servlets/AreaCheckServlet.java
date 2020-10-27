package ru.lab.weblab2.servlets;

import ru.lab.weblab2.model.entities.Point;
import ru.lab.weblab2.model.storages.PointsStorage;
import ru.lab.weblab2.services.checkers.Field;
import ru.lab.weblab2.services.factories.FactoryPoint;
import ru.lab.weblab2.services.validators.exceptions.ValidationException;
import ru.lab.weblab2.services.parsers.exceptions.ParserException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AreaCheckServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = getServletContext();
        PointsStorage pointsStorage = (PointsStorage) context.getAttribute("pointsStorage");
        if (pointsStorage == null) {
            pointsStorage = new PointsStorage();
        }

        String x = request.getParameter("x");
        String y = request.getParameter("y");
        String r = request.getParameter("r");

        FactoryPoint factoryPoint = FactoryPoint.getInstance(new Field());
        try {
            Point point = factoryPoint.buildPoint(x, y, r);
            pointsStorage.addPoint(point);
            context.setAttribute("lastR", r);
            context.setAttribute("pointsStorage", pointsStorage);
            context.setAttribute("allPoints", pointsStorage.getAllPoints());
            request.setAttribute("result", point.getHit());
            request.getRequestDispatcher("/jsp/result.jsp").forward(request, response);
        } catch (ParserException | ValidationException e) {
            request.setAttribute("errorMessage", e.getMessage());
            request.getRequestDispatcher("/jsp/error.jsp").forward(request, response);
        }
    }
}
