<%-- 
    Document   : buyticket
    Created on : Dec 21, 2021, 7:50:54 PM
    Author     : pminh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<link rel="stylesheet" type="text/css" href="css/booking.css"/>
<div class="row seatbox">
    <div class="col-3-sm-3">
        <div class="movie-container">
            <label>Số ghế:</label>
            <select id="movie">
                <option value="1">1 vé</option>
                <option value="2">2 vé</option>
                <option value="3">3 vé</option>
                <option value="4">4 vé</option>
            </select>
        </div>

        <ul class="showcase">
            <li>
                <div class="seat"></div>
                <small>Trống</small>
            </li>

            <li>
                <div class="seat selected"></div>
                <small>Đang chọn</small>
            </li>

            <li>
                <div class="seat occupied"></div>
                <small>Đã đặt</small>
            </li>
        </ul>

        <div class="container">
            <div class="row se">

                <c:forEach items="${seatofcar}" var="seat">
                    <c:if test="${seat.emp == 1}">
                        <div id="${seat.id}" data-value="${seat.name}" class="seat">${seat.name}</div>
                    </c:if>
                    <c:if test="${seat.emp == 0}">

                        <!--<div id="${seat.id}" data-value="${seat.name}" class="seat occupied">${seat.name}</div>-->
                    </c:if>


                </c:forEach>
            </div>
        </div>

        <p class="text">
            Đang chọn <span id="count">0</span> ghế, tổng tiền hiện tại $<span id="total">0</span>
        </p>
        <p id="demo">
            Số ghế đã chọn
            <br>
            <span id="selected-seats"></span>


        </p>
    </div>
    <div class="col-3-sm-3 info">
        <h1>Thông tin cá nhân</h1>
        <ul>
            <li><b>Họ và tên:</b> <span> </span></li>
            <li><b>Số điện thoại:</b> <span> </span></li>

        </ul>
        <h1>Thông tin chuyến</h1>
        <ul>
            <li><b>Tên chuyến :</b> <span> ${tripinfo.name}</span></li>
            <li><b>Điểm đi:</b> <span> ${tripinfo.idroute.start}</span></li>
            <li><b>Điểm đến:</b> <span> ${tripinfo.idroute.finish}</span></li>
            <li><b>Ngày/ Giờ khởi hành:</b> <span> ${tripinfo.datetime}</span></li>
            <li><b>Số xe:</b> <span> ${carinfo.carnumber}</span></li>
            <li><b>Giá</b> <span> ${tripinfo.price}</span></li>
            <button type="submit" class="btn btn-primary" name="submit" id="reserveButton" disabled>Đặt vé</button>
        </ul>
    </div>
</div>
<script src="js/booking.js"></script>
