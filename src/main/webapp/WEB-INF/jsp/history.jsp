<%-- 
    Document   : history
    Created on : Dec 31, 2021, 1:21:20 AM
    Author     : pminh
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="container mt-3">
    <h2>Lịch sử đơn hàng</h2>
    <p>Tìm kiếm</p>
    <input class="form-control" id="myInput" type="text" placeholder="Search..">
    <br>
    <table class="table table-bordered">
        <thead>
            <tr>
                <th>Ngày mua</th>
                <th>Tổng tiền</th>
                <th>Hóa đơn</th>
                <th>Chi tiết</th>
            </tr>
        </thead>
        <tbody id="myTable">
            <c:forEach var="order" items="${listOrder}">
                <tr>
                    <td>${order.createdDate}</td>
                    <td>${order.totalPrice}</td>
                    <c:if test="${order.isPaid == true}">
                    <td>Đã thanh toán</td>
                    </c:if>
                    <c:if test="${order.isPaid == false}">
                    <td>Chưa thanh toán</td>
                    </c:if>
                    <td><a href="<c:url value="/order-history-detail?id=${order.id}"/>">Chi tiết</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    
</div>
<script>
    $(document).ready(function () {
        $("#myInput").on("keyup", function () {
            var value = $(this).val().toLowerCase();
            $("#myTable tr").filter(function () {
                $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
            });
        });
    });
</script>
