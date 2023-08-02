
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
<section>
    <form:form action="/gio-hang/updategiohang/${gioHang.id}" method="post"
               modelAttribute="gioHang">
        <div class="container text-center"  style="padding-top: 50px">
            <table class="table" style="background-color: lawngreen">
                <tr>

                    <th colspan="2"><form:label path="khachHang">Tên Khách Hàng</form:label></th>
                    <th colspan="2"><form:label path="nhanVien">Tên Nhân Viên</form:label></th>
                    <th colspan="2"><form:label path="ma">Mã Giỏ Hàng</form:label></th>
                </tr>
                <tr>

                    <td colspan="2">
                        <form:select path="khachHang" items="${khachHang}" itemLabel="ten"
                                     itemValue="id">${khachHang.ten}</form:select>
                    </td>
                    <td colspan="2">
                        <form:select path="nhanVien" items="${nhanVien}" itemLabel="ten"
                                     itemValue="id">${nhanVien.ten}</form:select>
                    </td>
                    <td colspan="2">
                        <form:input path="ma"></form:input>
                    </td>
                </tr>
                <tr>
                    <th><form:label path="ngayTao">Ngày Tạo</form:label></th>
                    <th><form:label path="ngayThanhToan">Ngày Thanh Toán</form:label></th>
                    <th><form:label path="tenNguoiNhan">Tên Người Nhận</form:label></th>
                    <th><form:label path="diaChi">Địa Chỉ</form:label></th>
                    <th><form:label path="sdt">Số Điện Thoại</form:label></th>
                    <th><form:label path="tinhTrang">Tình Trạng</form:label></th>
                </tr>
                <tr>
                    <td>
                        <form:input path="ngayTao" type="date"></form:input>
                    </td>
                    <td><form:input path="ngayThanhToan" type="date"></form:input></td>
                    <td><form:input path="tenNguoiNhan"></form:input></td>
                    <td><form:input path="diaChi"></form:input></td>
                    <td><form:input path="sdt"></form:input></td>
                    <td>
                        <form:radiobutton path="tinhTrang" value="0" label="Chờ Thanh Toán"/>
                        <form:radiobutton path="tinhTrang" value="1" label="Đã Thanh Toán"/>
                        
                    </td>
                </tr>
                <tr>
                    <td colspan="6">
                        <button type="submit" class="btn btn-secondary">Sửa Giỏ Hàng</button>
                    </td>
                </tr>
            </table>
        </div>
    </form:form>
</section>
</body>
<script src="../js/checkValidate.js"></script>
</html>
