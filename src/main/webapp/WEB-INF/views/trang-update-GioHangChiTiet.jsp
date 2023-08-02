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

<br><br>

<form action="/home/hien-thi" style="float: right">
    <button class="btn btn-success" type="submit">TRANG CHU</button>
</form>
<br><br>

<%--/${dulieuxem.id}--%>
<form:form action="/gio-hang-chi-tiet/update/${dulieuxem.id.gioHang.id}/${dulieuxem.id.chiTietSP.id}" method="post"
           modelAttribute="dulieuxem">


<table class="table " style="border: aliceblue 1px">

    <tbody>
    <tr>
        <td>MÃ GIỎ HÀNG:</td>
        <th>

            <form:select path="id.gioHang" items="${gioHang}" itemValue="id" itemLabel="ma" id="idhd"
                         disabled="true">
            </form:select>


        </th>
    </tr>
    </tbody>

    <tbody>

    <tr>
        <td> CHI TIẾT SẢN PHẨM:</td>
        <th>
            <form:select path="id.chiTietSP" items="${chiTiet}" itemValue="id" itemLabel="CTSP" id="idctsp"
                         disabled="true">
            </form:select>

        </th>
    </tr>
    </tbody>
    <tbody>
    <tr>

        <td> SỐ LƯỢNG:</td>
        <th><form:input path="soLuong" id="sl" type="number"></form:input></th>
    </tr>
    </tbody>


    <tbody>
    <tr>
        <td> ĐƠN GIÁ:</td>
        <th><form:input path="donGia" id="dg" type="number"></form:input></th>
    </tr>
    </tbody>

    <tbody>
    <tr>
        <td> ĐƠN GIÁ Khi GIẢM:</td>
        <th><form:input path="donGiaKhiGiam" id="dg" type="number"></form:input></th>
    </tr>
    </tbody>

    <tbody>
    <tr>
        <td>
                <%--                onclick="return kiemtrathem()"--%>
            <button type="submit" style="float: right" class="btn btn-success" onclick="return kiemtrathem()"
                    id="btt">UPDATE
            </button>
        </td>
        <th></th>
    </tr>
    </tbody>

</table>
</form:form>
</script>
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

