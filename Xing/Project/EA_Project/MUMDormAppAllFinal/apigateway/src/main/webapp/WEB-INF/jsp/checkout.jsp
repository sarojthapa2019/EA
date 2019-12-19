<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Checkout</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">


    <script src="https://code.jquery.com/jquery-3.2.1.min.js" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
            crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>


    <link rel="stylesheet" href="../../resources/css/home.css"/>
    <link rel="stylesheet" href="../../resources/css/style.css"/>

</head>
<body class="bg-light">
<nav class="navbar navbar-light bg-dark justify-content-between">
    <a class="navbar-brand" href="/">CHECK OUT</a>
    <div class="" id="smallbar">
        <form class="form-inline my-2 my-lg-0 mr-auto ${username != null ? "dnone" : null}">
            <a data-toggle="modal" data-target="#cart-modal" class="btn btn-success my-2 my-sm-0 btn-sm">
                <i class="fas fa-shopping-cart"></i> Cart (${itemSize > 0 ? itemSize : 0})
            </a> &nbsp;
            <a href="/users/signup" class="btn btn-success my-2 my-sm-0 btn-sm">
                <i class="fas fa-sign-in-alt"></i> Signup
            </a> &nbsp;

            <!-- place holder for login data-toggle="modal" data-target="#login-modal"-->
            <a href="/users/signin" class="btn btn-outline-success my-2 my-sm-0 btn-sm">
                <i class="fas fa-user-circle"></i> Login
            </a> &nbsp;
        </form>

        <form class="form-inline my-2 my-lg-0 mr-auto ${username == null ? "dnone" : null}">

            <a class="btn btn-success my-2 my-sm-0 btn-sm" href="/users/logout"><i class="fas fa-sign-out-alt"></i> Logout</a>
        </form>
    </div>
</nav>



    <!-- Loader -->
    <div id="loader">
        <div id="central">
            <i class="fas fa-sync-alt"></i>
        </div>
    </div>



    <!-- Creating checkout-->

    <div class="container">
        <table id="cart" class="table table-hover table-condensed">
            <thead>
            <tr>
                <th style="width:50%">Product</th>
                <th style="width:10%">Price</th>
                <th style="width:8%">Quantity</th>
                <th style="width:22%" class="text-center">Subtotal</th>
                <th style="width:10%"></th>
            </tr>
            </thead>
            <tbody>

            <c:forEach items="${carts}" var="item">
                <tr>
                    <td data-th="Product">
                        <div class="row">

<%--                            <div class="col-sm-2 hidden-xs"><img src="../../resources/img/${item.getImage()}" alt="${item.image}"--%>
<%--                                                                 class="img-responsive"/></div>--%>
                            <div class="col-sm-10">
                                <h4 class="nomargin"><c:out value="${item.getProductName()}"/></h4>
                            </div>
                        </div>
                    </td>
                    <td data-th="Price"><c:out value="${item.getRate()}"/></td>
                    <td data-th="Quantity">
                        <c:out value="${item.getQuantity()}"/>
                    </td>
                    <td data-th="Subtotal" class="text-center"><c:out
                            value="${item.getPrice()* item.getQuantity()}"/></td>
                    <td class="actions" data-th="">
                            <%--<button class="btn btn-danger btn-sm"><i class="fa fa-trash-o"></i></button>--%>
                        <a href="/cart/remove/${item.getId()}">
                            <button type="button" class="btn btn-danger">Remove</button>
                        </a>
                    </td>
                </tr>
            </c:forEach>

            </tbody>
            <tfoot>

            <tr>
                <c:set var="total" value="${0}"/>
                <c:forEach items="${carts}" var="item">
                    <td colspan="2" class="hidden-xs"></td>
                    <td class="hidden-xs text-center"><c:set var="total" value="${total + item.getPrice()}"/><%--${total}--%>
                    </td>
                </c:forEach>
                <td colspan="2" class="hidden-xs"></td>
              <td class="hidden-xs text-center"><strong>Total</strong> <c:out value = "${total}"></c:out></td>
                <td>
                    <a href="/payment/pay" class="btn btn-success btn-block">Checkout <i class="fa fa-angle-right"></i></a>
                </td>
            </tr>
            </tfoot>
        </table>
        <!-- End of checkout-->

        <!--Bottom Footer-->
        <footer class="bottom section-padding">
            <div class="container">
                <div class="row">
                    <div class="col-md-12 text-center">
                        <div class="copyright">
                            <p>&copy <span>2019</span> <a href="#" class="transition">ONLINE STORE</a> All rights
                                reserved.</p>
                        </div>
                    </div>
                </div>
            </div>
        </footer>
        <!--Bottom Footer-->

</body>

</html>