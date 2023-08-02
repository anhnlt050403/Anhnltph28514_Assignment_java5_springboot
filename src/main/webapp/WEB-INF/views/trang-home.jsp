<%--
  Created by IntelliJ IDEA.
  User: PHAM DAC THANG
  Date: 4/4/2023
  Time: 7:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
</head>


<body>


<br><br>


    <div class="nav" style="background-color: white; text-align: center" >
        <nav class="nav__link" style="background-color: white">
            <ul class="nav__list">
                <li>
                    <a href="" class="btn btn-success">Trang chủ</a>
                </li>

                <li>
                    <div class="dropdown">
                        <a class="btn btn-success" role="button" id="dropdownMenuLink" data-bs-toggle="dropdown"
                           aria-expanded="false">
                            Thông tin sản phẩm
                        </a>

                        <ul class="dropdown-menu" aria-labelledby="dropdownMenuLink">
                            <li><a class="dropdown-item" href="/san-pham/hien-thi">Sản phẩm</a></li>
                            <li><a class="dropdown-item" href="/chi-tiet-sp/hien-thi">Chi tiết sản phẩm</a></li>
                            <li><a class="dropdown-item" href="/mau-sac/hien-thi">Màu Sắc</a></li>
                            <li><a class="dropdown-item" href="/NSX/hien-thi">Nhà SX</a></li>
                            <li><a class="dropdown-item" href="/dong-san-pham/hien-thi">Dòng sản PHẨM </a></li>
                        </ul>
                    </div>
                </li>
                <li>
                    <div class="dropdown">
                        <a class="btn btn-success" role="button" id="dropdownMenuLink2" data-bs-toggle="dropdown"
                           aria-expanded="false">
                            Thông tin nhân viên
                        </a>

                        <ul class="dropdown-menu" aria-labelledby="dropdownMenuLink2">
                            <li><a class="dropdown-item" href="/nhan-vien/hien-thi">Nhân viên</a></li>
                            <li><a class="dropdown-item" href="/chuc-vu/hien-thi">Chức vụ</a></li>
                            <li><a class="dropdown-item" href="/cua-hang/hien-thi">Cửa hàng</a></li>

                        </ul>
                    </div>
                </li>
                <li>
                    <div class="dropdown">
                        <a class="btn btn-success" role="button" id="dropdownMenuLink3" data-bs-toggle="dropdown"
                           aria-expanded="false">
                            Thông tin Gio Hang
                        </a>

                        <ul class="dropdown-menu" aria-labelledby="dropdownMenuLink2">
                            <li><a class="dropdown-item" href="/gio-hang/hien-thi">Giỏ hàng</a></li>
                            <li><a class="dropdown-item" href="/gio-hang-chi-tiet/hien-thi">  Chi tiết giỏ hàng</a></li>


                        </ul>
                    </div>
                </li>
                <li>

                    <a href="/khach-hang/hien-thi" class="btn btn-success">Khách hàng</a>
                </li>

                <li>
                    <div class="dropdown">
                        <a class="btn btn-success" role="button" id="dropdownMenuLin4" data-bs-toggle="dropdown"
                           aria-expanded="false">
                            Thông tin hóa đơn
                        </a>

                        <ul class="dropdown-menu" aria-labelledby="dropdownMenuLink2">
                            <li><a class="dropdown-item" href="/hoa-don/hien-thi">Hóa đơn</a></li>
                            <li><a class="dropdown-item" href="/hoa-don-chi-tiet/hien-thi">  Chi tiết hóa đơn</a></li>


                        </ul>
                    </div>
                </li
                <li>
                    <a href="" class="btn btn-success"> <img
                            src="https://th.bing.com/th/id/OIP.y3RmB84XpI6aCj2g8ofr-QHaHa?pid=ImgDet&rs=1 "
                            style="width: 21px;height: 20px; color: white">
                        Lịch sử mua hàng</a>

                </li>
                <li>
                    <a href="/home/gio-hang" class="btn btn-success">
                        <img
                                src="https://cdn.pnj.io/images/image-update/layout/icon-cart-new.svg "><b><sub
                            style="color: rgb(230, 0, 0);font-size:15px ; ">0</sub></b>
                        Giỏ hàng Của tôi
                    </a>
                </li>
<%--                <li>--%>
<%--                    <a href="/ban-hang/hien-thi" class="btn btn-success">Bán hàng</a>--%>
<%--                </li>--%>

            </ul>

        </nav>
    </div>
<br>
<h4 style="text-align: center">THông tin các mặt hàng </h4>

<div class="container px-4 px-lg-5 mt-5">
    <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-6 row-cols-xl-5 justify-content-center">

        <c:forEach items="${dulieu}" var="ht" varStatus="stt">

            <li class="product">
                <div class="product-image"></div>
                <div class="product-name">${ht.sanPham.ten}</div>
                <div class="product-name">Số lượng sp:${ht.soLuongTon}</div>

                <div class="product-price">$${ht.giaBan}</div>

                <div class="product-detail">
                    <form action="/home/xemchitietsanpham" method="post">
                        <input value="${ht.id}"  name="idcthd"  style="display: none">
                        <button  class="btn btn-secondary"  name="ten" id="ten" type="submit"   style="width: 3cm;">Xem chi tiết </button>


                    </form>

                </div>
            </li>

        </c:forEach>
    </div></div>

<style>
    * {
        box-sizing: border-box;
    }

    body {
        margin: 0;
        background-color: #fff;
    }

    .main {
        width: 1200px;
        min-height: 100vh;
        max-width: 100%;
        margin: auto;
        padding-bottom: 20px;
    }

    .nav {
        display: flex;
        align-items: center;
        height: 48px;
        background-color: #333;
    }

    .nav__list {
        display: flex;
        list-style: none;
    }

    .nav__link {
        text-decoration: none;
        color: #fff;
        margin-right: 48px;
    }

    /* Article */
    h1 {
        line-height: 2rem;
    }

    article {
        padding: 0 16px;
        line-height: 1.6rem;
    }

    article img {
        width: 640px;
        max-width: 100%;
        display: block;
        margin: 32px auto;
    }

    .product-list {
        list-style: none;
        margin: 20px 0;
        padding: 0;
        display: flex;
        flex-wrap: wrap;
        justify-content: space-around;
    }

    /* Style cho một sản phẩm */
    .product {
        width: 200px;
        margin: 10px;
        background-color: #fff;
        border: 1px solid #ddd;
        box-shadow: 0px 4px 8px 0px rgba(0, 0, 0, 0.2);
        text-align: center;
    }

    /* Style cho hình sản phẩm */
    .product-image {
        height: 200px;
        background-image: url('https://tse1.mm.bing.net/th?id=OIP.M5MFrqD-6tQ9xCdzOEOQUwHaHa&pid=Api&P=0&h=180');
        background-size: cover;
        background-repeat: no-repeat;
    }

    /* Style cho tên sản phẩm */
    .product-name {
        font-size: 18px;
        margin: 10px 0;
    }

    /* Style cho giá sản phẩm */
    .product-price {
        font-size: 16px;
        color: #999;
        margin-bottom: 20px;
    }
</style>


</body>
</html>
