<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">

	function sendIt(){
		var f = document.myForm;
		
		if(!f.dan.value){
			alert("단을 입력하세요!");
			f.dan.focus();
			return;
		}
		f.action = "gugudan_ok.jsp";
		f.submit();
	}

</script>

</head>
<body>

	<form action="gugudan_ok.jsp" method="get" name="myForm">

		단 : <input type="text" name="dan" /><br /> <input type="button"
			value="결과" onclick="sendIt();" /><br />



	</form>


</body>
</html>