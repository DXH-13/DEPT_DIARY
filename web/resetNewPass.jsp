<!DOCTYPE html>
<html lang="en">

<head>
    <title>DeptDiary</title>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="css/resetPassword.css">
    <link rel="icon" href="assets/img/logo.png" type="image/png">
</head>
<body>
    <div class="reset-form">
        <div class="reset-title">
            Reset Password
        </div>
        <form action="reset_password" method="post">
            
                <input type="hidden" name="id" value="${user.id}">
                <input type="hidden" name="oldPassword" value="${user.passWord}">
                
                <div class="reset-input">
                    <label for="password">Password</label>
                    <input type="password" id="password" placeholder="Enter your new password" name="newPassword" type="text">
                </div>
                <div class="reset-input">
                    <label for="password">Re-type Password</label>
                    <input type="password" id="password" placeholder="Retype your new password" name="retypePassword" type="text">
                </div>
                <p>${noti}</p>
        <div class="reset-input">
            <button id="reset-btn">Submit</button>
        </div>
        </form>
        </div>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <script src="js/reset.js"></script>

</body>

</html>