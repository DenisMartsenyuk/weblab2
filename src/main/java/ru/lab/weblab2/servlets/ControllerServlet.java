package ru.lab.weblab2.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//TODO Add logging with log4j2
public class ControllerServlet extends HttpServlet {

    private Map<String, String> typesRequests;

    ControllerServlet() {
        this.typesRequests = new HashMap<>();
        this.fillingMap();
    }

    private void fillingMap() {
        this.typesRequests.put("check", "/AreaCheckServlet");
        this.typesRequests.put("loadStart", "/LoadStartServlet");
    }

    private void processingRequest(HttpServletRequest request, HttpServletResponse response) {
        String type = request.getParameter("type");
        String path = typesRequests.get(type);
        if (path == null) {
            path = "/error.jsp";
        }
        try {
            RequestDispatcher dispatcher = request.getRequestDispatcher(path);
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            System.out.println("ну это вообще отмена");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("ну это вообще отмена2");
            e.printStackTrace();
        }
        //todo сделать норм ошибки
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processingRequest(request, response);
    }
}
