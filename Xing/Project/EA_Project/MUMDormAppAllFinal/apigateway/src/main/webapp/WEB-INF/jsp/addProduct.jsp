<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Signup</title>
    <link rel="stylesheet" href="../../resources/css/style.css" />
    <%--	<link rel="stylesheet" href="../resource/style/signupStyle.css" />--%>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.min.js" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <script src="https://kit.fontawesome.com/8fd24b2ea7.js"></script>
</head>
<body>

<div class="container bg-light">
    <h1>Add Product</h1>
    <form:form modelAttribute="product" action="/product/" method="post" enctype="multipart/form-data">
        <table>
            <div class="form-group">
                <label class="col-sm-3 control-label">Product Name*</label>
                <div class="col-sm-9">
                    <form:input path="productName" />
                    <form:errors path="productName" />
                </div>

            </div>

            <div class="form-group">
                <label class="col-sm-3 control-label">Category</label>
                <div class="col-sm-9">
                    <form:select path="productCategory">
                        <form:option value="NONE" label="Select"/>
                        <form:options items="${categoryList}"/>
                    </form:select>
                </div>

            </div>

            <div class="form-group">
                <label class="col-sm-3 control-label">Price</label>
                <div class="col-sm-9">
                    <form:input path="price"/>
                    <form:errors path="price"/>
                </div>

            </div>
                <form:hidden path="quantity"/>

            <div class="form-group">
                <label class="col-sm-3 control-label">Details</label>
                <div class="col-sm-9">
                   <form:input path="productDetail"/>
                    <form:errors path="productDetail"/>
                </div>

            </div>
            <tr>
                <td>Image</td>
                    <%--<td><form:input path="image" /></td>
                    <td><form:errors path="image" /></td>--%>

                    <%--<td><input type = "submit" value = "Upload File" /></td>--%>
                <td>Select a file to upload</td>
                <td><form hidden><input type="file" name="file"/></form></td>
<%--                <td><form:hidden path="image" id="img" /></td>--%>
            </tr>


        </table>
        <button type="submit" class="btn btn-outline-success">Add Product</button>
    </form:form>
</div>
</body>

</html>