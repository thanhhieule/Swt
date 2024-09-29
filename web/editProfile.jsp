<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Profile</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f9f9f9;
            margin: 0;
            padding: 0;
        }
        .container {
            width: 60%;
            margin: 20px auto;
            padding: 20px;
            background: #ffffff;
            border-radius: 10px;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
        }
        h1 {
            color: #007bff;
            text-align: center;
            margin-bottom: 20px;
        }
        .form-group {
            margin-bottom: 15px;
        }
        .form-group label {
            display: block;
            font-weight: bold;
            margin-bottom: 5px;
        }
        .form-group input[type="text"], .form-group input[type="password"] {
            width: 100%;
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 5px;
        }
        .form-group input[readonly] {
            background-color: #f0f4f8;
            cursor: not-allowed;
        }
        .form-group button {
            background-color: #007bff;
            color: white;
            border: none;
            padding: 10px 20px;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
        }
        .form-group button:hover {
            background-color: #0056b3;
        }
        .error {
            color: #dc3545;
            font-size: 1.1em;
            text-align: center;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Edit Profile</h1>
        <c:if test="${account != null}">
            <form action="EditProfileServlet" method="post">
                <div class="form-group">
                    <label for="id">ID:</label>
                    <input type="text" id="id" name="id" value="${account.uid}" readonly />
                </div>
                <div class="form-group">
                    <label for="user">Username:</label>
                    <input type="text" id="user" name="user" value="${account.user}" readonly />
                </div>
                <div class="form-group">
                    <label for="pass">Password:</label>
                    <input type="password" id="pass" name="pass" value="${account.pass}" readonly />
                </div>
                <div class="form-group">
                    <label for="firstName">First Name:</label>
                    <input type="text" id="firstName" name="firstName" value="${account.firstName}" required />
                </div>
                <div class="form-group">
                    <label for="lastName">Last Name:</label>
                    <input type="text" id="lastName" name="lastName" value="${account.lastName}" required />
                </div>
                <div class="form-group">
                    <label for="address">Address:</label>
                    <input type="text" id="address" name="address" value="${account.address}" />
                </div>
                <div class="form-group">
                    <label for="phone">Phone:</label>
                    <input type="text" id="phone" name="phone" value="${account.phone}" />
                </div>
                <div class="form-group">
                    <button type="submit">Update Profile</button>
                </div>
            </form>
        </c:if>
        <c:if test="${account == null}">
            <p class="error">add succesful</p>
            <a href="home" class="btn-edit">Back home</a>
        </c:if>
    </div>
</body>
</html>
