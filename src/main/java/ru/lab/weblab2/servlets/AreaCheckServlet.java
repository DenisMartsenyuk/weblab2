package ru.lab.weblab2.servlets;

import ru.lab.weblab2.model.Diagram;
import ru.lab.weblab2.model.DiagramService;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//TODO delete html code from method doPost. Use forward
//TODO add logging with log4j2
public class AreaCheckServlet extends HttpServlet {

    //TODO block request with non POST method



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = getServletContext();
        DiagramService diagramService = (DiagramService) context.getAttribute("diagramService");
        if (diagramService == null) {
            diagramService = new DiagramService();
        } //todo мб тоже не робит

        String x = request.getParameter("x");
        String y = request.getParameter("y");
        String r = request.getParameter("r");

        request.setAttribute("result", diagramService.isHit(x, y, r));
        request.getRequestDispatcher("/result.jsp").forward(request, response);
    }
}
