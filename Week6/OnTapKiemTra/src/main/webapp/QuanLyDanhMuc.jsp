<%-- 
    Document   : QuanLyDanhMuc
    Created on : Oct 24, 2023, 4:25:29 PM
    Author     : Administrator
--%>

<%@page import="core.DanhMuc"%>
<%@page import="java.util.ArrayList"%>
<%@page import="core.SanPham"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
    </head>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
    <%
        ArrayList<DanhMuc> listDanhMuc = (ArrayList<DanhMuc>) request.getAttribute("listDanhMuc");

    %>
    <body>
    <a class="btn btn-primary" href="AddTable.jsp" role="button">Add</a>
        <table class="table">
            <thead>
                <tr>
                    <th scope="col">Ma Danh Muc</th>
                    <th scope="col">Ten Danh Muc</th>
                    <th scope="col">Ghi Chu</th>
                    <th scope="col">Hanh Dong</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${listDanhMuc}" var="danhMuc">
                    <tr>
                        <th scope="row">${danhMuc.getMaDanhMuc()}</th>
                        <td>${danhMuc.getTenDanhMuc()}</td>
                        <td>${danhMuc.getGhiChu()}</td>
						 <td>
						 <a href="EditTable.jsp?id=${danhMuc.getMaDanhMuc()}">Edit</a>/<a href="DeleteTable?id=${danhMuc.getMaDanhMuc()}">Delete</a>
						 </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <a class="btn btn-primary" href="Preview" role="button">Return</a>
    </body>
</html>
