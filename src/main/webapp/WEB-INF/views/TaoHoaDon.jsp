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

    <style type="text/css">
        /* Căn giữa nội dung trong các thẻ div */
        .wrapper {
            /*display: flex;*/
            /*justify-content: center;*/
            /*align-items: center;*/
            /*height: 100vh;*/
            float: right;
        }

        .overlay {
            /* Hiển thị giao diện mới lên phía trên giao diện gốc */
            position: absolute;
            top: 0;
            left: 0;
            z-index: 9999;

            /* Tạo hiệu ứng mờ nền */
            background-color: rgba(0, 0, 0, 0.5);
            width: 100%;
            height: 100%;
            opacity: 0;
            visibility: hidden;
            transition: opacity 0.3s ease-in-out, visibility 0s linear 0.3s;

            /* Căn giữa nội dung trong giao diện mới */
            display: flex;
            justify-content: center;
            align-items: center;
        }

        /* Hiển thị nội dung trong giao diện mới */
        .overlay.active {
            opacity: 1;
            visibility: visible;
            transition: opacity 0.3s ease-in-out, visibility 0s linear 0s;
        }

        .overlay .overlay-content {
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            text-align: center;
            position: relative;
        }

        .overlay #close-overlay {
            position: absolute;
            top: 10px;
            right: 10px;
            cursor: pointer;
        }


        .black-btn {
            opacity: 0.5; /* giảm độ trong suốt của phần tử */
            pointer-events: none;

        }
    </style>
</head>
<body>

<form action="/home/hien-thi" style="float: right">
    <button class="btn btn-success" type="submit">TRANG CHU</button>
</form>


<P STYLE="text-align: center;font-size: 50px">BÁN HÀNG</P>
<br>
<P>Danh sách sản phẩm hóa dơn : ${mhd.ma} -Tình trạng :${mhd.tinhTrang()} </P>
<BR><BR>

<div class="wrapper">
    <%--    <h1>Giao diện gốc</h1>--%>
    <br>
    <button id="open-overlay" class="btn btn-success">THÊM SẢN PHẨM</button>
</div>

<form action="/ban-hang/thanh-toan" method="post">
    <div style="float:left">
        KHÁCH HÀNG:<br>

        <input type="radio" name="chonkhach" value="co"  ${chonkhach=="co" ?"checked":""}>:
        <select name="dskhachhang"  style="width: 8cm" >
            <c:forEach items="${khachHang}" var="ht">
                <option  value="${ht.id}">${ht.ma}-${ht.ho} ${ht.tenDem} ${ht.ten}</option>
            </c:forEach>

        </select> <br>
        <input type="radio" name="chonkhach" value="ko" checked  ${chonkhach=="ko" ?"checked":""}>KHÁCH BÁN LẺ

    </div>

    <div style="float:left;margin-left: 2cm">
        NHÂN VIÊN  : <br><select name="dsnhanvien"  style="width: 8cm" >
        <c:forEach items="${nhanVien}" var="ht">
            <option  value="${ht.id}">${ht.ma}-${ht.ho} ${ht.tenDem} ${ht.ten}</option>
        </c:forEach>

    </select>
    </div>

    <input value="${mhd.id}" name="idhdtt" style="display: none"><br>
    <button style="float: left; margin-left: 3cm" class="btn btn-success" type="submit">THANH TOÁN</button>

</form>
<br><br><br>
<table class="table" style="background-color:#00FF00">
    <thead>
    <tr>
