<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <title>Quản lý nhân viên</title>
  <style>
    table, th, td {
      border: 1px solid black;
      border-collapse: collapse;
    }
  </style>
</head>
<body>
<h2>Sửa nhân sinh viên</h2>
<a href="<c:url value="/students"/>">Quay lại</a><br><br>

<form action="<c:url value="/student/edit"/>" method="post">
  <input type="hidden" name="id" value="${students.stuID}" class="form-control" />


  <label>Mã số sinh viên:</label><br>
  <input type="text" name="stuID" value="${students.stuID}"
         placeholder="Mời bạn nhập mã số sinh viên"><br><br>

  <label>Họ tên:</label><br>
  <input type="text" name="name" value="${students.namestu}"
         placeholder="Mời bạn nhập họ tên"><br><br>

  <label>Ngày sinh:</label><br>
  <input type="text" name="dayofbirth" value="${students.dayofbirth}"
         placeholder="Mời bạn nhập ngày sinh"><br><br>

  <label>Email:</label><br>
  <input type="text" name="email" value="${students.email}"
         placeholder="Mời bạn nhập email"><br><br>

  <label>Địa chỉ:</label><br>
  <input type="text" name="address" value="${students.address}"
         placeholder="Mời bạn nhập địa chỉ"><br><br>

  <input type="submit" value="Lưu">
</form>
</form>
</body>
</html>
