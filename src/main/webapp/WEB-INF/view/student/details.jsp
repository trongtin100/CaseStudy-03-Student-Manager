<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
  <title>Quản lý hoc sinh</title>
  <style>
    table, th, td {
      border: 1px solid black;
      border-collapse: collapse;
    }
  </style>
</head>
<body>
<h2>Thông tin chi tiết của sinh viên</h2>
<a href="<c:url value="/students"/>">Quay lại</a>
<p><b>Mã số: </b> ${students.stuID}</p>
<p><b>Họ tên: </b> ${students.namestu}</p>
<p><b>Ngày sinh: </b> ${students.dateofbirth}</p>
<p><b>Email: </b> ${students.email}</p>
<p><b>Địa chỉ: </b> ${students.address}</p>

</body>
</html>
