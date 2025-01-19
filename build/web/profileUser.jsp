<%-- 
    Document   : Profile
    Created on : Jan 14, 2024, 9:35:11 PM
    Author     : thang
--%>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" integrity="sha512-/4Q9wpyT3YpkJB60uN2iaJZCJPCmC3P1hpebOW9Uj6enP3q5BbMyTKRLzE2hW8eT9s9jK5R5OJU8vJ1UO1bRSg==" crossorigin="anonymous" />
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>DebtDiary</title>
        <link href="assets/img/logo.png" rel="icon">
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.2.1/dist/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
    </head>
    <body class="bg-light">


        <c:if test="${noti != null}">

            <script>
                <c:if test="${noti=='success'}">
                swal("Successful!", "You clicked the button!", "success");
                </c:if>
                <c:if test="${noti=='fail'}">
                swal("Fail!", "You clicked the button!", "error");
                </c:if>
            </script>
            <c:remove var="noti" scope="request"/>
        </c:if>

        <div class="container mt-5">
            <h1 class="mb-4">Update Profile</h1>
            <c:if test="${phoneError ne null}">
                <p style="color: red;">${phoneError}</p>
            </c:if>
            <c:if test="${noti ne null}">
                <p style="color: green;">${noti}</p>
            </c:if>

            <form action="profile" method="post">
                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="firstName">First Name</label>
                            <input type="text" name="firstname" value="${user.firstName}" class="form-control" id="firstName" placeholder="First Name">
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="lastName">Last Name</label>
                            <input type="text" name="lastname" value="${user.lastName}" class="form-control" id="lastName" placeholder="Last Name">
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label for="dob">Date Of Birth</label>
                    <input type="date" name="dob" value="${user.dateOfBirth}" class="form-control" id="dob" placeholder="Date Of Birth">
                </div>

                <div class="form-group">
                    <label for="address">Address</label>
                    <input type="text" name="address" value="${user.address}" class="form-control" id="address" placeholder="Address">
                </div>

                <div class="form-group">
                    <label for="phone">Phone Number</label>
                    <input type="text" name="phone" value="${user.phoneNumber}" class="form-control" id="phone" placeholder="Phone Number">
                </div>



                <div class="form-group">
                    <label for="email">Email</label>
                    <input type="email" name="email" value="${user.email}" class="form-control" id="email" placeholder="Email" readonly>
                </div>
                <button type="submit" class="btn btn-success">
                    <span style="color: white;">Update Profile &#10004;</span>
                </button>

                <a class="btn btn-primary" style="color: white"href="change_password?id=${sessionScope.userLogin.id}">Change Password</a>
<!--                <a class="btn btn-primary ml-4" href="welcome?id=${sessionScope.userLogin.id}">Back</a>-->
                <a class="btn btn-primary ml-4" 
                   href="welcome?id= + ${sessionScope.userLogin.id }">Back
                </a>

            </form>
        </div>

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.6/dist/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.2.1/dist/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
    </body>
</html>