<%--        <th scope="col">STT</th>--%>
        <th scope="col">MA HOA DON</th>
        <th scope="col">SAN PHAM CHI TIET</th>
        <th scope="col">DON GIA</th>
        <th scope="col">SỐ LƯỢNG</th>

        <th scope="col">TỔNG TIỀN</th>


        <th scope="col">UPDATE</th>
        <th scope="col">DELETE</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${dulieuhdct}" var="ht" varStatus="stt">

        <tr>

            <th>${ht.id.hoaDon.ma} </th>
            <th>${ht.id.chiTietSP.sanPham.ma},${ht.id.chiTietSP.sanPham.ten},${ht.id.chiTietSP.nhaSanXuat.ten},${ht.id.chiTietSP.mauSac.ten},${ht.id.chiTietSP.dongSanPham.ten},${ht.id.chiTietSP.namBaoHanh},${ht.id.chiTietSP.moTa},</th>
            <td>${ht.donGia} VND</td>
            <form action="/ban-hang/updatectsp" method="post">
                <th><input type="number" value="${ht.soLuong}" name="sdcd"></th>

                <td>${ht.donGia*ht.soLuong} VND</td>

                <td>
                        <%--                <a href="/ban-hang/removectsp/${ht.id.idHoadon.id}/${ht.id.idChiTietSP.id}"--%>
                        <%--                   onclick="return myFunction1()" class="btn btn-success">DELETE</a>--%>
                        <%--                --%>


                    <input type="text" value="${ht.id.hoaDon.id}" name="idhd" style="display: none">
                    <input type="text" value="${ht.id.chiTietSP.id}" name="idctsp" style="display: none">
                        <%--                    <input type="text"  va  value="" name="sdcd" style="display: none">--%>
                    <button class="btn btn-success" type="submit" onclick="myFunction()"> UPDATE</button>

            </form>
            </td>

            <td>
                    <%--                <a href="/hoa-don-chi-tiet/view-update/${ht.id.idHoadon.id}/${ht.id.idChiTietSP.id}"--%>
                    <%--                   onclick="return myFunction3()" class="btn btn-success">UPDATE</a>--%>

                <form action="/ban-hang/removectsp" method="post">
                    <input type="text" value="${ht.id.hoaDon.id}" name="idhd" style="display: none">
                    <input type="text" value="${ht.id.chiTietSP.id}" name="idctsp" style="display: none">
                    <button class="btn btn-success" type="submit"> DELETE</button>

                </form>

            </td>

        </tr>

    </c:forEach>
    </tbody>
</table>


<br>
<P style="color: crimson;font-size: 25px;float: right;margin-right: 5cm">TỔNG TIỀN: ${tongTien} VND</P>
<%--<nav aria-label="Page navigation example">--%>
<%--    <ul class="pagination justify-content-center pagination-lg">--%>
<%--        <li class="page-item"><a class="page-link" href="/hoa-don-chi-tiet/hien-thi?pageNum=0">First</a></li>--%>

<%--        <c:forEach begin="1" end="${total}" varStatus="status">--%>
<%--            <li class="page-item">--%>
<%--                <a href="${pageContext.request.contextPath}/hoa-don-chi-tiet/hien-thi?pageNum=${status.index -1}"--%>
<%--                   class="page-link">${status.index}</a>--%>
<%--            </li>--%>
<%--        </c:forEach>--%>

<%--        <li class="page-item"><a class="page-link" href="/hoa-don-chi-tiet/hien-thi?pageNum=${total-1}">Last</a></li>--%>
<%--    </ul>--%>
<%--</nav>--%>


<!-- Giao diện mới -->
<div class="overlay">
    <div class="overlay-content">
        <button id="close-overlay">X</button>

        <table class="table table-bordered border-primary">
            <thead>
            <tr>
                <th scope="col">ID</th>
                <th scope="col">TEN SP</th>
                <th scope="col">NHA SAN XUAT</th>
                <th scope="col">MAU SAC</th>
                <th scope="col">DONG SAN PHAM</th>
                <th scope="col">NAM BAO HANH</th>
                <th scope="col">MO TA</th>
                <th scope="col">SO LUONG</th>
                <th scope="col">GIA NHAP</th>
                <th scope="col">GIA BAN</th>

                <th scope="col">SỐ LƯỢNG MUA</th>
                <th scope="col">CHỨC NĂNG</th>

            </tr>
            </thead>
            <tbody>
            <c:forEach items="${dulieuctsp}" var="ht" varStatus="stt">
                <tr>
                    <td>${stt.index}</td>
                    <th>${ht.sanPham.ten}</th>
                    <td>${ht.nhaSanXuat.ten}</td>
                    <th>${ht.mauSac.ten}</th>
                    <td>${ht.dongSanPham.ten}</td>
                    <td>${ht.namBaoHanh}</td>
                    <th>${ht.moTa}</th>
                        <%--                ${ht.cns(ht.ngaySinh)}--%>
                    <th>${ht.soLuongTon}</th>
                    <td>${ht.giaNhap}</td>
                    <th>${ht.giaBan}</th>

                    <form action="/ban-hang/themspgh" method="post">
                        <td><input type="number" value=""  name="slmua"></td>
                        <td>
                                <%--                        <a href="/ban-hang/themspgh"--%>
                                <%--                           class="btn btn-success">THÊM VÀO GIỎ HÀNG</a>--%>


                            <input type="text" value="${idhd}" name="idhd" style="display: none">
                            <input type="text" value="${ht.id}" name="idctsp" style="display: none">
                                <%--                            <input type="text"  value="" name="slmua" style="display: none">--%>
                            <input type="text" value="${ht.giaBan}" name="donGia" style="display: none">
                            <button class="btn btn-success" type="submit" onclick="myFunction1()"> THÊM VÀO GIỎ HÀNG
                            </button>
                                <%--                         alo cái myfuntion1 khai --%>

                    </form>

                    </td>

                </tr>
            </c:forEach>
            </tbody>
        </table>


    </div>
