<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%--<!DOCTYPE html>--%>
<%--<html lang="ru">--%>
<%--    <head>--%>
<%--        <meta charset="UTF-8">--%>
<%--        <title>Web lab 2</title>--%>
<%--    </head>--%>
<%--<body>--%>
<%--    <form action="/weblab2/ControllerServlet" method="post">--%>
<%--        <input type="hidden" name="type" value="check">--%>
<%--        <div>--%>
<%--            <input placeholder="x" name="x">--%>
<%--        </div>--%>
<%--        <div>--%>
<%--            <input placeholder="y" name="y">--%>
<%--        </div>--%>
<%--        <div>--%>
<%--            <input placeholder="r" name="r">--%>
<%--        </div>--%>
<%--        <div>--%>
<%--            <button type="submit">Send</button>--%>
<%--        </div>--%>
<%--    </form>--%>
<%--</body>--%>

<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Web lab 2</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css">
</head>
<body>
<header>
    <h1>Лабораторная работа №2. Вариант: 4577.</h1>
</header>

<div class="middle">
    <aside class="left">
        <section>
            <div class="header">название</div>
            <div>
                <svg id="graph" xmlns="http://www.w3.org/2000/svg">
                    <polygon class="figures" points="150,150 150,50 250,50, 250,150"></polygon>

                    <path  class="figures" d="M 150 250 A 100 100, 90, 0, 0, 250 150 L 150 150 Z"></path>

                    <polygon class="figures" points="50,150 150,100 150,150"></polygon>

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
                </svg>
            </div>
        </section>
    </aside>

    <aside class="right">
        <section>
            <div class="header">название</div>
            <div class="body">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Mattis enim ut tellus elementum. Ac odio tempor orci dapibus ultrices in iaculis. Eu tincidunt tortor aliquam nulla. At urna condimentum mattis pellentesque. Quis imperdiet massa tincidunt nunc pulvinar sapien et ligula. Penatibus et magnis dis parturient montes nascetur ridiculus. Vulputate sapien nec sagittis aliquam malesuada bibendum arcu vitae. Enim sed faucibus turpis in eu mi bibendum neque. Augue neque gravida in fermentum et sollicitudin. Lectus sit amet est placerat. Mi quis hendrerit dolor magna. Nullam ac tortor vitae purus faucibus ornare suspendisse sed. Cum sociis natoque penatibus et magnis dis. Augue eget arcu dictum varius. Egestas egestas fringilla phasellus faucibus scelerisque eleifend donec. Eget aliquet nibh praesent tristique magna sit amet. Ut tristique et egestas quis ipsum suspendisse ultrices. Consequat mauris nunc congue nisi vitae. At tempor commodo ullamcorper a lacus vestibulum sed arcu. Sed nisi lacus sed viverra tellus. Vulputate sapien nec sagittis aliquam malesuada bibendum arcu. Eu feugiat pretium nibh ipsum. Ut etiam sit amet nisl. Lectus magna fringilla urna porttitor. Eget mi proin sed libero enim. Velit ut tortor pretium viverra suspendisse potenti nullam ac tortor.</div>
            <div class="footer"></div>
        </section>
    </aside>

    <main>
        <div class="body">
            <form method="post" action="${pageContext.request.contextPath}/ControllerServlet">
                <input type="hidden" name="type" value="check">
<%--                <input type="hidden" name="r" value="1">--%>
                <div>
                    <h4>X</h4>
                    <input placeholder="x" name="x">
                </div>
                <div>
                    <h4>Y</h4>
                    <input placeholder="y" name="y">
                </div>
                <div>
                    <h4>R</h4>
                    <input type="checkbox" value="1" name="r">
                    <input type="checkbox" value="1.5" name="r">
                    <input type="checkbox" value="2" name="r">
                    <input type="checkbox" value="2.5" name="r">
                    <input type="checkbox" value="3" name="r">
                </div>
                <div>
                    <button type="submit">Отправить</button>
                </div>
            </form>
        </div>
    </main>
</div>
<footer>
    2020 &copy; <a href="https://github.com/DenisMartsenyuk/weblab1">by Martsenyuk Denis</a>
</footer>
</body>
