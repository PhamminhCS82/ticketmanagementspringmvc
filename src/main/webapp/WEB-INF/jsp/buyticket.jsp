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
                <option value=${tripinfo.price}>1 ghế</option>
                <option value=${tripinfo.price}>2 ghế</option>
                <option value=${tripinfo.price}>3 ghế</option>
                <option value=${tripinfo.price}>4 ghế</option>
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
                    <c:if test="${seat.blank == true}">
                        <div id="${seat.name}" class="seat">${seat.name}</div>
                    </c:if>
                    <c:if test="${seat.blank == false}">

                        <div id="${seat.name}" class="seat occupied">${seat.name}</div>
                    </c:if>


                </c:forEach>
            </div>
        </div>

        <p class="text">
            Đang chọn <span id="count">0</span> ghế
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
            <li><b>Họ và tên:</b> <span>${user.surname} ${user.firstname} </span></li>
            <li><b>Số điện thoại:</b> <span> ${user.phone}</span></li>
            <li><b>Email:</b> <span> ${user.email}</span></li>

        </ul>
        <h1>Thông tin chuyến</h1>
        <ul>
            <li><b>Tên chuyến :</b> <span> ${tripinfo.name}</span></li>
            <li><b>Điểm đi:</b> <span> ${tripinfo.idroute.start}</span></li>
            <li><b>Điểm đến:</b> <span> ${tripinfo.idroute.finish}</span></li>
            <li><b>Ngày/ Giờ khởi hành:</b> <span> ${tripinfo.dateTime}</span></li>
            <li><b>Số xe:</b> <span> ${carinfo.carnumber}</span></li>
            <li><b>Giá</b> <span> ${tripinfo.price}</span></li>
            <button onclick="pay(${user.id},${carinfo.id}, ${tripinfo.price})" type="submit" class="btn btn-primary" name="submit" id="reserveButton" disabled>Đặt vé</button>
            <!-- Button to Open the Modal -->
            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">
                Open modal
            </button>

            <!-- The Modal -->
            <div class="modal" id="myModal">
                <div class="modal-dialog">
                    <div class="modal-content">

                        <!-- Modal Header -->
                        <div class="modal-header">
                            <h4 class="modal-title">Modal Heading</h4>
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                        </div>

                        <!-- Modal body -->
                        <div class="modal-body">
                            Modal body..
                        </div>

                        <!-- Modal footer -->
                        <div class="modal-footer">
                            <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
                        </div>

                    </div>
                </div>
            </div>
        </ul>
    </div>
</div>
<script src="js/booking.js"></script>
