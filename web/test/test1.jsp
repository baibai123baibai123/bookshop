<%--
  Created by IntelliJ IDEA.
  User: baibi
  Date: 2022/4/19
  Time: 1:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        table{
            width: 700px;
            border: 1px solid;
        }
    </style>
</head>
<body>
<table align="center">
    <% for (int i = 1; i < 10; i++) { %>
    <tr ><% for (int j = 1; j <= i; j++) { %>

    <td><%=j + "*" + i + "=" + (i * j) %></td>

    <% } %>
    </tr>
    <% } %>

</table>

</body>
</html>
