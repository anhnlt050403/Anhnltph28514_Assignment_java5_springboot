<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="en">
<head>
    <title>Title</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">


</head>
<body>

<br><br>

<form action="/home/hien-thi" style="float: right">
    <button class="btn btn-success" type="submit">TRANG CHU</button>
</form>


<br>

<form:form action="/hoa-don/update/${hoaDon.id}" method="post" modelAttribute="hoaDon">


    <table class="table " style="background-color:#999999">
        <tbody>
        <tr>
            <td> KHÁCH HÀNG:</td>
            <th>
<%--                <form:select path="khachHang" items="${khachHang}" itemValue="ten" id="idkh">${khachHang.ten}--%>
<%--                </form:select>--%>
                <form:select path="khachHang" items="${khachHang}" itemLabel="ten"
                             itemValue="id">${khachHang.ten}</form:select>

            </th>
        </tr>
        </tbody>

        <tbody>
        <tr>
            <td> NhÂN VIÊN:</td>
            <th>
<%--                <form:select path="nhanVien" items="${nhanVien}" itemValue="ten" id="idnv">${nhanVien.ten}--%>
<%--                </form:select>--%>
    <form:select path="nhanVien" items="${nhanVien}" itemLabel="ten"
                 itemValue="id">${nhanVien.ten}</form:select>

            </th>
        </tr>
        </tbody>

        <tr>
            <td> MÃ:</td>
            <th><form:input path="ma" id="ma"></form:input></th>
        </tr>

        <tr>
            <td> NGÀY TẠO:</td>
            <th><form:input path="ngayTao" id="ngaytao" type="date"></form:input></th>
        </tr>

        <tr>
            <td> NGÀY THANH TOÁN:</td>
            <th><form:input path="ngayThanhToan" id="ngaythanhtoan" type="date"></form:input></th>
        </tr>

        <tr>
            <td> NGÀY SHIP:</td>
            <th><form:input path="ngayShip" id="ngayship" type="date"></form:input></th>
        </tr>

        <tr>
            <td> NGÀY NhẬN:</td>
            <th><form:input path="ngayNhan" id="ngaynhan" type="date"></form:input></th>
        </tr>

        <tr>
            <td> TÌNH TRẠNG:</td>
            <th>
                <form:radiobutton path="tinhTrang" value="1" label="ĐÃ THANH TOÁN"></form:radiobutton>

                <br><br>
                <form:radiobutton path="tinhTrang" value="0" label="CHỜ THANH TOÁN"></form:radiobutton>

            </th>
        </tr>
        <tr>
            <td> TÊN NGƯỜI NHẬN:</td>
            <th><form:input path="tenNguoiNhan" id="tennguoinhan"></form:input></th>
        </tr>
        <tr>
            <td> ĐỊA CHỈ:</td>
            <th><form:input path="diaChi" id="diachi"></form:input></th>
        </tr>
        <tr>
            <td> SDT:</td>
            <th><form:input path="sdt" id="sdt" type="number"></form:input></th>
        </tr>

        <tr>
            <td>

                <button type="submit" style="float: right" class="btn btn-success" onclick="return kiemtrathem()"
                        id="btt">UPDATE
                </button>
            </td>
            <th></th>
        </tr>


    </table>
</form:form>
<a class="btn btn-success" href="/hoa-don/view-add" onclick="return myFunction4()">ADD</a>



<br><br>
<table class="table table-bordered border-primary" style="background-color:#00FF00">
    <thead>
    <tr>
        <th scope="col">ID</th>
                <th scope="col">TEN KHACH HANG</th>
                <th scope="col">TEN NHAN VIEN</th>
        <th scope="col">MA</th>
        <th scope="col">NGAY TAO</th>
        <th scope="col">NGAY THANH TOAN</th>

        <th scope="col">NGAY SHIP</th>
        <th scope="col">NGAY NHAN</th>


        <th scope="col">TINH TRANG</th>
        <th scope="col">Ten NGUOI NHAN</th>
        <th scope="col">DIA CHI</th>
        <th scope="col">SDT</th>


        <th scope="col">DELETE</th>
        <th scope="col">DETAIL</th>

    </tr>
    </thead>
    <tbody>
    <c:forEach items="${dulieu}" var="ht" varStatus="">
        <tr>
            <td>${ht.id}</td>
            <th>${ht.khachHang.ho} ${ht.khachHang.tenDem} ${ht.khachHang.ten}</th>
            <th>${ht.nhanVien.ho} ${ht.nhanVien.tenDem} ${ht.nhanVien.ten}</th>
            <th>${ht.ma}</th>
            <td>${ht.ngayTao}</td>
            <td>${ht.ngayThanhToan}</td>

            <td>${ht.ngayShip}</td>
            <td>${ht.ngayNhan}</td>

            <th>${ht.tinhTrang()}</th>
            <th>${ht.tenNguoiNhan}</th>
                <%--                ${ht.cns(ht.ngaySinh)}--%>
            <th>${ht.diaChi}</th>
            <td>${ht.sdt}</td>


            <td><a href="/hoa-don/delete/${ht.id}" onclick="return myFunction1()" class="btn btn-success">DELETE</a>
            </td>
            <td><a href="/hoa-don/detail/${ht.id}" onclick="return myFunction2()" class="btn btn-success">DETAIL</a>
            </td>


        </tr>
    </c:forEach>
    </tbody>
</table>

<br>
<nav aria-label="Page navigation example">
    <ul class="pagination justify-content-center pagination-lg">
        <li class="page-item"><a class="page-link" href="/hoa-don/hien-thi?pageNum=0">First</a></li>

        <c:forEach begin="1" end="${total}" varStatus="status">
            <li class="page-item">
                <a href="${pageContext.request.contextPath}/hoa-don/hien-thi?pageNum=${status.index -1}"
                   class="page-link">${status.index}</a>
            </li>
        </c:forEach>

        <li class="page-item"><a class="page-link" href="/hoa-don/hien-thi?pageNum=${total-1}">Last</a></li>
    </ul>
</nav>
<p id="kt" name="kt"></p>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
        integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"
        integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD"
        crossorigin="anonymous"></script>
</body>
</html>
