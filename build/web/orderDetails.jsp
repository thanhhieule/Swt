<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>STATISTIC</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #e0f7fa;
            color: #006064;
            margin: 0;
            padding: 0;
        }
        h1 {
            background-color: #006064;
            color: white;
            padding: 20px;
            text-align: center;
            margin: 0;
            border-bottom: 5px solid #004d40;
        }
        table {
            width: 80%;
            margin: 20px auto;
            border-collapse: collapse;
            box-shadow: 0 2px 3px rgba(0, 0, 0, 0.2);
        }
        th, td {
            padding: 12px;
            text-align: center;
            border: 1px solid #004d40;
        }
        th {
            background-color: #00acc1;
            color: white;
        }
        tr:nth-child(even) {
            background-color: #b2ebf2;
        }
        tr:nth-child(odd) {
            background-color: #e0f7fa;
        }
        tr:hover {
            background-color: #4dd0e1;
        }
        img {
            border-radius: 5px;
        }
    </style>
</head>
<body>
    <h1>TOP PRODUCTS MOST REVENUE </h1>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Order ID</th>
                <th>Product Name</th>
                <th>Product Image</th>
                <th>Product Price</th>
                <th>Quantity</th>
                <th>Total Price</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="orderDetail" items="${orderDetails}">
                <tr>
                    <td>${orderDetail.id}</td>
                    <td>${orderDetail.orderId}</td>
                    <td>${orderDetail.productName}</td>
                    <td><img src="${orderDetail.productImage}" alt="${orderDetail.productName}" width="50"/></td>
                    <td>${orderDetail.productPrice}</td>
                    <td>${orderDetail.quantity}</td>
                    <td>${orderDetail.quantity * orderDetail.productPrice}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
