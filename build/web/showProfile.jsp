<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Account Profile</title>
    <style>
        /* Existing styles */
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f0f4f8;
            margin: 0;
            padding: 0;
        }
        .container {
            width: 70%;
            margin: 20px auto;
            padding: 20px;
            background: #ffffff;
            border-radius: 12px;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.15);
            border: 1px solid #ddd;
            overflow: hidden;
        }
        h1 {
            color: #333;
            text-align: center;
            font-size: 2.5em;
            margin-bottom: 20px;
            background: linear-gradient(45deg, #ff6f61, #de8f8f);
            -webkit-background-clip: text;
            -webkit-text-fill-color: transparent;
        }
        .profile-info {
            margin: 20px 0;
        }
        .profile-info p {
            background: linear-gradient(45deg, #ffffff, #f0f4f8);
            border: 1px solid #ccc;
            border-radius: 8px;
            padding: 20px;
            margin: 10px 0;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            font-size: 1.2em;
            color: #333;
        }
        .profile-info strong {
            color: #007bff;
            font-weight: bold;
        }
        .not-found {
            text-align: center;
            color: #ff3860;
            font-size: 1.5em;
            font-weight: bold;
        }
        .btn-edit {
            display: block;
            width: 200px;
            margin: 20px auto;
            padding: 10px;
            text-align: center;
            background-color: #007bff;
            color: #fff;
            font-size: 1.2em;
            border-radius: 5px;
            text-decoration: none;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
        }
        .btn-edit:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Account Profile</h1>
        <c:if test="${account != null}">
            <div class="profile-info">
                <p><strong>UID:</strong> ${account.uid}</p>
                <p><strong>User:</strong> ${account.user}</p>
                <p><strong>Password:</strong> ${account.pass}</p>
                <p><strong>Is Sell:</strong> ${account.isSell}</p>
                <p><strong>Is Admin:</strong> ${account.isAdmin}</p>
                <p><strong>First Name:</strong> ${account.firstName}</p>
                <p><strong>Last Name:</strong> ${account.lastName}</p>
                <p><strong>Active:</strong> ${account.active}</p>
                <p><strong>Address:</strong> ${account.address}</p>
                <p><strong>Phone:</strong> ${account.phone}</p>
            </div>
            <!-- Button to navigate to the edit profile page -->
            <a href="EditProfileServlet?pid=${account.uid}" class="btn-edit">Edit Profile</a>
        </c:if>
        
    </div>
</body>
</html>
