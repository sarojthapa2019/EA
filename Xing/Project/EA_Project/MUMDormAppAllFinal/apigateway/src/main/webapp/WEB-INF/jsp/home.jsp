<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Home</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">



    <script src="https://code.jquery.com/jquery-3.2.1.min.js"  crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<%--    <script src="https://kit.fontawesome.com/8fd24b2ea7.js"></script>--%>
<%--    <script src="resource/script/script.js"></script>--%>
<%--    ${user != null ? null : "<script src='resource/script/checkCookies.js'></script>"}--%>
<%--    <script src="resource/script/homeScript.js"></script>--%>

    <link rel="stylesheet" href="../../resources/css/home.css" />
    <link rel="stylesheet" href="../../resources/css/style.css" />

</head>
<body class="bg-light">
<nav class="navbar navbar-light bg-dark justify-content-between">
    <a class="navbar-brand" href="/">Online Store</a>
    <div class="" id="smallbar">
        <form class="form-inline my-2 my-lg-0 mr-auto ${username != null ? "dnone" : null}">
            &nbsp;
            <a href="/users/signup" class="btn btn-success my-2 my-sm-0 btn-sm" >
                <i class="fas fa-sign-in-alt"></i> Signup
            </a> &nbsp;

            <!-- place holder for login data-toggle="modal" data-target="#login-modal"-->
            <a href="/users/signin" class="btn btn-outline-success my-2 my-sm-0 btn-sm" >
                <i class="fas fa-user-circle"></i> Login
            </a> &nbsp;
        </form>



        <form class="form-inline my-2 my-lg-0 mr-auto ${username == null ? "dnone" : null}">

            <a href="/product" class="btn btn-success my-2 my-sm-0 btn-sm" >
                <i class="fas fa-sign-in-alt"></i> Add Product
            </a>

            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <i class="fas fa-user-circle"></i> ${username}
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a data-toggle="modal" data-target="#cart-modal" class="dropdown-item" ><i class="fas fa-shopping-cart"></i> Cart (${itemSize > 0 ? itemSize : 0})</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="/users/logout"><i class="fas fa-sign-out-alt"></i> logout</a>
                </div>
            </li>
        </form>

        <form class="form-inline my-2 my-lg-0 mr-auto ${role == null ? "dnone" : null}">

            <a href="/payment/paymentDetail" class="btn btn-success my-2 my-sm-0 btn-sm" >
                <i class="fas fa-sign-in-alt"></i> View Payment
            </a>
        </form>

    </div>
</nav>



<div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
    <ol class="carousel-indicators">
        <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
        <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
        <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
    </ol>
    <div class="carousel-inner ">
        <div class="carousel-item active">
            <img src="../../resources/img/laptop.jpg" class="d-block w-100" alt="BANNER" class="img-responsive">
        </div>
        <div class="carousel-item">
            <img src="../../resources/img/iPhoneXsMax.jpg" class="d-block w-100" alt="BANNER" class="img-responsive">
        </div>
        <div class="carousel-item">
            <img src="../../resources/img/macbookpro13.jpg" class="d-block w-100" alt="BANNER" class="img-responsive">
        </div>
    </div>
    <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
    </a>
</div>

<!--Main Contents inside container-->

<!-- Page Content -->
<div class="container">

    <div class="row">

        <div class="leftbar col-md-4 col-lg-3">


            <div class="list-group" id="theFixed">
                <a href="/filter/all" data-item="all" class="list-group-item"><i class="fas fa-cubes"></i> All</a>
                <a href="/filter/NB" data-item="notebook" class="list-group-item"><i class="fas fa-laptop"></i> Notebook</a>
                <a href="/filter/SP" data-item="smartphone" class="list-group-item"><i class="fas fa-mobile-alt"></i> Smartphone</a>
                <a href="/filter/AC" data-item="accessories" class="list-group-item"><i class="fas fa-headphones-alt"></i> Accessories</a>
            </div>

        </div>
        <!-- /.col-lg-3 -->

        <div class="col">


            <div class="row my-4 " id="showData">
                <div class="display">
                    <div class="row" id="appendData">
                        <c:forEach var="product" items="${product}">
                            <c:if test="${product.status}">

                            <div class="card custom-card">
                              <a href="/productPage/${product.id}" >
                            <%--                                <a href="/product?id=${data[i].id}">--%>
