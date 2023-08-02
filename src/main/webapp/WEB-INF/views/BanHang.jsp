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
<form action="/home/hien-thi" style="float: right">
    <button class="btn btn-success" type="submit">TRANG CHU</button>
</form>


<P STYLE="text-align: center;font-size: 50px">BÁN HÀNG</P>
<br>
<P>Danh sách hóa dơn </P>


<form action="/ban-hang/tao-hoa-don">
    <button style="float: right" class="btn btn-success" type="submit">TẠO HÓA ĐƠN</button>
</form>
<br><br>
<table class="table" style="background-color:#00FF00">
    <thead>
    <tr>
        <th scope="col">ID</th>

        <th scope="col">MÃ HÓA ĐƠN</th>

        <th scope="col">TỔNG SẢN PHẨM</th>
        <th scope="col">TỔNG TIỀN</th>
        <th scope="col">NGAY TAO</th>

        <th scope="col">TINH TRANG</th>
        <th scope="col">CHỨC NĂNG</th>


    </tr>
    </thead>
    <tbody>
    <c:forEach items="${dulieu}" var="ht" varStatus="stt">
        <tr>
            <td>${stt.index}</td>

            <th>${ht.ma}</th>
            <th>${ht.tongSanPham}</th>
            <th>${ht.tongTien} VND</th>
            <td>${ht.ngayTao}</td>


            <th>${ht.tinhTrang}</th>


            <td>
                <form action="/ban-hang/detail-hoadon" method="post" modelAttribute="ht">
                    <input type="text" value="${ht.id}" name="id" style="display: none">
                    <button class="btn btn-success" type="submit"> XEM HÓA ĐƠN</button>

                </form>


            </td>


        </tr>
    </c:forEach>
    </tbody>
</table>

<br>
<nav aria-label="Page navigation example">
    <ul class="pagination justify-content-center pagination-lg">
        <li class="page-item"><a class="page-link" href="/ban-hang/hien-thi?pageNum=0">First</a></li>

        <c:forEach begin="1" end="${total}" varStatus="status">
            <li class="page-item">
                <a href="${pageContext.request.contextPath}/ban-hang/hien-thi?pageNum=${status.index -1}"
                   class="page-link">${status.index}</a>
            </li>
        </c:forEach>

        <li class="page-item"><a class="page-link" href="/ban-hang/hien-thi?pageNum=${total-1}">Last</a></li>
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