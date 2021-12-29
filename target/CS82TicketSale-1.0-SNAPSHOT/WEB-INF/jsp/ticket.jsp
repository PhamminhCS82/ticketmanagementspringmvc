<%-- 
    Document   : ticket
    Created on : Dec 19, 2021, 2:15:24 PM
    Author     : LocNe
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:url value="/trip/${trip.id}" var="action"/>
<section class="hero-wrap hero-wrap-2 js-fullheight" style="background-image: url('../resources/images/bg_1.jpg');">
    <div class="overlay"></div>
    <div class="container">
        <div class="row no-gutters slider-text js-fullheight align-items-end justify-content-center">
            <div class="col-md-9 ftco-animate pb-5 text-center">
                <p class="breadcrumbs"><span class="mr-2"><a href="<c:url value="/" />">Trang chủ <i class="fa fa-chevron-right"></i></a></span> <span>Đăng nhập <i class="fa fa-chevron-right"></i></span></p>
                <h1 class="mb-0 bread">Chi tiết</h1>
            </div>
        </div>
    </div>
</section>
<section>
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <ul>
                    <li><b>Chuyến số :</b> <span> ${trip.name}</span></li>
                    <li><b>Điểm đi:</b> <span> ${trip.idroute.start}</span></li>
                    <li><b>Điểm đến:</b> <span> ${trip.idroute.finish}</span></li>
                    <li><b>Ngày/ Giờ khởi hành:</b> <span> ${trip.dateTime}</span></li>
                    <li><b>Gias ve</b> <span> ${trip.price}</span></li>

                    <!--                        <label for="cate">Loại sản phẩm</label>
                    <%--<form:select id="cate" path="idcardetail" class="form-control">--%>
                    <%--<c:forEach items="${seats}" var="cat">--%>
                    <%--<form:option value="${cat.id}">${cat.name}</form:option>--%>
                    <%--</c:forEach>--%>
                    <%--</form:select>--%>
                    -->


                    <a href="<c:url value="/buyform" />">Mua vé</a>
                </ul>

            </div>
        </div>
    </div>
</section>
  
 <div class=" mt-5 mb-5">
        <div class="d-flex justify-content-center row">
            <div class="d-flex flex-column col-md-11">

                <div class="coment-bottom bg-white p-2 px-4 mt-3">
                    <div class="d-flex flex-row add-comment-section mt-4 mb-4"><img class="img-fluid img-responsive rounded-circle mr-2" src="" width="38">
                        <input type="text" class="form-control mr-3" id ="commentId" placeholder="Thêm bình luận">
                        <c:if test="${pageContext.request.userPrincipal.name == null}">
                            <div ><a href="<c:url value="/singin"/>"></a></div>
                            <button class="btn btn-success" onClick="show_alert()" 
                                type="button">Thêm</button>
                        </c:if>
                              <c:if test="${pageContext.request.userPrincipal.name != null}">
                              
                             <button class="btn btn-success" onClick="addComment(${trip.id})" 
                                type="button">Thêm</button>
                        </c:if>
                       
                    </div>
                    <br>

                    <h4> Tất cả bình luận đánh giá</h4>               
                    <div id ="commentArea">
                        <c:forEach items="${comments}" var="c">

                            <div class="commented-section mt-4"class="d-flex flex-row add-comment-section mt-4 mb-4"><img class=" avatar img-fluid img-responsive rounded-circle mr-2" src="${c.user.avatar}" width="45">
                                <div class="d-flex flex-row align-items-center commented-user mt-3">
                                    <span class="dot mb-3">${c.user.username}</span>
                                    <i class=" mb-3 ml-4">${c.createddate}</i>
                                </div>
                                <div class="comment-text-sm"><span>${c.detail}</span></div>                  
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </div> 
   <script>
            window.onload = function () {
                let dates = document.querySelectorAll(".my-date > i");
                for (let i = 0; i < dates.length; i++) {
                    let d = dates[i];
                    d.innerText = moment(d.innerText).fromNow();
                }
            };

        </script>

             <script src="../resources/js/main.js"></script>
             

