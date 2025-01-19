<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>DebtDiary</title>
        <link href="assets/img/logo.png" rel="icon">
        <link href="css/listUser.css" rel="stylesheet">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/toastify/1.x.x/toastify.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/toastify/1.x.x/toastify.min.css">
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    </head>
    <body>

        <h1 class="title">List of users</h1>
<!--        <p style="color: green;">${noti}</p>-->
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

        <c:set var="page" value="${page}" />

        <table>
            <thead>
                <tr>
                    <th style="text-align: center">ID</th>
                    <th style="text-align: center">First Name</th>
                    <th style="text-align: center">Last Name</th>
                    <th style="text-align: center">Date of Birth</th>
                    <th style="text-align: center">Phone Number</th>
                    <th style="text-align: center">Email</th>
                    <th style="text-align: center">Address</th>
                    <th style="text-align: center">Activation</th>
                    <th style="text-align: center">Action</th>
                </tr>
            <form action="list_user" method="post">
                <tr>
                    <th>
                        <input type="text" name="id" placeholder="Enter id" style="width: 50px">
                    </th>
                    <th>
                        <input type="text" name="firstName" placeholder="Enter first name" style="width: 100px">
                    </th>
                    <th>
                        <input type="text" name="lastName" placeholder="Enter last name" style="width: 100px">
                    </th>
                    <th>
                        <input type="text" name="dob" placeholder="Enter date of birth" style="width: 120px">
                    </th>
                    <th>
                        <input type="text" name="phoneNumber" placeholder="Enter phone number">
                    </th>
                    <th>
                        <input type="text" name="email" placeholder="Enter email">
                    </th>
                    <th>
                        <input type="text" name="address" placeholder="Enter address">
                    </th>
                    <th>
                        <select name="activation">
                            <option value="">All</option>
                            <option value="0">Active</option>
                            <option value="1">Deactive</option>
                        </select>
                    </th>
                    <th>
                        <button type="submit" style="background-color: transparent; border: 0px; margin-right: 20px; margin-left: 70px " ><img src="assets/img/search-debtor.png" style="max-width: 25px;  border-radius: 5px; cursor: pointer;"></button>
                        <a href="list_user"><img src="assets/img/clear-filter-white.png" style="max-width: 25px; margin-left: 7px; border-radius: 5px;"></a>
                    </th>
                </tr>
            </form>

        </thead>
        <tbody>
            <c:forEach var="user" items="${data}" varStatus="loop">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.firstName}</td>
                    <td>${user.lastName}</td>
                    <td>${user.dateOfBirth}</td>
                    <td>${user.phoneNumber}</td>
                    <td>${user.email}</td>
                    <td>${user.address}</td>
                    <td style="text-align: center;">
                        <img src="${user.isDelete ? 'assets/img/deactive.png' : 'assets/img/active.png'}" alt="${user.isDelete ? 'Deactive' : 'Active'}" style="width: 20px; height: 20px;">
                    </td>
                    <td class="action-buttons" >
                        <form action="edit_profile_user" method="get">
                            <input type="hidden" name="id" value="${user.id}">
                            <button type="submit" class="update-button">Update</button>
                        </form>
                        <form action="activate" method="post">
                            <input type="hidden" name="id" value="${user.id}">
                            <button type="submit" class="activate-button" >Activate</button>
                        </form>
                        <form action="delete_user_account" method="post">
                            <input type="hidden" name="id" value="${user.id}">
                            <button type="submit" class="delete-button" >Deactivate</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <div class="pagination"> 
        <c:forEach begin="${1}" end="${num}" var="i">
            <a class="${i==page?"active":""}" href="list_user?page=${i}">${i}</a>
        </c:forEach>
    </div>
    <a href="admin?id= ${sessionScope.userLogin.id}" class="back-button"><button>Back</button></a>
</body>
</html>
