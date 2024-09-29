<%-- 
    Document   : EditAccount
    Created on : Mar 2, 2022, 9:09:03 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Edit Account</title>
       
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="css/manager.css" rel="stylesheet" type="text/css"/>
        <style>
            body {
                background: linear-gradient(to right, #ff7e5f, #feb47b);
                color: white;
                font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            }
            .container {
                margin-top: 50px;
            }
            .modal-header {
                background-color: #ff6f61;
                color: white;
                border-bottom: 2px solid #e55d4e;
                border-top-left-radius: 15px;
                border-top-right-radius: 15px;
            }
            .modal-title {
                font-weight: bold;
                font-size: 1.5em;
            }
            .close {
                color: white;
                opacity: 0.8;
            }
            .modal-content {
                border-radius: 15px;
                box-shadow: 0px 5px 15px rgba(0, 0, 0, 0.3);
                background: linear-gradient(to bottom right, #ff6f61, #d65c4f);
                color: white;
            }
            .form-group label {
                font-weight: bold;
                font-size: 1.1em;
            }
            .form-control {
                border-radius: 5px;
                border: 1px solid #ced4da;
                transition: border-color 0.3s, box-shadow 0.3s;
                background-color: rgba(255, 255, 255, 0.8);
            }
            .form-control:focus {
                border-color: #ff6f61;
                box-shadow: 0 0 10px rgba(255, 111, 97, 0.5);
            }
            .modal-footer {
                background-color: #f1f1f1;
                border-top: 1px solid #dee2e6;
                padding: 15px;
                display: flex;
                justify-content: space-between;
                border-bottom-left-radius: 15px;
                border-bottom-right-radius: 15px;
            }
            .btn-success {
                background-color: #28a745;
                border: none;
                padding: 10px 20px;
                border-radius: 5px;
                transition: background-color 0.3s, transform 0.3s;
                font-size: 1.1em;
            }
            .btn-success:hover {
                background-color: #218838;
                transform: scale(1.05);
            }
        </style>
    </head>
    <body>
        <div class="container">
            <div id="editEmployeeModal">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <form action="EditAccount" method="post">
                            <div class="modal-header">						
                                <h4 class="modal-title">Edit Account</h4>
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            </div>
                            <div class="modal-body">					
                                <div class="form-group">
                                    <label>ID</label>
                                    <input value="${account.uid}" name="id" type="text" class="form-control" readonly required>
                                </div>
                                <div class="form-group">
                                    <label>User</label>
                                    <input value="${account.user}" name="user" type="text" class="form-control" readonly required>
                                </div>
                                <div class="form-group">
                                    <label>Pass</label>
                                    <input value="${account.pass}" name="pass" type="text" class="form-control"  readonly required>
                                </div>
                                <div class="form-group">
                                    <label>isSell</label>
                                    <input value="${account.isSell}" name="issell" type="text" class="form-control" readonly required>
                                </div>
                                <div class="form-group">
                                    <label>FirstName</label>
                                    <input value="${account.firstName}" name="firstName" type="text" class="form-control" readonly required>
                                </div>
                                <div class="form-group">
                                    <label>LastName</label>
                                    <input value="${account.lastName}" name="lastName" type="text" class="form-control" readonly required>
                                </div>
                                <div class="form-group">
                                    <label>Address</label>
                                    <input value="${account.address}" name="address" type="text" class="form-control" readonly required>
                                </div>
                                <div class="form-group">
                                    <label>Phone</label>
                                    <input value="${account.phone}" name="phone" type="text" class="form-control" readonly required>
                                </div>
                                <div class="form-group">
                                    <label>Active</label>
                                    <input value="${account.active}" name="active" type="text" class="form-control" required>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <input type="submit" class="btn btn-success" value="Edit">
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <script src="js/manager.js" type="text/javascript"></script>
    </body>
</html>
s