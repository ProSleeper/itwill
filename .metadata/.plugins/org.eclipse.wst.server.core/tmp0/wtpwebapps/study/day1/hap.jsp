<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="hap_ok.jsp" method = "get">
    <!-- <form action="hap_ok.jsp" method = "post"></form> -->
    <!-- get방식은 주소창에 데이터를 보여주고
        post방식은 데이터를 안보여준다.
        
        
        
         -->

수1: <input  type = "text" name = "su1"/><br/>
수2: <input  type = "text" name = "su2"/><br/>
이름: <input  type = "text" name = "name"/><br/>
<input type="submit" value="결과"/><br/>


</form>

<a href = "hap_ok.jsp?su1=100&su2=200&name=수지">GET방식</a>



</body>
</html>