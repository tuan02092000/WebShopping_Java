<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="include/header.jsp"></jsp:include>
<div class="container">
    <jsp:include page="include/navbar.jsp"></jsp:include>
    <div class="panel panel-primary">
        <div class="panel-heading text-center"><h3>Edit Brand</h3></div>
        <div class="panel-body">
            <form action="edit-brand" method="post">
                <input type="hidden" class="form-control" value="${brand.id}" name="pid">
                <div class="form-group">
                    <label for="name">Name:</label>
                    <input type="text" class="form-control" value="${brand.name}" id="name" placeholder="Enter name brand" name="name">
                </div>
                <button type="submit" class="btn btn-default btn-primary form-control">Edit Product</button>
            </form>
        </div>
    </div>
    <jsp:include page="include/footer.jsp"></jsp:include>
