<%-- 
    Document   : order-detail
    Created on : Dec 30, 2021, 8:21:28 PM
    Author     : pminh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h2>Bordered Table</h2>
<p>The .table-bordered class adds borders on all sides of the table and the cells:</p>            
<table class="table table-bordered">

    <tbody>
        <tr>
            <td><b>Mã hóa đơn điện tử</b></td>
            <td><b>Hình thức thanh toán</b></td>
            <td><b>Số tiền</b></td>
            <td><b>Trạng thái</b></td>
        </tr>
        <tr>
            <td>${onlineId}</td>
            <td>Ví điện tử ZaloPay</td>
            <td>${totalPrice}</td>
            <td>${orderResult}</td>
        </tr>
    </tbody>
</table>
