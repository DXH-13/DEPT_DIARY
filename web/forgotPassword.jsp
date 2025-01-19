<%-- 
    Document   : forgot
    Created on : Jan 17, 2024, 10:06:15 PM
    Author     : khail
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>DeptDiary</title>
        <meta name="viewport" content="width=device-width" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="css/forgotPassword.css">
        <link rel="icon" href="assets/img/logo.png" type="image/png">
    </head>

    <body>
        <div class="forgot-form">
            <form action="forgot_password" method="post">

                <div class="forgot-title">
                    Forgot Password
                </div>

                <div class="forgot-input">
                    <label for="username">Enter username:</label>
                    <input type="text" id="username" placeholder="Enter your username" name="username" required="">
                    <div>
                        <span class="error-message">${error}</span>
                    </div> 

                </div>
                <div class="captcha"> 
                    <img src="captcha" alt="CAPTCHA" style="border: 1px solid #000;">
                    <input class="input" type="text" name="captchaInput" placeholder="Enter captcha" >
                    <c:if test="${not empty captchaError}">
                        <div style="color: red;">${captchaError}</div>
                    </c:if>
                    <img class="captcha-image" src="assets/img/refreshIcon.png" alt="Refresh Captcha" class="refresh-icon" onclick="refreshCaptcha()">
                </div>

                    <button id="forgot-btn"> Confirm</button>
                    <a  href="login.jsp">Back to Login</a>
            </form>
        </div>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <script src="js/forgot.js"></script>
    </body>
</html>

