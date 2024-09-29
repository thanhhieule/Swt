

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            img{
                width: 200px;
                height: 120px;
            }
        </style>
        <script>
            function back() {
                window.location.href = "managerOrder";
            }
            function doDelete(id)
            {
                var c = confirm("Are you sure?");
                if (c)
                {
                    window.location.href = "deleteOrderdtails?pid=" + id;
                }
            }
        </script>

    <body>

        <div class="container">
            <div class="table-wrapper">
                <div class="table-title">
                    <div class="row">
                        <div class="col-sm-6">
                            <h2>Manage <b>Shipping</b></h2>
                        </div>
                       
                    </div>
                </div>
                <table class="table table-striped table-hover">
                    <thead>
                        <tr>
                           
                            <th>ID</th>
                            <th>OrderId</th>
                            <th>ProductName</th>
                            <th>ProductImage</th>
                            <th>ProductPrice</th>
                            <th>Quantity</th>
                            <th>status</th>  
                            <th></th>  
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${orderDetails}" var="p">
                            <tr>
                               
                                <td>${p.getId()}</td>
                                <td>${p.getOrderId()}</td>
                                <td>${p.getProductName()}</td>
                                <td>
                                    <img src="${p.getProductImage()}">
                                </td>

                                <td>${p.getProductPrice()}</td>
                                <td>${p.getQuantity()}</td>
                                <td>in shipping</td>>
                                <td>
                                  
                                    <a href="#" class="delete" data-toggle="modal" onclick="doDelete(${p.getId()})"><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                
            </div>
            <a href="#">
                <button type="button" class="btn btn-primary" onclick="back()">Back</button>

        </div>
        <!-- Edit Modal HTML -->
      




        <script src="js/ManagerProduct.js" type="text/javascript"></script>
    </body>
</html>


