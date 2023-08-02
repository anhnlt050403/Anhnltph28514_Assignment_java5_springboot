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
            width: 5%;
        }

        th:nth-child(2), td:nth-child(2) {
            width: 11%;
        }

        th:nth-child(3), td:nth-child(3) {
            width: 6%;
        }

        th:nth-child(4), td:nth-child(4) {
            width: 6%;
        }

        th:nth-child(5), td:nth-child(5) {
            width: 7%;
        }
        th:nth-child(6), td:nth-child(6) {
            width: 6%;
        }
        th:nth-child(7), td:nth-child(7) {
            width: 7%;
        }
        th:nth-child(8), td:nth-child(8) {
            width: 6%;
        }
        th:nth-child(9), td:nth-child(9) {
            width: 7%;
        }
        th:nth-child(10), td:nth-child(10) {
            width: 7%;
        }
        th:nth-child(11), td:nth-child(11) {
            width: 6%;
        }
        th:nth-child(12), td:nth-child(12) {
            width: 6%;
        }
        th:last-child, td:last-child {
            width: 20%;
        }
    </style>

</head>
<body>


<div class="trangchu">
    <form action="/home/hien-thi" style="float: right">
        <button class="btn" type="submit">TRANG CHU</button>
    </form>
</div>
<div class="container" style="padding-top: 50px">
    <div class="row">
<%--        <div class="col-md-10">--%>
            <form:form action="/nhan-vien/add-nhan-vien" method="post" onsubmit="return checkAdd()"
                       modelAttribute="nhanVien">
                <table class="table1" style="background-color: darkgoldenrod">
                    <tr>

                        <th style="text-align: center"><form:label path="ma">Mã Nhân Viên</form:label></th>
                        <th style="text-align: center"><form:label path="ho">Họ Nhân Viên</form:label></th>
                        <th style="text-align: center"><form:label path="tenDem">Tên Đệm Nhân Viên</form:label></th>
                        <th style="text-align: center"><form:label path="ten">Tên Nhân Viên</form:label></th>

                    </tr>
                    <tr>

                        <td style="text-align: center"><form:input path="ma"></form:input></td>
                        <td style="text-align: center"><form:input path="ho"></form:input></td>
                        <td style="text-align: center"><form:input path="tenDem"></form:input></td>
                        <td style="text-align: center"><form:input path="ten"></form:input></td>

                    </tr>
                    <tr>
                        <th style="text-align: center"><form:label
                                path="ngaySinh">Ngày Sinh(YYYY-MM-DD)</form:label></th>
                        <th style="text-align: center"><form:label path="sdt">Số Điện Thoại</form:label></th>
                        <th style="text-align: center"><form:label path="diaChi">Địa Chỉ</form:label></th>
                        <th style="text-align: center"><form:label path="matKhau">Mật Khẩu</form:label></th>
                    </tr>
                    <tr>
                        <td style="text-align: center"><form:input path="ngaySinh"></form:input></td>
                        <td style="text-align: center"><form:input path="sdt"></form:input></td>
                        <td style="text-align: center"><form:input path="diaChi"></form:input></td>
                        <td style="text-align: center"><form:input path="matKhau"></form:input></td>
                    </tr>
                    <tr>
                        <th style="text-align: center"><form:label path="gioiTinh">Giới Tính</form:label></th>
                        <th style="text-align: center"><form:label path="cuaHang">Cửa Hàng</form:label></th>
                        <th style="text-align: center"><form:label path="chucVu">Chưc Vụ</form:label></th>
                        <th style="text-align: center"><form:label path="trangThai">Trạng Thái</form:label></th>
                    </tr>
                    <tr>
                        <td style="text-align: center">
                            <form:radiobutton path="gioiTinh" value="Nam" label="Nam"/>
                            <form:radiobutton path="gioiTinh" value="Nữ" label="Nữ"/>
                        </td>
                        <td style="text-align: center">
                            <form:select path="cuaHang" items="${cuaHang}" itemValue="id"
                                         itemLabel="ten"/>
                        </td>
                        <td style="text-align: center">
                            <form:select path="chucVu" items="${chucVu}" itemValue="id"
                                         itemLabel="ten"/>
                        </td>
                        <td style="text-align: center">
                            <form:radiobutton path="trangThai" value="0" label="Nhân viên cũ"/>
                            <form:radiobutton path="trangThai" value="1" label="Nhân viên mới"/>
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td style="text-align: center">
                            <button type="submit" class="btn btn-secondary">Thêm Nhân Viên</button>
                        </td>
                    </tr>
                </table>
            </form:form>
        </div>

        <hr>
        <br>
        <hr>
        <div class="">
            <form:form action="/nhan-vien/search-nhan-vien" onsubmit="return checkSearch()" modelAttribute="nhanVien"
                       method="post">
                <table class="table" style="background-color: aqua">
                    <tr>
                        <th style="text-align: center">Tìm Kiếm Theo Tên: <input type="text" name="tenTk"
                                                                                 style="text-align: center ;">
                        </th>
                    </tr>
                    <tr>
                        <td style="text-align: center">
                            <button class="btn btn-secondary">Tìm Nhân Viên</button>
                        </td>
                    </tr>
                </table>
            </form:form>
        </div>
    </div>
