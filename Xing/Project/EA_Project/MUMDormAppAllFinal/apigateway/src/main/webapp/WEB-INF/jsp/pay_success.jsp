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
    </div>
</nav>



<div id="carouselExampleControls" class="carousel slide" data-ride="carousel " >
    <span>Payment ID:${pd.paymentId} || ${message}</span>
    <table align="center">
        <tr>
            <td>Payer Name(ID):</td><td>${pd.payerName}(${pd.payerId})</td>
        </tr>
        <tr>
            <td>Paid Date:</td><td>${pd.payDate}</td>
        </tr>
        <tr>
            <td>Payer Email:</td><td>${pd.payerEmail}</td>
        </tr>
        <tr>
            <td>Shipping Address:</td><td>${pd.shipAddLine1}</td>
        </tr>
        <tr>
            <td></td><td>City:${pd.shipAddCity},State:${pd.shipAddState},Country:${pd.shipAddCountryCode},PostalCode:${pd.shipAddPostalCode}</td>
        </tr>
<%--        <tr>--%>
<%--            <td>Payer ID:</td><td>${pd.payerId}</td>--%>
<%--        </tr>--%>
    </table>
</div>







<!-- Messages -->



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