<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html id="main" lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Web lab 2</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/index_script.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index_style.css" type="text/css">
</head>
<body id="main-doc">
<input type="hidden" value="${lastR}" id="lastR">

<header>
    <h1>Лабораторная работа №2. Вариант: 4577.</h1>
</header>

<div class="middle">
    <aside class="left">
        <section>
            <div id="svg-wrapper">
                <svg onclick="clickSvg(evt)" id="graph" xmlns="http://www.w3.org/2000/svg">
                    <polygon class="figures" points="150,150 150,50 100,50, 100,150"></polygon>

                    <path  class="figures" d="M 150 200 A 50 50, 90, 0, 0, 200 150 L 150 150 Z"></path>

                    <polygon class="figures" points="200,150 150,100 150,150"></polygon>

                    <line x1="0" x2="300" y1="150" y2="150" class="axis"></line>
                    <line x1="150" x2="150" y1="0" y2="300" class="axis"></line>
                    <polygon points="150,0 144,15 156,15" class="axis"></polygon>
                    <polygon points="300,150 285,156 285,144" class="axis"></polygon>

                    <line x1="200" x2="200" y1="155" y2="145" class="axis"></line>
                    <line x1="250" x2="250" y1="155" y2="145" class="axis"></line>

                    <line x1="50"  x2="50"  y1="155" y2="145" class="axis"></line>
                    <line x1="100" x2="100" y1="155" y2="145" class="axis"></line>

                    <line x1="145" x2="155" y1="100" y2="100" class="axis"></line>
                    <line x1="145" x2="155" y1="50"  y2="50"  class="axis"></line>

                    <line x1="145" x2="155" y1="200" y2="200" class="axis"></line>
                    <line x1="145" x2="155" y1="250" y2="250" class="axis"></line>

                    <text x="195" y="140">R/2</text>
                    <text x="248" y="140">R</text>

                    <text x="40" y="140">-R</text>
                    <text x="90" y="140">-R/2</text>

                    <text x="160" y="105">R/2</text>
                    <text x="160" y="55">R</text>

                    <text x="160" y="205">-R/2</text>
                    <text x="160" y="255">-R</text>

                    <g id="point-storage">

                    </g>
                    <polygon points="0,0 0,300 300,300, 300,0" opacity="0"></polygon>
                </svg>
            </div>
        </section>
    </aside>

    <aside class="right">
        <section>
            <div class="scroll-table">
                <table id="table-result">
                    <tr>
                        <th class="header-res-table">X</th>
                        <th class="header-res-table">Y</th>
                        <th class="header-res-table">R</th>
                        <th class="header-res-table">IS HIT</th>
                    </tr>
                    <c:forEach items="${allPoints}" var="point">
                        <tr>
                            <td><c:out value="${point.x}" /></td>
                            <td><c:out value="${point.y}" /></td>
                            <td><c:out value="${point.r}" /></td>
                            <td><c:out value="${point.hit}" /></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
            <div class="footer"></div>
        </section>
    </aside>

    <main>
        <div class="body">
            <form method="post" action="${pageContext.request.contextPath}/ControllerServlet" id="request">
                <input type="hidden" name="type" value="check">
                <div>
                    <div class="labels">X</div>
                    <input onchange="validation(this)" placeholder="(5;5)" name="x" maxlength="17" id="x-field" class="field">
                </div>
                <div>
                    <label class="labels">Y</label>
                    <input onchange="validation(this)" placeholder="(5;5)" name="y" maxlength="17" id="y-field" class="field">
                </div>
                <div >
                    <label class="labels">R</label>
                    <label><input onclick="selectCheckBox(this)" type="checkbox" value="1" name="r" checked>1.0</label>
                    <label><input onclick="selectCheckBox(this)" type="checkbox" value="1.5" name="r">1.5</label>
                    <label><input onclick="selectCheckBox(this)" type="checkbox" value="2" name="r">2.0</label>
                    <label><input onclick="selectCheckBox(this)" type="checkbox" value="2.5" name="r">2.5</label>
                    <label><input onclick="selectCheckBox(this)" type="checkbox" value="3" name="r">3.0</label>
                </div>
                <div>
                    <button class="god-button" type="button" onclick="buildRequest()">Отправить</button>
                </div>
            </form>
        </div>
    </main>
</div>
<footer>
    2020 &copy; <a href="https://github.com/DenisMartsenyuk/weblab1">by Martsenyuk Denis</a>
</footer>
</body>