<%--                                --%>
                                    <img class="card-img-top" src="../../resources/img/${product.image}" alt="${product.productName}"/>
                                </a>
                                <div class="card-body text-truncate">
                                    <h4 class="card-title">
                                        <p><h5>${product.productName}</h5></p>
                                    </h4>
                                    <p><h5>$${product.price}</h5></p>

                                </div>
                                    <div class="section ${username != null ? "dnone":null} ">
                                            <a href="/users/signin">  <button class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span> Add to cart</button></a>
                                    </div>
                                <div class="section ${username == null ? "dnone":null} ">
                                    <a href="/cart/add/${product.id}">  <button class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span> Add to cart</button></a>
                                </div>
                            </div>

                            </c:if>
                        </c:forEach>


                    </div>
                    <div class="row" id="appendData2">
                        <%--Display block here--%>
                    </div>
                </div>
                <!-- /.row -->

            </div>
            <!-- /.col-lg-9 -->

        </div>
        <!-- /.row -->

    </div>
    <!-- /.container -->
</div>
<!--End of Main container-->

<!--Login Modal Content-->
<div class="modal fade" id="login-modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">

    <div class="modal-dialog" role="document">
        <div class="modal-content loginmodal-container">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Login</h5>

            </div>
            <div class="modal-body">
                <form:form action="/users/login" method="post">
                    <input type="email" name="email" placeholder="Email: example@mum.com"/>
                    <input type="password" name="password" placeholder="Password">
                    <div class="dropdown-divider"></div>
                    <input type="submit" name="login" class="login btn btn-success" value="Login">

                </form>
                <div class="login-help">
                    <label>Please click  </label><a href="/users/signup"> Register </a><span> If you dont have an Account.</span>
                </div>
            </div>

        </div>
    </div>
</div>

<!--Cart Modal Content-->
<div class="modal fade" id="cart-modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel1" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered modal-lg">
        <div class="modal-content card-body text-left">
          Cart (${itemSize > 0 ? itemSize : 0})
            <h3><i class="fas fa-shopping-cart"></i> cart here</h3>
            <div class="dropdown-divider"></div>

            <!-- repeat this for each product -->
            <c:forEach items="${carts}" var="item">
                <div id="cartshow" class="row">

                    <div class="col-sm-5">
                        <h6 class="mt-0"><c:out value="${item.getProductName()}" /></h6>
                    </div>
                    <div class="col-sm-4 text-left">
                        <span>Quantity <strong><c:out value="${item.getQuantity()}" /></strong></span>
                    </div> <div class="col-sm-3 text-left">
                       <a href="/cart/remove/${item.getId()}">&Chi;</a>
                    </div>
                </div>
            </c:forEach>

            <div class="my-4 text-center emptyCart ${itemSize > 0 ? "dnone" : null}">
                <h3><i class="far fa-frown fa-lg"></i></h3>
                <h3>Your cart is empty!</h3>
            </div>

            <div class="dropdown-divider"></div>
            <div class="text-right">
                <a href="/checkout" class="btn btn-danger checkoutbtn">Checkout</a>
            </div>
        </div>
    </div>
</div>

<!-- Messages -->

<!-- Loader -->
<div id="loader">
    <div id="central">
        <i class="fas fa-sync-alt"></i>
    </div>
</div>

<!--Bottom Footer-->
<footer class="bottom section-padding">
    <div class="container">
        <div class="row">
            <div class="col-md-12 text-center">
                <div class="copyright">
                    <p>&copy <span>2019</span> <a href="#" class="transition">ONLINE STORE</a> All rights reserved.</p>
                </div>
            </div>
        </div>
    </div>

</footer>
<!--Bottom Footer-->
</body>

</html>