package ru.lab.weblab2.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//TODO delete html code from method doPost. Use forward
//TODO add logging with log4j2
public class AreaCheckServlet extends HttpServlet {

    //TODO block request with non POST method
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        try (PrintWriter writer = response.getWriter()) {
            writer.println("<!DOCTYPE html>\n" +
                    "<html lang=\"en\">\n" +
                    "<head>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "    <title>Hello</title>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "    Hello, world!\n" +
                    "</body>\n" +
                    "</html>");
        }
    }
}
