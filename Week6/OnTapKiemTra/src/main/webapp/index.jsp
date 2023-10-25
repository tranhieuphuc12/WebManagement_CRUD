<%@page import="core.DanhMuc"%>
<%@page import="core.SanPham"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style>
/* Remove the navbar's default margin-bottom and rounded borders */
.navbar {
	margin-bottom: 0;
	border-radius: 0;
}

/* Set height of the grid so .sidenav can be 100% (adjust as needed) */
.row.content {
	height: 450px
}

/* Set gray background color and 100% height */
.sidenav {
	padding-top: 20px;
	background-color: #f1f1f1;
	height: 100%;
}

/* Set black background color, white text and some padding */
footer {
	background-color: #555;
	color: white;
	padding: 15px;
}

/* On small screens, set height to 'auto' for sidenav and grid */
@media screen and (max-width: 767px) {
	.sidenav {
		height: auto;
		padding: 15px;
	}
	.row.content {
		height: auto;
	}
	.stretched-link::after {
		position: absolute;
		top: 0;
		right: 0;
		bottom: 0;
		left: 0;
		z-index: 1;
		pointer-events: auto;
		content: "";
		background-color: rgba(0, 0, 0, 0);
	}
}
</style>
</head>
<body>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%
	ArrayList<SanPham> listSanPham = (ArrayList<SanPham>) request.getAttribute("listSanPham");
	ArrayList<DanhMuc> listDanhMuc = (ArrayList<DanhMuc>) request.getAttribute("listDanhMuc");
	%>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Logo</a>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">Home</a></li>
					<li><a href="#">About</a></li>
					<li><a href="#">Projects</a></li>
					<li><a href="#">Contact</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#"><span class="glyphicon glyphicon-log-in"></span>
							Login</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="container-fluid text-center">
		<div class="row content">
			<div class="col-sm-2 sidenav">

				<c:forEach items="${listDanhMuc}" var="danhMuc">
					<a href="?id=${danhMuc.getMaDanhMuc()}">&#8627;${danhMuc.getTenDanhMuc()}</a>
					<br>
				</c:forEach>
				<!--                        //Quan Ly Danh Muc-->
				<a href="QuanLyDanhMucServlet">&#8627;Quan Ly Danh Muc</a>


			</div>
			<div class="col-sm-8 text-left">
				<c:forEach items="${listSanPham}" var="sanPham">

					<div class="panel panel-default">
						<div class="panel-heading">${sanPham.getTenSanPham()}</div>
						<div class="panel-body">${sanPham.getGia()}</div>
						<div class="panel-footer">
							${sanPham.getMoTa()}
							<%-- <a href="SanPhamDetailServlet?id=${sanPham.getMaSanPham()}" class="stretched-link text-black"> [...]</a> --%>
						</div>
					</div>

				</c:forEach>
			</div>
			<div class="col-sm-2 sidenav">

				<div class="well">
					<p>
						<a href="QuanLySanPhamServlet?id=${sanPham.getMaSanPham()}"
							class="stretched-link text-black">&#8627;Quan Ly San Pham</a>
					</p>
				</div>

			</div>
		</div>
	</div>

	<footer class="container-fluid text-center">
		<p>Footer Text</p>
	</footer>

</body>
</html>
