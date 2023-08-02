<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 30/03/2023
  Time: 5:42 CH
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

        .table {
            table-layout: fixed;
            width: 100%;
        }

        th:first-child, td:first-child {
            width: 8%;
        }

        th:nth-child(2), td:nth-child(2) {
            width: 8%;
        }

        th:nth-child(3), td:nth-child(3) {
            width: 8%;
        }

        th:nth-child(4), td:nth-child(4) {
            width: 8%;
        }

        th:nth-child(5), td:nth-child(5) {
            width: 8%;
        }

        th:nth-child(6), td:nth-child(6) {
            width: 8%;
        }

        th:nth-child(7), td:nth-child(8) {
            width: 8%;
        }

        th:nth-child(8), td:nth-child(8) {
            width: 8%;
        }

        th:nth-child(9), td:nth-child(9) {
            width: 8%;
        }

        th:last-child, td:last-child {
            width: 28%;
        }
    </style>
</head>
<body>
<div class="trangchu">
    <form action="/home/hien-thi" style="float: right">
        <button class="btn" type="submit">TRANG CHU</button>
    </form>
</div>
<div class="container" style="padding-top: 100px">
    <div class="row">
        <form:form action="/gio-hang/add-gio-hang" method="post" onsubmit="return checkAdd()" modelAttribute="gioHang">
            <div class="container text-center">
                <table class="table1" style="background-color: darkgoldenrod">
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
                            <button type="submit" class="btn btn-secondary">Thêm Giỏ Hàng</button>
                        </td>
                    </tr>
                </table>
            </div>
        </form:form>
    </div>
</div>

        <h4 style="text-align: center;">Danh Sách Giỏ Hàng</h4>
<hr>
<div class="container">
    <table class="table" style="background-color:#00FF00">
            <tr>
                <th>Mã Giỏ Hàng</th>
                <th>Tên Khách Hàng</th>
                <th>Tên Nhân Viên</th>
                <th>Ngày Tạo</th>
                <th>Ngày Thanh Toán</th>
                <th>Tên Người Nhận</th>
                <th>Địa Chỉ</th>
                <th>Số Điện Thoại</th>
                <th>Tình Trạng</th>
                <th>Action</th>
            </tr>
            <c:forEach items="${list}" var="gioHang">
                <tr>
                    <td>${gioHang.id}</td>
                    <td>${gioHang.khachHang.ten}</td>
                    <td>${gioHang.nhanVien.ten}</td>
                    <td>${gioHang.ngayTao}</td>
                    <td>${gioHang.ngayThanhToan}</td>
                    <td>${gioHang.tenNguoiNhan}</td>
                    <td>${gioHang.diaChi}</td>
                    <td>${gioHang.sdt} </td>
                    <td>
                        <c:if test="${gioHang.tinhTrang == 0}">Chờ Thanh Toán</c:if>
                        <c:if test="${gioHang.tinhTrang == 1}">Đã Thanh Toán</c:if>
                    </td>
                    <td>
                        <a href="/gio-hang/detail-gio-hang/${gioHang.id}" class="btn btn-success "
                           tabindex="-1"
                           role="button"
                           onclick="return checkDetail()">Detail</a>
                        <a href="/gio-hang/view-update-gio-hang/${gioHang.id}" class="btn btn-success "
                           tabindex="-1"
                           role="button"
                           aria-disabled="true" onclick="return checkViewUpdate()">Update</a>
                        <a href="/gio-hang/remove-gio-hang/${gioHang.id}" class="btn btn-success "
                           tabindex="-1"
                           role="button"
                           aria-disabled="true" onclick="return checkRemove()">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
</div>
<nav aria-label="Page navigation example" style="margin-top: 100px">
            <ul class="pagination justify-content-center pagination-lg">
                <li class="page-item"><a class="page-link" href="/gio-hang/hien-thi?pageNum=0">First</a></li>
                <c:forEach begin="1" end="${total}" varStatus="status">
                    <li class="page-item">
                        <a href="/gio-hang/hien-thi?pageNum=${status.index -1}"
                           class="page-link">${status.index}</a>
                    </li>
                </c:forEach>
                <li class="page-item"><a class="page-link" href="/gio-hang/hien-thi?pageNum=${total-1}">Last</a></li>
            </ul>
        </nav>


</body>
<footer>

</footer>
<script src="../js/checkValidate.js"></script>
</html>
