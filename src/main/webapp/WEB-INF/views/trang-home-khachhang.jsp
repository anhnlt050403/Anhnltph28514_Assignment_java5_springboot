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

        th:nth-child(7), td:nth-child(7) {
            width: 8%;
        }

        th:nth-child(8), td:nth-child(8) {
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

        <form:form action="/khach-hang/add-khach-hang" method="post" onsubmit="return checkAdd()"
                   modelAttribute="khachHang">
            <table class="table1" style="background-color: darkgoldenrod">
                <tr>

                    <th style="text-align: center"><form:label path="ma">Mã Khách Hàng</form:label></th>
                    <th style="text-align: center"><form:label path="ho">Họ Khách Hàng</form:label></th>
                    <th style="text-align: center"><form:label path="tenDem">Tên Đệm Khách Hàng</form:label></th>
                    <th style="text-align: center"><form:label path="ten">Tên Khách Hàng</form:label></th>
                    <th style="text-align: center"><form:label path="ngaySinh">Ngày Sinh(YYYY-MM-DD)</form:label></th>
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
                        <button type="submit" class="btn btn-secondary">Thêm Khách Hàng</button>
                    </td>
                    <td></td>
                    <td></td>
                </tr>
            </table>
        </form:form>
    </div>

    <hr>

    <hr>
    <div class="col-md-6">
        <form:form action="/khach-hang/search-khach-hang" onsubmit="return checkSearch()" modelAttribute="khachHang"
                   method="post">
            <table class="table" style="background-color: aqua">
                <tr>
                    <th style="text-align: center">Tìm Kiếm Theo Tên: <input type="text" name="tenTk"
                                                                             style="text-align: center ;">
                    </th>
                </tr>
                <tr>
                    <td style="text-align: center">
                        <button class="btn btn-secondary">Tìm Khách Hàng</button>
                    </td>
                </tr>
            </table>
        </form:form>
    </div>
</div>
<hr>
<h4 style="text-align: center;">Danh Sách Khách Hàng</h4>
<hr>
<div class="container">
    <table class="table " style="background-color:#00FF00">
    <tr>
        <th>Mã Khách Hàng</th>
        <th>Họ Tên Khách Hàng</th>
        <th>Ngày Sinh</th>
        <th>SĐT</th>
        <th>Địa Chỉ</th>
        <th>Thành Phố-Quốc Gia</th>
        <th>Mật Khẩu</th>
        <th colspan="2">Action</th>
    </tr>
    <c:forEach items="${list}" var="khachHang">
        <tr>
            <td>${khachHang.ma}</td>
            <td>${khachHang.ho} ${khachHang.tenDem} ${khachHang.ten}</td>
            <td>${khachHang.ngaySinh}</td>
            <td>${khachHang.sdt}</td>
            <td>${khachHang.diaChi}</td>
            <td>${khachHang.thanhPho} ${khachHang.quocGia}</td>
            <td>${khachHang.matKhau}</td>
            <td colspan="2">
                <a href="/khach-hang/detail-khach-hang/${khachHang.id}" class="btn btn-success "
                   tabindex="-1"
                   role="button"
                   onclick="return checkDetail()">Detail</a>
                <a href="/khach-hang/view-update-khach-hang/${khachHang.id}" class="btn btn-success "
                   tabindex="-1"
                   role="button"
                   aria-disabled="true" onclick="return checkViewUpdate()">Update</a>
                <a href="/khach-hang/remove-khach-hang/${khachHang.id}" class="btn btn-success "
                   tabindex="-1"
                   role="button"
                   aria-disabled="true" onclick="return checkRemove()">Delete</a>
            </td>
            </td>
        </tr>
    </c:forEach>
</table>
    <nav aria-label="Page navigation example" style="padding-top: 150px">
    <ul class="pagination justify-content-center pagination-lg">
        <li class="page-item"><a class="page-link" href="/khach-hang/hien-thi?pageNum=0">First</a></li>
        <c:forEach begin="1" end="${total}" varStatus="status">
            <li class="page-item">
                <a href="${pageContext.request.contextPath}/khach-hang/hien-thi?pageNum=${status.index -1}"
                   class="page-link">${status.index}</a>
            </li>
        </c:forEach>
        <li class="page-item"><a class="page-link" href="/khach-hang/hien-thi?pageNum=${total-1}">Last</a></li>
    </ul>
</nav>
</div>

</body>
<footer>
<%--    <div class="py-1 bg-dark container-fluid">--%>
<%--        <p class="m-0 text-center text-white"></p>--%>
<%--    </div>--%>
</footer>
<script src="../js/checkValidate.js"></script>
</html>
