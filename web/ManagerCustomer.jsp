<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Manager Product</title>
        
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
       
        <link href="css/ManagerProduct.css" rel="stylesheet" type="text/css"/>
        <link
            href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css"
            rel="stylesheet"
            />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/styles.css" rel="stylesheet" />
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
        </script>
    </head>
    <body>
        <div class="container">
            <div class="table-wrapper">
                <div class="table-title">
                    <div class="row">
                        <h2>Manage <b>Account</b></h2>   
                    </div>
                </div>
                <table class="table table-striped table-hover">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>User</th>
                            <th>Pass</th>
                            <th>Active</th>
                            <th>First Name</th>
                            <th>Last Name</th>
                            <th>Address</th>
                            <th>Phone</th>
                            <th>Edit</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${accounts}" var="account">
                            <tr>
                                <td>${account.uid}</td>
                                <td>${account.user}</td>
                                <td>${account.pass}</td>
                                <td>
                                    <c:choose>
                                        <c:when test="${account.active}">
                                            <i class="bi bi-toggle-on"></i>
                                        </c:when>    
                                        <c:otherwise>
                                            <i class="bi bi-toggle2-off"></i>
                                        </c:otherwise>
                                    </c:choose>
                                            
                                   

                                </td>
                                <td>${account.firstName}</td>
                                <td>${account.lastName}</td>
                                <td>${account.address}</td>
                                <td>${account.phone}</td>
                                <td>
                                    <a href="loadAccount?pid=${account.uid}" class="edit" data-toggle="modal">
                                        <i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i>
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <a href="#">
                <button type="button" class="btn btn-primary" onclick="back()">Back to home</button>
            </a>
        </div>
        <script src="js/ManagerProduct.js" type="text/javascript"></script>
    </body>
</html>
