<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*, java.text.*" %>
<%@ page import="com.company.Dish" %>
<%@ page import="com.company.Parser" %>
<!DOCTYPE HTML>
<link rel="stylesheet" href="styles\style.css">
<%!
    String getTable(ArrayList<Dish> array) {
        StringBuilder raw = new StringBuilder();
        raw.append("<table border=\"1\"");
        raw.append("<tr><th>Название</th><th>Цена</th><th>Описание</th><th>Калорийность</th></tr>");
        for (Dish dish : array) {
            raw.append("<tr><td>").append(dish.getName()).append("</td>");
            raw.append("<td>").append(dish.getPrice()).append("</td>");
            raw.append("<td>").append(dish.getDescription()).append("</td>");
            raw.append("<td>").append(dish.getCalories()).append("</td></tr>");
        }
        raw.append("</table>");
        return raw.toString();
    }
%>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Меню</title>
</head>
<body>
<header>
    <h1 style="text-align:center"> Меню</h1>
</header>
<h2>Выберите время еды:</h2>
<form action="index.jsp" method="GET">
    <select id="meal-time" name="time">
        <%
            String answer = request.getParameter("time");
            if (answer != null && answer.equalsIgnoreCase("завтрак")) {
        %>
        <option value="завтрак" selected>Завтрак</option>
        <option value="обед">Обед</option>
        <option value="ужин">Ужин</option>
        <%
            } else if (answer != null && answer.equalsIgnoreCase("обед")) {

        %>
        <option value="завтрак">Завтрак</option>
        <option value="обед" selected>Обед</option>
        <option value="ужин">Ужин</option>
        <%
            }else if (answer != null && answer.equalsIgnoreCase("ужин")) {
        %>
        <option value="завтрак">Завтрак</option>
        <option value="обед">Обед</option>
        <option value="ужин" selected>Ужин</option>
        <%
            }else {
        %>
        <option value="завтрак">Завтрак</option>
        <option value="обед">Обед</option>
        <option value="ужин">Ужин</option>
        <%
            }
        %>

    </select>
    <input type="submit" value="Подтвердить">
</form>
<br>
<%
    ArrayList<Dish> breakfast = new ArrayList<>();
    ArrayList<Dish> lunch = new ArrayList<>();
    ArrayList<Dish> dinner = new ArrayList<>();
    Parser parser = Parser.getInstance();
    parser.create();
    breakfast = parser.getBreakfast(breakfast);
    lunch =parser.getLunch(lunch);
    dinner = parser.getDinner(dinner);
    if (answer != null && answer.equalsIgnoreCase("завтрак")) out.println(getTable(breakfast));
    if (answer != null && answer.equalsIgnoreCase("обед")) out.println(getTable(lunch));
    if (answer != null && answer.equalsIgnoreCase("ужин")) out.println(getTable(dinner));
%>
</body>
</html>
