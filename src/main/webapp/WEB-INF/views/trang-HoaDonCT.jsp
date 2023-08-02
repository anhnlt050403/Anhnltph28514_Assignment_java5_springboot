<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>


<form action="/home/hien-thi" style="float: right">
    <button class="btn btn-success" type="submit">TRANG CHU</button>
</form>


<a class="btn btn-success" href="/hoa-don-chi-tiet/view-add" onclick="return myFunction4()">ADD</a>


<br><br>
<table class="table" style="background-color:#00FF00">
    <thead>
    <tr>
        <%--        <th scope="col">ID</th>--%>
        <th scope="col">MA HOA DON</th>
        <th scope="col">SAN PHAM CHI TIET</th>

        <th scope="col">SỐ LƯỢNG</th>
        <th scope="col">DON GIA</th>


        <th scope="col">DELETE</th>

        <th scope="col">UPDATE</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${dulieu}" var="ht" varStatus="">
        <tr>
                <%--                            <td>${ht.id}<br>--%>
                <%--                                    ${ht.id.idHoadon.id}--%>
                <%--                                    <br>${ht.id.idChiTietSP.id}</td>--%>
            <th>${ht.id.hoaDon.ma} </th>
            <th>${ht.id.chiTietSP.sanPham.ma},${ht.id.chiTietSP.sanPham.ten},${ht.id.chiTietSP.nhaSanXuat.ten},${ht.id.chiTietSP.nhaSanXuat.ten},${ht.id.chiTietSP.mauSac.ten},${ht.id.chiTietSP.dongSanPham.ten},${ht.id.chiTietSP.namBaoHanh},${ht.id.chiTietSP.moTa},</th>
            <th>${ht.soLuong}</th>
            <td>${ht.donGia}</td>


            <td><a href="/hoa-don-chi-tiet/remove/${ht.id.hoaDon.id}/${ht.id.chiTietSP.id}"
                   onclick="return myFunction1()" class="btn btn-success">DELETE</a></td>

            <td><a href="/hoa-don-chi-tiet/view-update/${ht.id.hoaDon.id}/${ht.id.chiTietSP.id}"
                   onclick="return myFunction3()" class="btn btn-success">UPDATE</a></td>

        </tr>
    </c:forEach>
    </tbody>
</table>
<br>

<nav aria-label="Page navigation example">
    <ul class="pagination justify-content-center pagination-lg">
        <li class="page-item"><a class="page-link" href="/hoa-don-chi-tiet/hien-thi?pageNum=0">First</a></li>

        <c:forEach begin="1" end="${total}" varStatus="status">
            <li class="page-item">
                <a href="${pageContext.request.contextPath}/hoa-don-chi-tiet/hien-thi?pageNum=${status.index -1}"
                   class="page-link">${status.index}</a>
            </li>
        </c:forEach>

        <li class="page-item"><a class="page-link" href="/hoa-don-chi-tiet/hien-thi?pageNum=${total-1}">Last</a></li>
    </ul>
</nav>


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
