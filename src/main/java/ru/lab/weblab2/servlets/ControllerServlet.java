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
    }

    private void processingRequest(HttpServletRequest request, HttpServletResponse response) {
//        Integer count = (Integer) getServletContext().getAttribute("count");
//        if (count == null) {
//            count = 0;
//        } else {
//            count++;
//        }
//        getServletContext().setAttribute("count", count);
//        System.out.println(getServletContext().getAttribute("count") + " controller"); //todo убрать
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        processingRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processingRequest(request, response);
    }

    //what about other request methods ? Read about servlet method "service"
}
