<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/5.1.3/css/bootstrap.min.css" integrity="sha384-KyZXEAg3QhqLMpG8r+Knujsl5+5hb7ie1UoiPePnvi3Tp8yT1hQROFhc1fF2Pg3B" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <link rel="stylesheet" href="css/login.css">
    <title>Login</title>
    <script>
        function doforgetPass() {
            window.location.href="forgetPassword";
        }
    </script>
    <style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background: linear-gradient(135deg, #ff9a9e 0%, #fecfef 100%);
        }
        #logreg-forms {
            width: 100%;
            max-width: 400px;
            padding: 20px;
            margin: auto;
            background: #fff;
            border-radius: 15px;
            box-shadow: 0 10px 25px rgba(0, 0, 0, 0.1);
        }
        .form-signin, .form-signup {
            padding: 20px;
        }
        .form-signin h1, .form-signup h1 {
            margin-bottom: 20px;
            color: #333;
        }
        .btn {
            margin-bottom: 10px;
            font-size: 1.1em;
        }
        .btn-success {
            background-color: #28a745;
            border-color: #28a745;
        }
        .btn-warning {
            background-color: #ffc107;
            border-color: #ffc107;
        }
        .btn-primary {
            background-color: #007bff;
            border-color: #007bff;
        }
        .btn-secondary {
            background-color: #6c757d;
            border-color: #6c757d;
        }
        .form-floating > .form-control {
            border: 2px solid #ddd;
            border-radius: 10px;
        }
        .form-floating > .form-control:focus {
            border-color: #007bff;
            box-shadow: 0 0 0 0.2rem rgba(0, 123, 255, 0.25);
        }
        .form-floating > label {
            color: #888;
        }
    </style>
</head>
<body>
    <div id="logreg-forms">
        <form class="form-signin" action="login" method="post">
            <h1 class="h3 mb-3 font-weight-normal text-center">Sign in</h1>
            <div class="alert alert-danger d-block mx-4 mb-3" role="alert"><b>${mess}</b></div>
            <div class="form-floating mb-3">
                <input type="text" class="form-control" id="inputEmail" placeholder="Username" required autofocus name="Username">
                <label for="inputEmail">Username</label>
            </div>
            <div class="form-floating mb-3">
                <input type="password" class="form-control" id="inputPassword" placeholder="Password" required name="Password">
                <label for="inputPassword">Password</label>
            </div>
            <button class="btn btn-success w-100" type="submit"><i class="fas fa-sign-in-alt"></i> Sign in</button>
            <hr>
            <button class="btn btn-warning w-100" type="button" onclick="doforgetPass()"><i class="fas fa-key"></i> Change Password</button>
            <hr>
            <button class="btn btn-primary w-100" type="button" id="btn-signup"><i class="fas fa-user-plus"></i> Sign up New Account</button>
        </form>
        <form action="signup" class="form-signup" method="post">
            <h1 class="h3 mb-3 font-weight-normal text-center">Sign up</h1>
            <div class="form-floating mb-3">
                <input type="text" class="form-control" id="user-email" placeholder="Username" required autofocus name="user">
                <label for="user-email">Username</label>
            </div>
            <div class="form-floating mb-3">
                <input type="password" class="form-control" id="user-pass" placeholder="Password" required name="pass">
                <label for="user-pass">Password</label>
            </div>
            <div class="form-floating mb-3">
                <input type="password" class="form-control" id="user-repeatpass" placeholder="Repeat Password" required name="repass">
                <label for="user-repeatpass">Repeat Password</label>
            </div>
            <!-- New fields for first name, last name, address, and phone -->
            <div class="form-floating mb-3">
                <input type="text" class="form-control" id="user-firstname" placeholder="First Name" required name="firstName">
                <label for="user-firstname">First Name</label>
            </div>
            <div class="form-floating mb-3">
                <input type="text" class="form-control" id="user-lastname" placeholder="Last Name" required name="lastName">
                <label for="user-lastname">Last Name</label>
            </div>
            <div class="form-floating mb-3">
                <input type="text" class="form-control" id="user-address" placeholder="Address" name="address">
                <label for="user-address">Address</label>
            </div>
            <div class="form-floating mb-3">
                <input type="text" class="form-control" id="user-phone" placeholder="Phone" name="phone">
                <label for="user-phone">Phone</label>
            </div>
            <button class="btn btn-primary w-100" type="submit"><i class="fas fa-user-plus"></i> Sign Up</button>
            <a href="#" id="cancel_signup" class="btn btn-secondary w-100 mt-2"><i class="fas fa-angle-left"></i> Back</a>
        </form>
    </div>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="js/login.js"></script>
</body>
</html>
