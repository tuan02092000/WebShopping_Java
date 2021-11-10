<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="header-middle"><!--header-middle-->
    <div class="container">
        <div class="row">
            <div class="col-md-4 clearfix">
                <div class="logo pull-left">
                    <a href="${pageContext.request.contextPath}/home"><img src="images/home/logo.png" alt="" /></a>
                </div>
                <div class="btn-group pull-right clearfix">
                    <div class="btn-group">
                        <button type="button" class="btn btn-default dropdown-toggle usa" data-toggle="dropdown">
                            USA
                            <span class="caret"></span>
                        </button>
                        <ul class="dropdown-menu">
                            <li><a href="">Canada</a></li>
                            <li><a href="">UK</a></li>
                        </ul>
                    </div>

                    <div class="btn-group">
                        <button type="button" class="btn btn-default dropdown-toggle usa" data-toggle="dropdown">
                            DOLLAR
                            <span class="caret"></span>
                        </button>
                        <ul class="dropdown-menu">
                            <li><a href="">Canadian Dollar</a></li>
                            <li><a href="">Pound</a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="col-md-8 clearfix">
                <div class="shop-menu clearfix pull-right">
                    <ul class="nav navbar-nav">
                        <c:if test="${sessionScope.user != null && sessionScope.user.isAdmin != 1}">
                            <li><h4>Hello ${sessionScope.user.userName}</h4></li>
                        </c:if>
                        <c:if test="${sessionScope.user.isAdmin == 1}">
                            <li><h4><a href="show-product">Hello Admin</a></h4></li>
                        </c:if>
                        <c:if test="${sessionScope.user != null && sessionScope.user.isAdmin != 1}">
                            <li><a href=""><i class="fa fa-user"></i> Account</a></li>
                        </c:if>
                        <c:if test="${sessionScope.user.isAdmin == 1}">
                            <li><a href="show-product"><i class="fa fa-user"></i> Manager Product</a></li>
                        </c:if>
                        <li><a href=""><i class="fa fa-star"></i> Wishlist</a></li>
                        <li><a href="checkout.html"><i class="fa fa-crosshairs"></i> Checkout</a></li>
                        <li><a href="cart.html"><i class="fa fa-shopping-cart"></i> Cart</a></li>
                        <c:if test="${sessionScope.user == null}">
                            <li><a href="login.jsp"><i class="fa fa-lock"></i> Login</a></li>
                        </c:if>
                        <c:if test="${sessionScope.user != null}">
                            <li><a href="logout"><i class="fa fa-lock"></i> Logout</a></li>
                        </c:if>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div><!--/header-middle-->