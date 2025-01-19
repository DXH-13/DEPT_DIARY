<%-- 
    Document   : signup
    Created on : 20 Jan 2024, 6:44:09 pm
    Author     : ussat
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta content="width=device-width, initial-scale=1.0" name="viewport" />
        <title>Sign Up</title>
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet" />
        <meta content="noindex, nofollow" name="robots" />
        <link rel="stylesheet" href="css/signup.css">
        <link href="assets/img/logo.png" rel="icon">
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/cleave.js/1.6.0/cleave.min.js"></script>

    </head>

    <body>
        <!-- Sign Up Form -->
        <section class="container mt-5" id="signup">
            <div class="row justify-content-center">
                <div class="col-md-6">
                    <form id="signupForm" method="post" action="signup">
                        <div class ="form-title">Sign Up</div>

                        <div class="form-group">
                            <label for="email">Email</label>
                            <input class="form-control" id="email" name="email" placeholder="Enter your email" type="email" value="${email}"/>
                            <div id="email-error" class="text-danger"></div>
                        </div>

                        <div class="form-group">
                            <label for="name">UserName</label>
                            <input class="form-control" id="name" name="name" placeholder="Enter your name" type="text" value="${username}" />
                            <div id="username-error" class="text-danger"></div>
                            <span class="text-danger">${userNameErrorMessage}</span>
                        </div>

                        <div class="form-group">
                            <label for="password">Password</label>
                            <input class="form-control" id="password" name="password" placeholder="Enter your password" type="password" value="${password}"/>
                            <div id="password-error" class="text-danger"></div>
                        </div>

                        <div class="form-group">
                            <label for="confirmPassword">Confirm Password</label>
                            <input class="form-control" id="confirmPassword" name="confirmPassword" placeholder="Confirm your password" type="password" value="${confirmPassword}"/>
                            <div id="confirm-password-error" class="text-danger"></div>
                            <span class="text-danger">${confirmPasswordErrorMessage}</span>
                        </div>

                        <div class="captcha">
                            <img src="captcha" alt="CAPTCHA" style="border: 1px solid #000;">
                            <input class="form-control" type="text" name="captchaInput" placeholder="Enter captcha" value="${captchaInput}">
                            <img class="captcha-image" src="assets/img/refreshIcon.png" alt="Refresh Captcha" onclick="refreshCaptcha()">
                            <div id="captcha-error" class="text-danger"></div>
                            <span class="text-danger">${errorCaptcha}</span>
                        </div>
                        <button class="btn btn-primary w-100" type="button" id="signUpButton">Sign Up
                        </button>

                        <a href="login.jsp">Back to Login</a>
                    </form>
                </div> 
            </div>
        </section>
        <!-- Modal Confirmation -->
        <div class="modal fade" id="confirmationModal" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="modalLabel">Confirm</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        Do you want to create new account ? 
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        <button type="button" class="btn btn-primary" id="confirmSubmit">Confirm</button>
                    </div>
                </div>
            </div>
        </div>   
        <!-- Bootstrap & jQuery JS -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <script src="js/signup.js"></script>
    </body>

</html>
