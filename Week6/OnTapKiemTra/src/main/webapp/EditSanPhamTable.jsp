<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
	crossorigin="anonymous"></script>
</head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<body>
	<%
	String id = request.getParameter("id");
	
	%>
	<form action="EditSanPhamTableServlet" method="get">
		<div class="mb-3">
			<label for="ma_san_pham" class="form-label">Ma San Pham</label> <input
				type="text" class="form-control" id="ma_san_pham" name="ma_san_pham"
				value="" aria-describedby="emailHelp">
		</div>
		<div class="mb-3">
			<label for="ten_san_pham" class="form-label">Ten San Pham</label><input
				type="text" class="form-control" id="ten_san_pham"
				name="ten_san_pham" aria-describedby="emailHelp">
		</div>
		<div class="mb-3">
			<label for="gia" class="form-label">Gia</label> <input type="text"
				class="form-control" id="gia" name="gia"
				aria-describedby="emailHelp">
		</div>
		<div class="mb-3">
			<label for="mo_ta" class="form-label">Mo Ta</label> <input type="text"
				class="form-control" id="mo_ta" name="mo_ta"
				aria-describedby="emailHelp">
		</div>
		<div class="mb-3">
			<label for="ma_danh_muc" class="form-label">Ma Danh Muc</label> <input type="text"
				class="form-control" id="ma_danh_muc" name="ma_danh_muc"
				aria-describedby="emailHelp">
		</div>

		<button type="submit" class="btn btn-primary">Submit</button>
	</form>
	  
      
</body>
</html>