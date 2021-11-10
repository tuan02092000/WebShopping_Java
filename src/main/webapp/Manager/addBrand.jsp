<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="include/header.jsp"></jsp:include>
<div class="container">
    <jsp:include page="include/navbar.jsp"></jsp:include>
    <div class="panel panel-primary">
        <div class="panel-heading text-center"><h3>Add Brand</h3></div>
        <div class="panel-body">
            <form action="add-brand" method="post">
                <%
                    String msg = request.getParameter("msg");
                    if("success".equals(msg)){
                %>
                <h4 style="color: green;">Insert Brand Successfully!</h4>
                <%
                }else if("fail".equals(msg)){
                %>
                <h4 style="color: red;">Insert Brand Fail!</h4>
                <%
                    }
                %>
                <div class="form-group">
                    <label for="name">Name:</label>
                    <input type="text" class="form-control" id="name" placeholder="Enter name brand" name="name">
                </div>
                <button type="submit" class="btn btn-default btn-primary form-control">Add Brand</button>
            </form>
        </div>
    </div>
    <jsp:include page="include/footer.jsp"></jsp:include>
