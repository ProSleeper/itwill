<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
    request.setCharacterEncoding("UTF-8");

    int dan = Integer.parseInt(request.getParameter("dan"));

    out.print(dan + " * 1 = " + (dan * 1) + "<br/>");
	out.print(dan + " * 2 = " + (dan * 2) + "<br/>");
	out.print(dan + " * 3 = " + (dan * 3) + "<br/>");
	out.print(dan + " * 4 = " + (dan * 4) + "<br/>");
	out.print(dan + " * 5 = " + (dan * 5) + "<br/>");
	out.print(dan + " * 6 = " + (dan * 6) + "<br/>");
	out.print(dan + " * 7 = " + (dan * 7) + "<br/>");
	out.print(dan + " * 8 = " + (dan * 8) + "<br/>");
	out.print(dan + " * 9 = " + (dan * 9) + "<br/>");


%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	out.print(dan + " * 1 = " + (dan * 1) + "<br/>");
	out.print(dan + " * 2 = " + (dan * 2) + "<br/>");
	out.print(dan + " * 3 = " + (dan * 3) + "<br/>");
	out.print(dan + " * 4 = " + (dan * 4) + "<br/>");
	out.print(dan + " * 5 = " + (dan * 5) + "<br/>");
	out.print(dan + " * 6 = " + (dan * 6) + "<br/>");
	out.print(dan + " * 7 = " + (dan * 7) + "<br/>");
	out.print(dan + " * 8 = " + (dan * 8) + "<br/>");
	out.print(dan + " * 9 = " + (dan * 9) + "<br/>");
%>




</body>
</html>