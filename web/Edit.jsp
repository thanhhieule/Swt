
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Crud</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="css/manager.css" rel="stylesheet" type="text/css"/>
        <style>
            img{
                width: 200px;
                height: 120px;
            }
        </style>
    <body>
    <div class="container">
        <div id="editEmployeeModal">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form action="edit" method="post">
                        <div class="modal-header">						
                            <h4 class="modal-title">Edit Product</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        </div>
                        <div class="modal-body">					
                            <div class="form-group">
                                <label>
                                    ID
                                    <input id="productId" value="${product.id}" name="id" type="text" class="form-control" readonly required>
                                </label>
                            </div>
                            <div class="form-group">
                                <label>
                                    Name
                                    <input id="productName" value="${product.name}" name="name" type="text" class="form-control" required>
                                </label>
                            </div>
                            <div class="form-group">
                                <label>
                                    Image
                                    <input id="productImage" value="${product.imageUrl}" name="image" type="text" class="form-control" required>
                                </label>
                            </div>
                            <div class="form-group">
                                <label>
                                    Price
                                    <input id="productPrice" value="${product.price}" name="price" type="text" pattern="^\d+\.*\d*$" title="Please Enter Double Value!" class="form-control" required>
                                </label>
                            </div>
                            <div class="form-group">
                                <label>
                                    Quantity
                                    <input id="productQuantity" value="${product.quantity}" name="quantity" type="text" pattern="^\d+$" title="Please Enter integer Value!" class="form-control" required>
                                </label>
                            </div>
                            <div class="form-group">
                                <label>
                                    Title
                                    <textarea id="productTitle" name="title" class="form-control" required>${product.tiltle}</textarea>
                                </label>
                            </div>
                            <div class="form-group">
                                <label>
                                    Description
                                    <textarea id="productDescription" name="description" class="form-control" required>${product.description}</textarea>
                                </label>
                            </div>
                            <div class="form-group">
                                <label>
                                    Category
                                    <select id="productCategory" name="category" class="form-control" aria-label="Default select example">
                                        <c:forEach items="${listCategories}" var="o">
                                            <option ${(product.categoryId == o.cid)?"selected":""} value="${o.cid}">${o.cname}</option>
                                        </c:forEach>
                                    </select>
                                </label>
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

