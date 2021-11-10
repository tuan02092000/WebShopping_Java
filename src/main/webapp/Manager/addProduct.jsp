<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="include/header.jsp"></jsp:include>
<div class="container">
    <jsp:include page="include/navbar.jsp"></jsp:include>
    <div class="panel panel-primary">
        <div class="panel-heading text-center"><h3>Add Product</h3></div>
        <div class="panel-body">
            <form action="add-product" method="post">
                <%
                    String msg = request.getParameter("msg");
                    if("success".equals(msg)){
                %>
                    <h4 style="color: green;">Insert Product Successfully!</h4>
                <%
                    }else if("fail".equals(msg)){
                %>
                    <h4 style="color: red;">Insert Product Fail!</h4>
                <%
                    }
                %>
                <div class="form-group">
                    <label for="name">Name:</label>
                    <input type="text" class="form-control" id="name" placeholder="Enter name product" name="name">
                </div>
                <div class="form-group">
                    <label for="price">Price:</label>
                    <input type="number" class="form-control" id="price" placeholder="Enter price" name="price">
                </div>
                <div class="form-group">
                    <label for="image">Image:</label>
                    <input type="text" class="form-control" id="image" placeholder="Enter link image" name="image">
                </div>
                <div class="form-group">
                    <label for="brand">Brand:</label>
                    <select class="form-control" name="brand" id="brand">
                        <c:forEach items="${listBrand}" var="listB">
                            <option value="${listB.id}">${listB.name}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label for="brand">Category:</label>
                    <select class="form-control" name="category" id="category">
                        <c:forEach items="${listCategory}" var="listC">
                            <option value="${listC.id}">${listC.name}</option>
                        </c:forEach>
                    </select>
                </div>
                <button type="submit" class="btn btn-default btn-primary form-control">Add Product</button>
            </form>
        </div>
    </div>
<jsp:include page="include/footer.jsp"></jsp:include>
