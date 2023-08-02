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
            width: 20%;
        }

        th:nth-child(2), td:nth-child(2) {
            width: 20%;
        }
        th:nth-child(3), td:nth-child(3) {
            width: 20%;
        }
        th:last-child, td:last-child {
            width: 30%;
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
        <div class="col-md-6">
            <form:form action="/cua-hang/add-cua-hang" method="post" modelAttribute="cuaHang">
                <table class="table1" style="background-color: darkgoldenrod">
                    <tr>
                        <th style="text-align: center"><form:label path="ma">Mã Cửa Hàng</form:label></th>
                        <th style="text-align: center"><form:label path="ten">Tên Cửa Hàng</form:label></th>
                        <th style="text-align: center"><form:label path="diaChi">Địa Chỉ</form:label></th>
                        <th style="text-align: center"><form:label path="thanhPho">Thành Phố</form:label></th>
                        <th style="text-align: center"><form:label path="quocGia">Quốc Gia</form:label></th>
                    </tr>
                    <tr>

                        <td style="text-align: center"><form:input path="ma"></form:input></td>
                        <td style="text-align: center"><form:input path="ten"></form:input></td>
                        <td style="text-align: center"><form:input path="diaChi"></form:input></td>
                        <td style="text-align: center"><form:input path="thanhPho"></form:input></td>
                        <td style="text-align: center"><form:input path="quocGia"></form:input></td>
                    </tr>
                    <tr>
                        <td style="text-align: center" colspan="5">
                            <button type="submit" class="btn btn-secondary">Thêm Cửa Hàng</button>
                        </td>
                    </tr>
                </table>
            </form:form>
        </div>
        <hr>
        <div class="col-md-6">
            <!-- Tìm Kiếm Form -->
            <form action="/cua-hang/search-cua-hang" onsubmit="return checkSearch()" method="post">
                <table class="table" style="background-color: aqua">
                    <tr>
                        <th style="text-align: center">Tìm Kiếm Theo Tên: <input type="text" name="tenTk"
                                                                                 style="text-align: center ;"
                        ></th>
                    </tr>
                    <tr>
                        <td style="text-align: center">
                            <button class="btn btn-secondary">Tìm Cửa Hàng</button>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</div>
<hr>
<h4 style="text-align: center;">Danh Sách Cửa Hàng</h4>
<hr>

<div class="container">
    <table class="table" style="background-color:#00FF00">
        <tr>
            <th>Mã Cửa Hàng</th>
            <th>Tên Cửa Hàng</th>
            <th>Địa Chỉ Chi Tiết Cửa Hàng</th>
            <th>Action</th>
        </tr>
        <c:forEach items="${list}" var="cuaHang">
            <tr>
                <td>${cuaHang.ma}</td>
                <td>${cuaHang.ten}</td>
                <td>${cuaHang.diaChi} ; ${cuaHang.thanhPho} ; ${cuaHang.quocGia}</td>
                <td>
                    <a href="/cua-hang/detail-cua-hang/${cuaHang.id}" class="btn btn-success "
                       tabindex="-1"
                       role="button"
                       onclick="return checkDetail()">Detail</a>
                    <a href="/cua-hang/view-update-cua-hang/${cuaHang.id}" class="btn btn-success "
                       tabindex="-1"
                       role="button"
                       aria-disabled="true" onclick="return checkViewUpdate()">Update</a>
                    <a href="/cua-hang/remove-cua-hang/${cuaHang.id}" class="btn btn-success "
                       tabindex="-1"
                       role="button"
                       aria-disabled="true">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <nav aria-label="Page navigation example" style="padding-top: 150px">
        <ul class="pagination justify-content-center pagination-lg">
            <li class="page-item"><a class="page-link" href="/cua-hang/hien-thi?pageNum=0">First</a></li>
            <c:forEach begin="1" end="${total}" varStatus="status">
                <li class="page-item">
                    <a href="${pageContext.request.contextPath}/cua-hang/hien-thi?pageNum=${status.index -1}"
                       class="page-link">${status.index}</a>
                </li>
            </c:forEach>
            <li class="page-item"><a class="page-link" href="/cua-hang/hien-thi?pageNum=${total-1}">Last</a></li>
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
