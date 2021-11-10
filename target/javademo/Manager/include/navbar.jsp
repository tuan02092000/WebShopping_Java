<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <ul class="nav navbar-nav">
            <li><a href="http://localhost:8080/WebShopping_war/home">Home</a></li>
            <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#">Product Manger<span class="caret"></span></a>
                <ul class="dropdown-menu">
                    <li><a href="show-product">Show Product</a></li>
                    <li><a href="add-product">Add Product</a></li>
                </ul>
            </li>
            <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#">Brand Manger<span class="caret"></span></a>
                <ul class="dropdown-menu">
                    <li><a href="${pageContext.request.contextPath}/admin/show-brand">Show Brand</a></li>
                    <li><a href="${pageContext.request.contextPath}/admin/add-brand">Add Brand</a></li>
                </ul>
            </li>
            <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#">Category Manger<span class="caret"></span></a>
                <ul class="dropdown-menu">
                    <li><a href="#">Show Category</a></li>
                    <li><a href="#">Add Category</a></li>
                </ul>
            </li>
        </ul>
        <form class="navbar-form navbar-right" action="#">
            <div class="form-group">
                <input type="text" class="form-control" placeholder="Search" name="search">
            </div>
            <button type="submit" class="btn btn-default">Search</button>
        </form>
    </div>
</nav>
