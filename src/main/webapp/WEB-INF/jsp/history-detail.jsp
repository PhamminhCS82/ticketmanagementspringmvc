<%-- 
    Document   : history-detail
    Created on : Dec 31, 2021, 2:27:51 AM
    Author     : pminh
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="container mt-3">
    <h2>Chi tiết vé đã mua trong đơn hàng</h2>
    <p>Tìm kiếm theo mã vé hoặc số ghế</p>  
    <input class="form-control" id="myInput" type="text" placeholder="Search..">
    <br>
    <table class="table table-bordered">
        <thead>
            <tr>
                <th>Mã vé</th>
                <th>Giá tiền</th>
                <th>Số ghế</th>
                <th>Chuyến đi</th>
                <th>Tuyến đi</th>
            </tr>
        </thead>
        <tbody id="myTable">
            <c:forEach var="ticket" items="${listOrderDetail}">
                <tr>
                    <td>${ticket.number}</td>
                    <td>${ticket.price}</td>
                    <td>${ticket.seatName}</td>
                    <td>${ticket.tripId.name}</td>
                    <td>${ticket.tripId.idroute.name}</td>
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
