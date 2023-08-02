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
            width: 50%;
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
            <form:form action="/NSX/add-NSX" method="post" modelAttribute="nha">
                <table class="table" style="background-color: darkgoldenrod">
                    <tr>

                        <th style="text-align: center"><form:label path="ma">Mã Nhà Sản Xuất</form:label></th>
                        <th style="text-align: center"><form:label path="ten">Tên Nhà Sản Xuất</form:label></th>
                    </tr>
                    <tr>

                        <td style="text-align: center"><form:input path="ma"></form:input></td>
                        <td style="text-align: center"><form:input path="ten"></form:input></td>
                    </tr>
                    <tr>
                        <td style="text-align: center" colspan="2">
                            <button type="submit" class="btn btn-secondary">Thêm Nhà Sản Xuất</button>
                        </td>
                    </tr>
                </table>
            </form:form>
        </div>
        <div class="col-md-6">
            <form action="/NSX/search-NSX" method="post">
                <table class="table" style="background-color: aqua">
                    <tr>
                        <td style="text-align: center">Tìm Kiếm Theo Tên: <input type="text" name="tenTk"
                                                                                 style="text-align: center ;"
                        ></td>
                    </tr>
                    <tr>
                        <td style="text-align: center">
                            <button class="btn btn-secondary">Tìm Nhà Sản Xuất</button>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</div>
<hr>


<h4 style="text-align: center;">Danh Sách Nhà Sản Xuất</h4>
<hr>
<div class="container">
    <table class="table" style="background-color:#00FF00">
        <tr>
            <th>Mã Nhà Sản Xuất</th>
            <th>Tên Nhà Sản Xuất</th>
            <th>Action</th>
        </tr>
        <c:forEach items="${list}" var="nha">
            <tr>
                <td>${nha.ma}</td>
                <td>${nha.ten}</td>
                <td>
                    <a href="/NSX/detail-NSX/${nha.id}" class="btn btn-success "
                       tabindex="-1"
                       role="button"
                       onclick="return checkDetail()">Detail</a>
                    <a href="/NSX/view-update-NSX/${nha.id}" class="btn btn-success "
                       tabindex="-1"
                       role="button"
                       aria-disabled="true" onclick="return checkViewUpdate()">Update</a>
                    <a href="/NSX/remove-NSX/${nha.id}" class="btn btn-success "
                       tabindex="-1"
                       role="button"
                       aria-disabled="true">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <nav aria-label="Page navigation example" style="margin-top: 100px">
        <ul class="pagination justify-content-center pagination-lg">
            <li class="page-item"><a class="page-link" href="/NSX/hien-thi?pageNum=0">First</a></li>
            <c:forEach begin="1" end="${total}" varStatus="status">
                <li class="page-item">
                    <a href="${pageContext.request.contextPath}/NSX/hien-thi?pageNum=${status.index -1}"
                       class="page-link">${status.index}</a>
                </li>
            </c:forEach>
            <li class="page-item"><a class="page-link" href="/NSX/hien-thi?pageNum=${total-1}">Last</a></li>
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
