<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ru">
    <head>
        <meta charset="UTF-8">
        <title>Ошибка</title>
    </head>
    <body>
        <header>
            <h1>Ошибка</h1>
        </header>
        <div>
            Текст ошибки:  <%= request.getAttribute("errorMessage") %>
        </div>
    </body>
</html>