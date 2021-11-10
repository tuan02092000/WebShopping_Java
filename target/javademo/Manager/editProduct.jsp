<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="include/header.jsp"></jsp:include>
<div class="container">
    <jsp:include page="include/navbar.jsp"></jsp:include>
    <div class="panel panel-primary">
        <div class="panel-heading text-center"><h3>Edit Product</h3></div>
        <div class="panel-body">
            <form action="edit-product" method="post">
                <input type="hidden" class="form-control" value="${product.id}" name="pid">
                <div class="form-group">
                    <label for="name">Name:</label>
                    <input type="text" class="form-control" value="${product.name}" id="name" placeholder="Enter name product" name="name">
                </div>
                <div class="form-group">
                    <label for="price">Price:</label>
                    <input type="number" class="form-control" value="${product.price}" id="price" placeholder="Enter price" name="price">
                </div>
                <div class="form-group">
                    <label for="image">Image:</label>
                    <input type="text" class="form-control" value="${product.image}" id="image" placeholder="Enter link image" name="image">
                </div>
                <div class="form-group">
                    <label for="brand">Brand:</label>
                    <select class="form-control" name="brand" id="brand">
                        <c:forEach items="${listBrand}" var="listB">
                            <option <c:if test="${listB.id == product.brandId}"> <c:out value="selected"></c:out> </c:if> value="${listB.id}">${listB.name}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label for="brand">Category:</label>
                    <select class="form-control" name="category" id="category">
                        <c:forEach items="${listCategory}" var="listC">
                            <option <c:if test="${listC.id == product.categoryId}"> <c:out value="selected"></c:out> </c:if> value="${listC.id}">${listC.name}</option>
                        </c:forEach>
                    </select>
                </div>
                <button type="submit" class="btn btn-default btn-primary form-control">Edit Product</button>
            </form>
        </div>
    </div>
    <jsp:include page="include/footer.jsp"></jsp:include>
