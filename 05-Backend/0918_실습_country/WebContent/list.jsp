<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*, com.ssafy.Country"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>나라 목록 조회</h1>
	<table>
		<tr>
			<th>나라코드</th>
			<th>국가명</th>
			<th>대륙</th>
			<th>GNP</th>
		</tr>
		<%
		List<Country> list = (List<Country>) request.getAttribute("list");
		System.out.println("전달받은 나라목록 정보 : " + list);
		for(Country country : list){
			out.write("<tr>");
			out.write("<td>"+country.getCode()+"</td>");
			out.write("<td>"+country.getName()+"</td>");
			out.write("<td>"+country.getContinent()+"</td>");
			out.write("<td>"+country.getGnp()+"</td>");
			out.write("</tr>");
		}
		%>
	</table>
</body>
</html>