</div>
<hr>
<h4 style="text-align: center;">Danh Sách Nhân Viên</h4>
<hr>

<div class="container">
    <table class="table" style="background-color:#00FF00">
    <tr>
        <th>Mã NV</th>
        <th>Họ Tên NV</th>
        <th>Giới Tính</th>
        <th>SĐT</th>
        <th>Ngày Sinh</th>
        <th>Địa Chị</th>
        <th>Mật Khẩu</th>
        <th>Chức Vụ</th>
        <th>Cửa Hàng</th>
        <th>Trạng Thái</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${list}" var="nhanVien">
        <tr>
            <td>${nhanVien.ma}</td>
            <td>${nhanVien.ho} ${nhanVien.tenDem} ${nhanVien.ten}</td>
            <td>${nhanVien.gioiTinh}</td>
            <td>${nhanVien.sdt}</td>
            <td>${nhanVien.ngaySinh}</td>
            <td>${nhanVien.diaChi}</td>
            <td>${nhanVien.matKhau}</td>
            <td>${nhanVien.chucVu.ten}</td>
            <td>${nhanVien.cuaHang.ten}</td>
            <td>
                <c:if test="${nhanVien.trangThai ==0}">Nhân Viên Cũ</c:if>
                <c:if test="${nhanVien.trangThai ==1}">Nhân Viên Mới</c:if>
            </td>
            <td>
                <a href="/nhan-vien/detail-nhan-vien/${nhanVien.id}" class="btn btn-success "
                   tabindex="-1"
                   role="button"
                   onclick="return checkDetail()">Detail</a>
                <a href="/nhan-vien/view-update-nhan-vien/${nhanVien.id}" class="btn btn-success "
                   tabindex="-1"
                   role="button"
                   aria-disabled="true" onclick="return checkViewUpdate()">Update</a>
                <a href="/nhan-vien/remove-nhan-vien/${nhanVien.id}" class="btn btn-success "
                   tabindex="-1"
                   role="button"
                   aria-disabled="true" onclick="return checkRemove()">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
    <nav aria-label="Page navigation example" style="margin-top: 100px">
    <ul class="pagination justify-content-center pagination-lg">
        <li class="page-item"><a class="page-link" href="/nhan-vien/hien-thi?pageNum=0">First</a></li>
        <c:forEach begin="1" end="${total}" varStatus="status">
            <li class="page-item">
                <a href="${pageContext.request.contextPath}/nhan-vien/hien-thi?pageNum=${status.index -1}"
                   class="page-link">${status.index}</a>
            </li>
        </c:forEach>
        <li class="page-item"><a class="page-link" href="/nhan-vien/hien-thi?pageNum=${total-1}">Last</a></li>
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
