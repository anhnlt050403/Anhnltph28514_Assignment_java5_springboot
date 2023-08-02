<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 04/04/2023
  Time: 4:52 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <title>Title</title>    <style>
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

<br>
<br>
<br>
<section>
    <form:form action="/khach-hang/update-khach-hang/${khachHang.id}" method="post" modelAttribute="khachHang">
        <table class="table" style="background-color: lawngreen">
            <tr>

                <th style="text-align: center"><form:label path="ma">Mã Khách Hàng</form:label></th>
                <th style="text-align: center"><form:label path="ho">Họ Khách Hàng</form:label></th>
                <th style="text-align: center"><form:label path="tenDem">Tên Đệm Khách Hàng</form:label></th>
                <th style="text-align: center"><form:label path="ten">Tên Khách Hàng</form:label></th>
                <th style="text-align: center"><form:label path="ngaySinh">Ngày Sinh</form:label></th>
            </tr>
            <tr>

                <td style="text-align: center"><form:input path="ma"></form:input></td>
                <td style="text-align: center"><form:input path="ho"></form:input></td>
                <td style="text-align: center"><form:input path="tenDem"></form:input></td>
                <td style="text-align: center"><form:input path="ten"></form:input></td>
                <td style="text-align: center"><form:input path="ngaySinh"></form:input></td>
            </tr>
            <tr>

                <th style="text-align: center"><form:label path="sdt">Số Điện Thoại</form:label></th>
                <th style="text-align: center"><form:label path="diaChi">Địa Chỉ</form:label></th>
                <th style="text-align: center"><form:label path="thanhPho">Thành Phố</form:label></th>
                <th style="text-align: center"><form:label path="quocGia">Quốc Gia</form:label></th>
                <th style="text-align: center"><form:label path="matKhau">Mật Khẩu</form:label></th>
            </tr>
            <tr>

                <td style="text-align: center"><form:input path="sdt"></form:input></td>
                <td style="text-align: center"><form:input path="diaChi"></form:input></td>
                <td style="text-align: center"><form:input path="thanhPho"></form:input></td>
                <td style="text-align: center"><form:input path="quocGia"></form:input></td>
                <td style="text-align: center"><form:input path="matKhau"></form:input></td>
            </tr>
            <tr>
                <td></td>
                <td></td>
                <td style="text-align: center">
                    <button type="submit" class="btn">Sửa Khách Hàng</button>
                </td>
                <td></td>
                <td></td>
            </tr>
        </table>
    </form:form>
</section>
</body>
<footer>
<%--    <div class="py-1 bg-dark container-fluid">--%>
<%--        <p class="m-0 text-center text-white"></p>--%>
<%--    </div>--%>
</footer>
<script src="../js/checkValidate.js"></script>
</html>
