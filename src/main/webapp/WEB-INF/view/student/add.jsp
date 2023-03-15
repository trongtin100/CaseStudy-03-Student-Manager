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
<h2>Thêm mới quyền</h2>
<a href="<c:url value="/students"/>">Quay lại</a><br><br>

<form action="<c:url value="/student/add"/>" method="post">

  <label>Mã số sinh viên:</label><br>
  <input type="text" name="stuID"
         placeholder="Mời bạn nhập mã số sinh viên"><br><br>

  <label>Ho va Ten:</label><br>
  <input type="text" name="name"
         placeholder="Mời bạn nhập ho va ten"><br><br>

  <label>Day of birth:</label><br>
  <input type="text" name="dayofbirth"
         placeholder="Mời bạn nhập ngay sinh"><br><br>


  <label>email:</label><br>
  <input type="text" name="email"
         placeholder="Mời bạn nhập email"><br><br>

  <label>dia chi:</label><br>
  <input type="text" name="address"
         placeholder="Mời bạn nhập dia chi"><br><br>


  <input type="submit" value="Lưu">
</form>
</body>
</html>
