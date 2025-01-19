
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <title>DebtDiary</title>
        <meta content="" name="description">
        <meta content="" name="keywords">
        <!-- Favicons -->
        <link href="assets/img/logo.png" rel="icon">
        <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">
        <!-- Google Fonts -->
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">
        <!-- Vendor CSS Files -->
        <link href="vendor/aos/aos.css" rel="stylesheet">
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
        <link href="vendor/glightbox/css/glightbox.min.css" rel="stylesheet">
        <link href="vendor/remixicon/remixicon.css" rel="stylesheet">
        <link href="vendor/swiper/swiper-bundle.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.css">
        <!-- Template Main CSS File -->
        <link href="css/home.css" rel="stylesheet">
        <link href="css/login.css" rel="stylesheet">
        <link href="css/signup.css" rel="stylesheet">

    </head>

    <body>

        <!-- ======= Header ======= -->
        <header id="header" class="header fixed-top">
            <div class="container-fluid container-xl d-flex align-items-center justify-content-between">

                <a href="home" class="logo d-flex align-items-center">
                    <img src="assets/img/logo.png" alt="">
                    <span>DebtDiary</span>
                </a>

                <nav id="navbar" class="navbar">
                    <ul>
                        <li><a class="nav-link scrollto active" href="#hero">Home</a></li>
                        <li><a class="nav-link scrollto" href="${empty sessionScope.userLogin ? 'login' : 'diary?id=' + sessionScope.userLogin.id}">DebtDiary</a></li>
                        <li><a class="nav-link scrollto" href="#about">About</a></li>
                        <li><a class="nav-link scrollto" href="#team">Team</a></li>
                        <li><a class="nav-link scrollto" href="#contact">Contact</a></li>
                        <li><a class="getstarted1 scrollto" href="login">Login</a></li>
                        <li><a class="getstarted scrollto" href="signup">Join for Free</a></li>
                    </ul>
                    <i class="bi bi-list mobile-nav-toggle"></i>
                </nav><!-- .navbar -->

            </div>
        </header><!-- End Header -->

        <!-- ======= Hero Section ======= -->
        <section id="hero" class="hero d-flex align-items-center" >

            <div class="container">
                <div class="row">
                    <div class="col-lg-6 d-flex flex-column justify-content-center">
                        <h1 data-aos="fade-up">We offer modern solutions to manage your finances</h1>
                        <h2 data-aos="fade-up" data-aos-delay="400">Take charge of your finances with DebtDiary - a web tool for easy debt and loan management. Simplify your financial journey today!</h2>
                        <div data-aos="fade-up" data-aos-delay="600">
                            <div class="text-center text-lg-start">
                                <a href="#about" class="btn-get-started scrollto d-inline-flex align-items-center justify-content-center align-self-center">
                                    <span>Get Started</span>
                                    <i class="bi bi-arrow-right"></i>
                                </a>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6 hero-img" data-aos="zoom-out" data-aos-delay="200">
                        <img src="assets/img/hero-img.png" class="img-fluid" alt="">
                    </div>
                </div>
            </div>

        </section><!-- End Hero -->

        <main id="main">
            <!-- ======= About Section ======= -->
            <section id="about" class="about">

                <div class="container" data-aos="fade-up">
                    <div class="row gx-0">

                        <div class="col-lg-6 d-flex flex-column justify-content-center" data-aos="fade-up" data-aos-delay="200">
                            <div class="content">
                                <h3>Who We Are</h3>
                                <h2>IS1704 at FPT University proudly presents DebtDiary, our ISP 392 innovation!  </h2>
                                <p>
                                    Brace yourself for a cutting-edge experience as we blend passion with technology to bring you something extraordinary. Your journey to excellence starts here!
                                </p>
                            </div>
                        </div>
                        <div class="col-lg-6 d-flex align-items-center" data-aos="zoom-out" data-aos-delay="200">
                            <img src="assets/img/fpt.jpg" class="img-fluid" alt="">
                        </div>

                    </div>
                </div>

            </section><!-- End About Section -->



            <!-- ======= Team Section ======= -->
            <section id="team" class="team">

                <div class="container" data-aos="fade-up">

                    <header class="section-header">
                        <h2>Team 3</h2>
                        <p>Our hard working team</p>
                    </header>

                    <div class="row gy-4">

                        <div class="col-lg-3 col-md-6 d-flex align-items-stretch smaller-card" data-aos="fade-up" data-aos-delay="100">
                            <div class="member">
                                <div class="member-img">
                                    <img style="width: 240px; height: 240px" src="assets/img/team/huy.png" class="img-fluid" alt="">
                                </div>
                                <div class="member-info">
                                    <h4>Dang Xuan Huy</h4>
                                    <span>Team Leader</span>
                                    <p>Velit aut quia fugit et et. Dolorum ea voluptate vel tempore tenetur ipsa quae aut. Ipsum exercitationem iure minima enim corporis et voluptate.</p>
                                </div>
                            </div>
                        </div>

                        <div class="col-lg-3 col-md-6 d-flex align-items-stretch smaller-card" data-aos="fade-up" data-aos-delay="200">
                            <div class="member">
                                <div class="member-img">
                                    <img style="width: 240px; height: 240px" src="assets/img/team/thang.jpg" class="img-fluid" alt="">
                                </div>
                                <div class="member-info">
                                    <h4>Do Viet Thang</h4>
                                    <span>Product Manager</span>
                                    <p>Quo esse repellendus quia id. Est eum et accusantium pariatur fugit nihil minima suscipit corporis. Voluptate sed quas reiciendis animi neque sapiente.</p>
                                </div>
                            </div>
                        </div>

                        <div class="col-lg-3 col-md-6 d-flex align-items-stretch smaller-card" data-aos="fade-up" data-aos-delay="300">
                            <div class="member">
                                <div class="member-img">
                                    <img style="width: 240px; height: 240px" src="assets/img/team/khai.jpg" class="img-fluid" alt="">
                                </div>
                                <div class="member-info">
                                    <h4>Luong Duy Khai</h4>
                                    <span>CTO</span>
                                    <p>Vero omnis enim consequatur. Voluptas consectetur unde qui molestiae deserunt. Voluptates enim aut architecto porro aspernatur molestiae modi.</p>
                                </div>
                            </div>
                        </div>

                        <div class="col-lg-3 col-md-6 d-flex align-items-stretch smaller-card" data-aos="fade-up" data-aos-delay="400">
                            <div class="member">
                                <div class="member-img">
                                    <img style="width: 240px; height: 240px" src="assets/img/team/dat.jpg" class="img-fluid" alt="">
                                </div>
                                <div class="member-info">
                                    <h4>Nguyen Tien Dat</h4>
                                    <span>Accountant</span>
                                    <p>Rerum voluptate non adipisci animi distinctio et deserunt amet voluptas. Quia aut aliquid doloremque ut possimus ipsum officia.</p>
                                </div>
                            </div>
                        </div>

                        <div class="col-lg-3 col-md-6 d-flex align-items-stretch smaller-card" data-aos="fade-up" data-aos-delay="500">
                            <div class="member">
                                <div class="member-img">
                                    <img  style="width: 240px; height: 240px" src="assets/img/team/nam.jpg" class="img-fluid" alt="">
                                </div>
                                <div class="member-info">
                                    <h4>Nguyen Hai Nam</h4>
                                    <span>Accountant</span>
                                    <p>Rerum voluptate non adipisci animi distinctio et deserunt amet voluptas. Quia aut aliquid doloremque ut possimus ipsum officia.</p>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
            </section><!-- End Team Section -->



            <!-- ======= Contact Section ======= -->
            <section id="contact" class="contact">

                <div class="container" data-aos="fade-up">

                    <header class="section-header">
                        <h2>Contact</h2>
                        <p>Contact Us</p>
                    </header>

                    <div class="row gy-4">

                        <div class="col-lg-6">

                            <div class="row gy-4">
                                <div class="col-md-6">
                                    <div class="info-box">
                                        <i class="bi bi-geo-alt"></i>
                                        <h3>Address</h3>
                                        <p>Hoa Lac Hi-tech Park, Km29 Thang Long Avenue,<br>Thach Hoa, Thach That, Ha Noi, Vietnam</p>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="info-box">
                                        <i class="bi bi-telephone"></i>
                                        <h3>Call Us</h3>
                                        <p>01234567890<br></p>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="info-box">
                                        <i class="bi bi-envelope"></i>
                                        <h3>Email Us</h3>
                                        <p>deptdiary1704@gmail.com<br></p>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="info-box">
                                        <i class="bi bi-clock"></i>
                                        <h3>Open Hours</h3>
                                        <p>Monday - Friday<br>9:00AM - 05:00PM</p>
                                    </div>
                                </div>
                            </div>

                        </div>

                        <div class="col-lg-6">
                            <form action="forms/contact.php" method="post" class="php-email-form">
                                <div class="row gy-4">

                                    <div class="col-md-6">
                                        <input type="text" name="name" class="form-control" placeholder="Your Name" required>
                                    </div>

                                    <div class="col-md-6 ">
                                        <input type="email" class="form-control" name="email" placeholder="Your Email" required>
                                    </div>

                                    <div class="col-md-12">
                                        <input type="text" class="form-control" name="subject" placeholder="Subject" required>
                                    </div>

                                    <div class="col-md-12">
                                        <textarea class="form-control" name="message" rows="6" placeholder="Message" required></textarea>
                                    </div>

                                    <div class="col-md-12 text-center">
                                        <div class="loading">Loading</div>
                                        <div class="error-message"></div>
                                        <div class="sent-message">Your message has been sent. Thank you!</div>

                                        <button type="submit">Send Message</button>
                                    </div>

                                </div>
                            </form>

                        </div>

                    </div>

                </div>

            </section><!-- End Contact Section -->

        </main><!-- End #main -->

        <!-- ======= Footer ======= -->
        <footer id="footer" class="footer">

            <div class="footer-top">
                <div class="container">
                    <div class="row gy-4">
                        <div class="col-lg-5 col-md-12 footer-info">
                            <a href="index.html" class="logo d-flex align-items-center">
                                <img src="assets/img/logo.png" alt="">
                                <span>DebtDiary</span>
                            </a>
                            <p>Take charge of your finances with DebtDiary ? A web tool crafted by FPT University students for easy debt and loan management. Simplify your financial journey today!</p>
                        </div>

                        <div class="col-lg-2 col-6 footer-links">
                            <h4>Useful Links</h4>
                            <ul>
                                <li><i class="bi bi-chevron-right"></i> <a href="#">Home</a></li>
                                <li><i class="bi bi-chevron-right"></i> <a href="#">DebtDiary</a></li>
                                <li><i class="bi bi-chevron-right"></i> <a href="#">About us</a></li>
                            </ul>
                        </div>

                        <div class="col-lg-2 col-6 footer-links">
                            <h4>Our Services</h4>
                            <ul>
                                <li><i class="bi bi-chevron-right"></i> <a href="#">Web Design</a></li>
                                <li><i class="bi bi-chevron-right"></i> <a href="#">Web Development</a></li>
                                <li><i class="bi bi-chevron-right"></i> <a href="#">Product Management</a></li>
                                <li><i class="bi bi-chevron-right"></i> <a href="#">Marketing</a></li>
                                <li><i class="bi bi-chevron-right"></i> <a href="#">Graphic Design</a></li>
                            </ul>
                        </div>

                        <div class="col-lg-3 col-md-12 footer-contact text-center text-md-start">
                            <h4>Contact Us</h4>
                            <p>
                                Hoa Lac Hi-tech Park, Km29 Thang Long Avenue, 
                                Thach Hoa, Thach That, Ha Noi <br>
                                Vietnam <br><br>
                                <strong>Phone:</strong> 0327992501<br>
                                <strong>Email:</strong> deptdiary1704@gmail.com<br>
                            </p>

                        </div>

                    </div>
                </div>
            </div>
            <div class="container">
                <div class="copyright">
                    &copy; Copyright <strong><span>DebtDiary</span></strong>. All Rights Reserved
                </div>
                <div class="credits">
                    <!-- All the links in the footer should remain intact. -->
                    <!-- You can delete the links only if you purchased the pro version. -->
                    <!-- Licensing information: https://bootstrapmade.com/license/ -->
                    <!-- Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/flexstart-bootstrap-startup-template/ -->
                    Designed by <a href="https://bootstrapmade.com/">Gr3-IS1704</a>
                </div>
            </div>
        </footer><!-- End Footer -->
    </div>





    <!-- Pop-up content -->
    <div id="overlay"></div>

    <!-- Sign up Popup --> 
    <div class="signup-popup" id="SignupPopup">
        <div class="signup-form" >
            <c:set var="cookie" value="${pageContext.request.cookies}"/>
            <div>
                <img class="exit-button" type="button" src="assets/img/reject.png" class="refresh-icon" onclick="closeSignupPopup()">
            </div>
            <form action="home" method="post">
                <div class="form-title">
                    Sign Up
                </div>

                <input type="hidden" name="action" value="signup">

                <div class="form-input">
                    <label for="email">Email</label>
                    <input type="email" id="username" name="email" placeholder="Enter your email" value="${email}">
                </div>

                <div class="form-input">
                    <label for="name">UserName</label>
                    <input type="text" id="name" name="name" placeholder="Enter user name" value="${username}">
                </div>

                <div>
                    <span class="error-message" style="color: red;">${userNameErrorMessage}</span>                            
                </div>
                <div class="form-input">
                    <label for="password">Password</label>
                    <input id="password" name="password" placeholder="Enter your password" value="${password}" type="password" />
                </div> 

                <div class="form-input">
                    <label for="confirmPassword">Confirm Password</label>
                    <input id="confirmPassword" name="confirmPassword" placeholder="Confirm your password" value="${confirmPassword}" type="password" />
                </div>

                <div>
                    <span class="error-message" style="color: red;">${confirmPasswordErrorMessage}</span>                            
                </div>

                <div class="captcha"> 
                    <img id="captcha" src="captcha" alt="CAPTCHA" style="border: 1px solid #000;">
                    <input class="input" type="text" name="captchaSignupInput" placeholder="Enter captcha" >
                    <c:if test="${not empty captchaError}">
                        <div style="color: red;">${captchaError}</div>
                    </c:if>
                    <img id="refreshSignupCaptchaButton" class="captcha-image" src="assets/img/refreshIcon.png" alt="Refresh Captcha" class="refresh-icon" onclick="refreshCaptcha()">
                </div>

                <div>
                    <span class="error-message" style="color: red;">${error}</span>                            
                </div>

                <div class="form-input">
                    <button type="submit" id="signup-btn">Signup</button>
                </div>
            </form>
        </div>
    </div>

    <!-- End Sign up Popup -->


    <!-- Login Popup -->
    <div class="login-popup" id="LoginPopup" >
        <div class="login-form" >
            <c:set var="cookie" value="${pageContext.request.cookies}"/>
            <div>
                <img class="exit-button" type="button" src="assets/img/reject.png" class="refresh-icon" onclick="closeLoginPopup()">
            </div>
            <form action="home" method="post">
                <div class="form-title">
                    Login
                </div>

                <input type="hidden" name="action" value="login">

                <div class="form-input">
                    <label for="username">Username</label>
                    <input type="text" id="username" name="username" placeholder="Enter username" value="${cookie.cuser.value}">
                </div>

                <div class="form-input">
                    <label for="password">Password</label>
                    <input type="password" id="password" name="password" placeholder="Enter password" value="${cookie.cpass.value}">
                </div>

                <div>
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" ${(cookie.crem != null ? 'checked' : '')} value="OFF" name="rem">
                        <label class="form-check-label" for="rem"> Remember me </label>
                    </div>
                </div> 

                <div class="captcha"> 
                    <img id="captchaLogin" src="captcha" alt="CAPTCHA" style="border: 1px solid #000;">
                    <input class="input" type="text" name="captchaLoginInput" placeholder="Enter captcha" >
                    <c:if test="${not empty captchaError}">
                        <div style="color: red;">${captchaError}</div>
                    </c:if>
                    <img id="refreshLoginCaptchaButton" class="captcha-image" src="assets/img/refreshIcon.png" alt="Refresh Captcha" class="refresh-icon" onclick="refreshCaptchaLogin()">
                </div>

                <div class="form-input">
                    <button type="submit" id="login-btn">Login</button>
                </div>
            </form>
            <div class="form-links">
                <a href="signup.jsp">Register</a> | <a href="forgotPassword.jsp">Forgot Password?</a> | <a href="home.jsp">Back</a>
            </div>
        </div>
    </div>
    <!-- End Login Popup -->




    <!--  Notification Popup -->
    <c:if test="${not empty errorWrongInforLogin}">
        <script>
            // Function to display the notification popup using SweetAlert
            function showNotification() {
                swal({
                    title: "Inform",
                    text: "Wrong account infomation!",
                    icon: "error",
                    button: "OK",
                });
            }

            // Show notification on page load
            window.onload = function () {
                showNotification();
            };
        </script>
    </c:if>
    <!-- End Notification Popup -->



    <a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>
    <!-- Vendor JS Files -->
    <script src="vendor/purecounter/purecounter_vanilla.js"></script>
    <script src="vendor/aos/aos.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    <script src="vendor/glightbox/js/glightbox.min.js"></script>
    <script src="vendor/isotope-layout/isotope.pkgd.min.js"></script>
    <script src="vendor/swiper/swiper-bundle.min.js"></script>
    <script src="vendor/php-email-form/validate.js"></script>
    <!-- Template Main JS File -->
    <script src="js/home.js"></script>
    <script src="js/login.js"></script>
    <script src="js/signup.js"></script>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>

</body>

</html>