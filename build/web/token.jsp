<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Html.html to edit this template
-->
<html lang="en">

    <head>
        <title>DeptDiary</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="css/token.css">
        <link rel="icon" href="assets/img/logo.png" type="image/png">
    </head>
    <body>
        <div class="token-form">
        <form action="token" method="post">
        <div class="token-title">
            Verify Password Token
        </div>
        <div class="token-input">
            <label for="token">Token:</label>
            <input type="text" placeholder="Enter token" name="enteredToken">
            <div>
                <span class="error-message">${error}</span>
            </div>
        </div>
        <div class="token-input">
            <button id="token-btn">Submit</button>
        </div>
        </div>
</form>
    </body>
</html>
