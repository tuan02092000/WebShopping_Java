<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="include/header/header.jsp"></jsp:include>
<jsp:include page="include/header/header_top.jsp"></jsp:include>
<jsp:include page="include/header/header_middle.jsp"></jsp:include>
<jsp:include page="include/header/header_bottom.jsp"></jsp:include>
<jsp:include page="include/slider/slider.jsp"></jsp:include>
	<section id="form"><!--form-->
		<div class="container">
			<div class="row">
				<div class="col-sm-4 col-sm-offset-1">
					<div class="login-form"><!--login form-->
						<h2>Login to your account</h2>
						<%
							String msg = request.getParameter("msg");
							if("incorrect".equals(msg)){
						%>
						<h2 style="color: red;">User Name or Password was Incorrect!!!</h2>
						<%
							}
						%>
						<form action="${pageContext.request.contextPath}/login" method="post">
							<input type="text" value="${username}" name="userName" placeholder="Enter User Name" />
							<input type="password" value="${password}" name="password" placeholder="Password" />
							<span>
								<input type="checkbox" class="checkbox" value="1" name="remember">
								Keep me signed in
							</span>
							<button type="submit" class="btn btn-default">Login</button>
						</form>
					</div><!--/login form-->
				</div>
				<div class="col-sm-1">
					<h2 class="or">OR</h2>
				</div>
				<div class="col-sm-4">
					<div class="signup-form"><!--sign up form-->
						<h2>New User Signup!</h2>
						<%
							if("passNotMatch".equals(msg)){
						%>
						<h2 style="color: red;">Password Not Match !!!</h2>
						<%
							}else if("userNameWasExist".equals(msg)){
						%>
						<h2 style="color: red;">User was Exist</h2>
						<%
							}else if("success".equals(msg)){
						%>
						<h2 style="color: green;">Create User Successfully!!!</h2>
						<%
							}else if("invalid".equals(msg)){
						%>
						<h2 style="color: red;">SignUp fail, Something was wrong!!!</h2>
						<%
							}
						%>
						<form action="signup" method="post">
							<input type="text" name="userName" placeholder="Enter User Name"/>
							<input type="password" name="password" placeholder="Password"/>
							<input type="password" name="rePassword" placeholder="Password Again"/>
							<input type="email" name="email" placeholder="Email Address"/>
							<button type="submit" class="btn btn-default">Signup</button>
						</form>
					</div><!--/sign up form-->
				</div>
			</div>
		</div>
	</section><!--/form-->
<jsp:include page="include/footer/footer.jsp"></jsp:include>