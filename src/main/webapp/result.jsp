<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ru">
    <head>
        <meta charset="UTF-8">
        <title>Результат</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/ban_back_script.js"></script>
    </head>
<body>
    <div>
        <table>
            <tr>
                <th>X</th>
                <th>Y</th>
                <th>R</th>
                <th>IS HIT</th>
            </tr>
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
