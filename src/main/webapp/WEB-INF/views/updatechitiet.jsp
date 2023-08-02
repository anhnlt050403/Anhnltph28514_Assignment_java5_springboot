<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 06/04/2023
  Time: 1:39 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
            integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"
            integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD"
            crossorigin="anonymous"></script>
    <title>Title</title>
    <style>
        .btn {
            border: 2px solid black;
            background-color: white;
            color: blue;
            padding: 10px 20px; /* thay đổi theo nhu cầu */
            border-radius: 5px; /* thay đổi theo nhu cầu */
            transition: all 0.3s ease; /* thay đổi thời gian và kiểu chuyển động tuỳ theo nhu cầu */
        }

        .btn:hover {
            background-color: blue;
            color: white;
            cursor: pointer;
        }
    </style>
</head>
<body>


<div class="trangchu">
    <form action="/home/hien-thi" style="float: right">
        <button class="btn" type="submit">TRANG CHU</button>
    </form>
</div>
<form:form action="/chi-tiet-sp/update-chi-tiet-sp/${chiTiet.id}" method="post" onsubmit="return checkAdd()"
           modelAttribute="chiTiet">
    <div class="container text-center">
        <table class="table1" style="background-color: lawngreen">
            <tr>

                <th colspan="2"><form:label path="sanPham">Tên Sản Phẩm</form:label></th>
                <th colspan="2"><form:label path="nhaSanXuat">Tên Nhà Sản Xuất</form:label></th>
                <th colspan="2"><form:label path="mauSac">Tên Màu Sắc</form:label></th>
            </tr>
            <tr>

                <td colspan="2">
                    <form:select path="sanPham" items="${sanPham}" itemLabel="ten" itemValue="id"/>
                </td>
                <td colspan="2">
                    <form:select path="nhaSanXuat" items="${nhaSanXuat}" itemLabel="ten" itemValue="id"/>
                </td>
                <td colspan="2">
                    <form:select path="mauSac" items="${mauSac}" itemValue="id" itemLabel="ten"/>
                </td>
            </tr>
            <tr>
                <th><form:label path="dongSanPham">Tên Dòng Sản Phẩm</form:label></th>
                <th><form:label path="namBaoHanh">Năm Bảo Hàng</form:label></th>
                <th><form:label path="moTa">Mô tả</form:label></th>
                <th><form:label path="soLuongTon">Số Lượng Tồn Kho</form:label></th>
                <th><form:label path="giaNhap">Giá Nhập</form:label></th>
                <th><form:label path="giaBan">Giá Bán</form:label></th>
            </tr>
            <tr>
                <td>
                    <form:select path="dongSanPham" items="${dongSanPham}" itemValue="id" itemLabel="ten"/>
                </td>
                <td><form:input path="namBaoHanh"></form:input></td>
                <td><form:input path="moTa"></form:input></td>
                <td><form:input path="soLuongTon"></form:input></td>
                <td><form:input path="giaNhap"></form:input></td>
                <td><form:input path="giaBan"></form:input></td>
            </tr>
            <tr>
                <td colspan="6">
                    <button type="submit" class="btn btn-secondary">Sửa Sản Phẩm</button>
                </td>
            </tr>
        </table>
    </div>
</form:form>
</body>
<footer>
    <%--    <div class="py-1 bg-dark container-fluid">--%>
    <%--        <p class="m-0 text-center text-white"></p>--%>
    <%--    </div>--%>
</footer>
<script src="../js/checkValidate.js"></script>
</html>
