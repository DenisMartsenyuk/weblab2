<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ru">
    <head>
        <meta charset="UTF-8">
        <title>Result</title>

    </head>
<body>
    <div>
        <table>
            <th>
                <td>x</td>
                <td>y</td>
                <td>r</td>
                <td>Hit</td>
            </th>
            <tr>
                <td><%= request.getParameter("x") %></td>
                <td><%= request.getParameter("y") %></td>
                <td><%= request.getParameter("r") %></td>
                <td><%= request.getAttribute("result") %></td>
            </tr>
        </table>
    </div>
    <div>
        <form action="/weblab2/ControllerServlet" method="post">
            <input type="hidden" name="type" value="loadStart">
            <button type="submit">Вернуться на главную страницу</button>
        </form>
    </div>
</body>
