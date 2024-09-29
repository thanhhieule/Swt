<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Manager Product</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link href="css/ManagerProduct.css" rel="stylesheet" type="text/css"/>
    <style>
        img {
            width: 200px;
            height: 120px;
        }
    </style>
    <script>
        function back() {
            window.location.href = "home";
        }
        function viewChart() {
            window.location.href = "chart";
        }
        function doDelete(id) {
            var c = confirm("Are you sure?");
            if (c) {
                window.location.href = "delete?pid=" + id;
            }
        }
    </script>
</head>
<body>
    <div class="container">
        <div class="table-wrapper">
            <div class="table-title">
                <div class="row">
                    <div class="col-sm-6">
                        <h2>Manage <b>Order</b></h2>
                    </div>
                </div>
            </div>
            <table class="table table-striped table-hover">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>AccountId</th>
                        <th>TotalPrice</th>
                        <th>CreatedDate</th>
                        <th>ShippingId</th>
                        <th>Edit status</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${orders}" var="p">
                        <tr>
                            <td>${p.id}</td>
                            <td>${p.accountId}</td>
                            <td>${p.totalPrice} $</td>
                            <td>${p.createdDate}</td>
                            <td>${p.shippingId}</td>
                            <td>
                                <c:choose>
                                    <c:when test="${orderDetailsNullMap[p.id]}">
                                        <span>Cancel</span>
                                    </c:when>
                                    <c:otherwise>
                                        <a href="editOrder?pid=${p.id}" class="edit" data-toggle="modal">
                                            <i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i>
                                        </a>
                                    </c:otherwise>
                                </c:choose>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <div class="container">
                <!-- Existing content -->
                <button type="button" class="btn btn-primary" onclick="back()">Back to home</button>
                <button type="button" class="btn btn-primary" onclick="viewChart()">View Order Chart</button>
            </div>
        </div>
    </div>
    <script src="js/ManagerProduct.js" type="text/javascript"></script>
</body>
</html>