</div>

<%--<button onclick="changeColor()">Change Color</button>--%>
<!-- Giao diện mới -->
<div class="overlay">
    <div class="overlay-content">
        <button id="close-overlay">X</button>
        <h2>Giao diện mới</h2>
        <p>Nội dung của giao diện mới</p>
        <table class="table table-bordered border-primary">
            <thead>
            <tr>
                <th scope="col">ID</th>
                <th scope="col">TEN SP</th>
                <th scope="col">NHA SAN XUAT</th>
                <th scope="col">MAU SAC</th>
                <th scope="col">DONG SAN PHAM</th>
                <th scope="col">NAM BAO HANH</th>
                <th scope="col">MO TA</th>
                <th scope="col">SO LUONG</th>
                <th scope="col">GIA NHAP</th>
                <th scope="col">GIA BAN</th>

                <th scope="col">SỐ LƯỢNG MUA</th>
                <th scope="col">CHỨC NĂNG</th>

            </tr>
            </thead>
            <tbody>
            <c:forEach items="${dulieuctsp}" var="ht" varStatus="stt">
                <tr>
                    <td>${stt.index}</td>
                    <th>${ht.sanPham.ten}</th>
                    <td>${ht.nhaSanXuat.ten}</td>
                    <th>${ht.mauSac.ten}</th>
                    <td>${ht.dongSanPham.ten}</td>
                    <td>${ht.namBaoHanh}</td>
                    <th>${ht.moTa}</th>
                        <%--                ${ht.cns(ht.ngaySinh)}--%>
                    <th>${ht.soLuongTon}</th>
                    <td>${ht.giaNhap}</td>
                    <th>${ht.giaBan}</th>

                    <form action="/ban-hang/themspgh" method="post">
                        <td><input type="number" value="" id="onhap" name="slmua"></td>
                        <td>
                                <%--                        <a href="/ban-hang/themspgh"--%>
                                <%--                           class="btn btn-success">THÊM VÀO GIỎ HÀNG</a>--%>


                            <input type="text" value="${idhd}" name="idhd" style="display: none">
                            <input type="text" value="${ht.id}" name="idctsp" style="display: none">
                                <%--                            <input type="text"  value="" name="slmua" style="display: none">--%>
                            <input type="text" value="${ht.giaBan}" name="dongia" style="display: none">
                            <button class="btn btn-success" type="submit" onclick="myFunction1()"> THÊM VÀO GIỎ HÀNG
                            </button>
                                <%--                         alo cái myfuntion1 khai --%>

                    </form>

                    </td>

                </tr>
            </c:forEach>
            </tbody>
        </table>


    </div>
</div>

<%--<button onclick="changeColor()">Change Color</button>--%>


<script>
    const openOverlayButton = document.getElementById("open-overlay");
    const closeOverlayButton = document.getElementById("close-overlay");
    const overlay = document.querySelector(".overlay");

    // Khi nhấn nút mở giao diện mới
    openOverlayButton.addEventListener("click", function () {
        overlay.classList.add("active");
    });

    // Khi nhấn nút đóng giao diện mới hoặc click vào vùng mờ xung quanh giao diện mới
    closeOverlayButton.addEventListener("click", function () {
        overlay.classList.remove("active");
    });
    // ảo chưa h
    overlay.addEventListener("click", function (event) {
        if (event.target === this) {
            overlay.classList.remove("active");
        }
    });

</script>


<script>
    var tt =${mhd.tinhTrang};
    if (tt != 0) {
        var buttons = document.getElementsByTagName('button');
        for (var i = 0; i < buttons.length; i++) {
            buttons[i].classList.add('black-btn');
        }
    }

    // thừa của giao diện cũ. chưa
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