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
        <form:form action="/chi-tiet-sp/add-chi-tiet-sp" method="post" onsubmit="return checkAdd()"
                   modelAttribute="chiTiet">
        <table class="table1" style="background-color: darkgoldenrod">
            <tr>
                <td><form:label path="sanPham">Tên Sản Phẩm</form:label></td>
                <td>
                    <form:select path="sanPham" items="${sanPham}" itemLabel="ten" itemValue="id">
                        ${sanPham.ten}
                    </form:select>
                </td>
                <td><form:label path="nhaSanXuat">Tên Nhà Sản Xuất</form:label></td>
                <td>
                    <form:select path="nhaSanXuat" items="${nhaSanXuat}" itemLabel="ten" itemValue="id">
                        ${nhaSanXuat.ten}
                    </form:select>
                </td>
                <td><form:label path="mauSac">Tên Màu Sắc</form:label></td>
                <td>
                    <form:select path="mauSac" items="${mauSac}" itemValue="id" itemLabel="ten">
                        ${mauSac.ten}
                    </form:select>
                </td>
                <td><form:label path="dongSanPham">Tên Dòng Sản Phẩm</form:label></td>
                <td>
                    <form:select path="dongSanPham" items="${dongSanPham}" itemValue="id" itemLabel="ten">
                        ${dongSanPham.ten}
                    </form:select>
                </td>
            </tr>
            <tr>
                <td><form:label path="namBaoHanh">Năm Bảo Hành</form:label></td>
                <td><form:input path="namBaoHanh"></form:input></td>
                <td><form:label path="moTa">Mô tả</form:label></td>
                <td><form:input path="moTa"></form:input></td>
                <td><form:label path="soLuongTon">Số Lượng Tồn Kho</form:label></td>
                <td><form:input path="soLuongTon"></form:input></td>
            </tr>
            <tr>

                <td><form:label path="giaNhap">Giá Nhập</form:label></td>
                <td><form:input path="giaNhap"></form:input></td>
                <td><form:label path="giaBan">Giá Bán</form:label></td>
                <td><form:input path="giaBan"></form:input></td>
            </tr>
            <tr>
                <td colspan="6">
                    <button type="submit" class="btn btn-secondary">Thêm Sản Phẩm</button>
                </td>
            </tr>
        </table>
    </div>
    </form:form>
</div>
</div>

<hr>
<h4 style="text-align: center;">Danh Sách Sản Phẩm</h4>
<hr>
<div class="container">
    <table class="table" style="background-color: #00FF00">
        <tr>
            <th>Tên Sản Phẩm</th>
            <th>Tên Nhà Sản Xuất</th>
            <th>Tên Màu Sắc</th>
            <th>Tên Dòng Sản Phẩm</th>
            <th>Năm Bảo Hành</th>
            <th>Mô Tả</th>
            <th>Số Lượng Tồn Kho</th>
            <th>Giá Nhập</th>
            <th> Giá Bán</th>
            <th>Action</th>
        </tr>
        <c:forEach items="${list}" var="chiTiet">
            <tr>
                <td>${chiTiet.sanPham.ten}</td>
                <td>${chiTiet.nhaSanXuat.ten}</td>
                <td>${chiTiet.mauSac.ten}</td>
                <td>${chiTiet.dongSanPham.ten}</td>
                <td>${chiTiet.namBaoHanh}</td>
                <td>${chiTiet.moTa}</td>
                <td>${chiTiet.soLuongTon}</td>
                <td>${chiTiet.giaNhap} </td>
                <td>${chiTiet.giaBan}</td>
                <td>
                    <a href="/chi-tiet-sp/detail-chi-tiet-sp/${chiTiet.id}" class="btn btn-success "
                       tabindex="-1"
                       role="button"
                       onclick="return checkDetail()">Detail</a>
                    <a href="/chi-tiet-sp/view-update-chi-tiet-sp/${chiTiet.id}" class="btn btn-success "
                       tabindex="-1"
                       role="button"
                       aria-disabled="true" onclick="return checkViewUpdate()">Update</a>
                    <a href="/chi-tiet-sp/remove-chi-tiet-sp/${chiTiet.id}" class="btn btn-success "
                       tabindex="-1"
                       role="button"
                       aria-disabled="true" onclick="return checkRemove()">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
    <nav aria-label="Page navigation example" style="padding-top: 150px">
        <ul class="pagination justify-content-center pagination-lg">
            <li class="page-item"><a class="page-link" href="/chi-tiet-sp/hien-thi?pageNum=0">First</a></li>
            <c:forEach begin="1" end="${total}" varStatus="status">
                <li class="page-item">
                    <a href="/chi-tiet-sp/hien-thi?pageNum=${status.index -1}"
                       class="page-link">${status.index}</a>
                </li>
            </c:forEach>
            <li class="page-item"><a class="page-link" href="/chi-tiet-sp/hien-thi?pageNum=${total-1}">Last</a></li>
        </ul>
    </nav>
</div>
</section>
</body>
<footer>
    <%--    <div class="py-1 bg-dark container-fluid">--%>
    <%--        <p class="m-0 text-center text-white"></p>--%>
    <%--    </div>--%>
</footer>
<script src="../js/checkValidate.js"></script>
</html>
