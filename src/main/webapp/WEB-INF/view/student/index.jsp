<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Quản lý sinh viên</title>
    <style>
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
        }
    </style>
</head>
<body>
<h2>Danh sách sinh viên</h2>
<a type="submit" href="<c:url value="/student/add"/>">Thêm</a>

<table>
    <tr>
        <th>Mã số sinh viên</th>
        <th>Họ và tên </th>
        <th>Ngày sinh</th>
        <th>email</th>
        <th>Address</th>
        <td>Thao tác</td>

    </tr>
    <c:forEach var="student" items="${students}">
        <tr>
            <td>${student.stuID}</td>
            <td>${student.namestu}</td>
            <td>${student.dateofbirth}</td>
            <td>${student.email}</td>
            <td>${student.address}</td>
            <td>
                <a href="<c:url value="/student/details"/>?stuID=${student.stuID}">Xem</a> |
                <a href="<c:url value="/student/edit"/>?stuID=${student.stuID}">Sửa</a> |
                <a href="<c:url value="/student/remove"/>?stuID=${student.stuID}">Xóa</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
