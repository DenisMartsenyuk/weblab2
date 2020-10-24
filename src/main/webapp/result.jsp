<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
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
        <button>Go back</button>
    </div>
</body>
