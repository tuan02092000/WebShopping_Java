<%@ page import="com.tuannv.DAO.Impl.BrandDAO" %>
<%@ page import="com.tuannv.Model.BrandModel" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="include/header.jsp"></jsp:include>
<div class="container">
    <div class="row">
        <jsp:include page="include/navbar.jsp"></jsp:include>
        <div class="panel panel-primary">
            <div class="panel-heading text-center"><h3>Show Product</h3></div>
            <div class="panel-body">
                <%
                    String msg = request.getParameter("msg");
                    if("success".equals(msg)){
                %>
                <h4 style="color: green;">Edit Product Successfully!</h4>
                <%
                }else if("fail".equals(msg)){
                %>
                <h4 style="color: red;">Edit Product Fail!</h4>
                <%
                }else if("deleteSuccess".equals(msg)){
                %>
                <h4 style="color: green;">Delete Product Success!</h4>
                <%
                }
                %>
                <table class="table table-bordered text-center">
                    <thead>
                    <tr>
                        <th class="text-center">Name</th>
                        <th class="text-center">Image</th>
                        <th class="text-center">Price</th>
                        <th class="text-center">Brand</th>
                        <th class="text-center">Category</th>
                        <th></th>
                        <th></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${listProduct}" var="list">
                        <tr>
                            <td>${list.name}</td>
                            <td><img style="width: 150px; height: 150px;" src="${list.image}" alt=""></td>
                            <td>${list.price}</td>
                            <td>${list.brand.name}</td>
                            <td>${list.category.name}</td>
                            <td><button class="btn btn-warning"><a style="text-decoration: none; color: white;" href="edit-product?id=${list.id}">Edit</a></button></td>
                            <td><button class="btn btn-danger"><a style="text-decoration: none; color: white;" href="delete-product?id=${list.id}" onclick="return confirm('Are you sure you want to delete this item?');">Delete</a></button></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <div class="paging">
                    <ul class="pagination">
                        <c:forEach begin="1" end="${totalPage}" var="index">
                            <li><a href="show-product?index=${index}">${index}</a></li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="include/footer.jsp"></jsp:include>
