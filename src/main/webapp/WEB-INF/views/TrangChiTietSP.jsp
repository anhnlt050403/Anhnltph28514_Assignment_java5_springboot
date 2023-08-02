<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <title></title>


    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>
    <!--  -->
    <script src="xemchitiet.js"></script>
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
        a {

            text-decoration:none;
        }
        .thanh1>a {
            margin: 19px;
            font-size: 18px;
            color: rgb(118, 113, 113);
            text-decoration:none;
        }

        .thanh1>a:hover {
            color: rgb(0, 0, 0);
            /* text-decoration:none;  */
            box-sizing: border-box;
            text-decoration:none;

        }
        .btmuangay>a {
            margin: 19px;
            font-size: 18px;
            color: rgb(255, 255, 255);

        }

        .btmuangay>a:hover {
            color: rgb(255, 255, 255);
            text-decoration:none;
            box-sizing: border-box;

        }
        .dssp>a {

            color: #000;
            text-decoration:none;
        }

        .dssp>a:hover {

            text-decoration: none;

            color: #000;
        }
    </style>
</head>
<body   ng-app="web207" ng-controller="web207-ctrl">


<form action="/home/dat-hang" style="float: right" method="post">
    <button class="btn btn-success" type="submit">ĐẶT HÀNG</button>
</form>



<div class="nav" style="background-color: white; text-align: center" >
    <nav class="nav__link" style="background-color: white">
        <ul class="nav__list">
            <li>
                <a href="hien-thi" class="btn btn-success">Trang chủ</a>
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
                        Thông tin Giỏ hàng
                    </a>

                    <ul class="dropdown-menu" aria-labelledby="dropdownMenuLink2">
                        <li><a class="dropdown-item" href="/gio-hang/hien-thi">Gio hang</a></li>
                        <li><a class="dropdown-item" href="/gio-hang-chi-tiet/hien-thi">  Chi tiet gio hàng</a></li>


                    </ul>
                </div>
            </li>
            <li>

                <a href="/khach-hang/hien-thi" class="btn btn-success">Khách hàng</a>
            </li>

            <li>
                <div class="dropdown">
                    <a class="btn btn-success" role="button" id="dropdownMenuLink4" data-bs-toggle="dropdown"
                       aria-expanded="false">
                        Thông tin hóa đơn
                    </a>

                    <ul class="dropdown-menu" aria-labelledby="dropdownMenuLink2">
                        <li><a class="dropdown-item" href="/hoa-don/hien-thi">Hóa đơn</a></li>
                        <li><a class="dropdown-item" href="/hoa-don-chi-tiet/hien-thi">  Chi tiet hóa đơn</a></li>


                    </ul>
                </div>
            </li>
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
        </ul>

    </nav>
</div>
<br>


<br>

<!-- thân -->

<div style="width: 80%;margin-left: 10%;height: 32cm;border: 2px solid rgb(255, 255, 255)"       >
    <div style="text-align:center ;margin-top: 0.5cm;">  <p>  ${dulieu.sanPham.ten}</p></div>

    <div style="float: right; width: 40%;border: 2px solid rgb(255, 255, 255);">
        <p style="   font-size: 25px;color:  #4c4c4c;">${dulieu.sanPham.ten}</p>
        <p>Mã: ${dulieu.sanPham.ma}-${dulieu.id}</p>
        <p style="font-size: 30px;color:  #ff0000;">${dulieu.giaBan} VND</p>

        <div style="font-size: 20px;">
        </div>
        <br><br>
        <p>CÒN HÀNG:  ${dulieu.soLuongTon}</p>
        <br>

        <br>
        <form action="/home/gio-hang" method="post">
            <input name="idctsp"  value="${dulieu.id}" style="display: none">
        <button  class="btmuangay"style="width: 100%;height: 1.5cm; border-radius: 5px;font-size: 25px;color: white; text-align: center;background: #00FF00hm;">
           MUA NGAY
<%--                <p style=" font-size: 10px;color: white;">Miễn phí giao hàng tận nhà hoặc của hàng</p>  <br>--%>
        </button>
        </form>
        <br><br>

    </div>


    <div style="float: right; width: 46%;margin-right: 1%;border: 2px solid rgb(167, 164, 164);border-radius: 5px;height: 18cm;">
        <a href="">  <img src= "https://tse1.mm.bing.net/th?id=OIP.M5MFrqD-6tQ9xCdzOEOQUwHaHa&pid=Api&P=0&h=180" alt="" style="width: 100%;height: 100%;"></a>
    </div>


<div>

</div>
</body>
</html>