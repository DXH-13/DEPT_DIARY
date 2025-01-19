<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DebtDiary</title>
        <link href="assets/img/logo.png" rel="icon">
        <link href="css/viewFeedback.css" rel="stylesheet">
        <link href="https://cdn.lineicons.com/4.0/lineicons.css" rel="stylesheet" />
    </head>
    <body>
        <h1 class="title">User's Feedback</h1>
        <c:set var="page" value="${page}" />

        <div style="padding: 8px; position: fixed; left:30px; top:670px; background: white; border-radius: 5px ">
            Total: ${size} comments
        </div>

        <table>
            <thead>
                <tr>
                    <th class="id_th"> ID</th>
                    <th class="username_th" >User name</th>
                    <th class="name_th">Name</th>
                    <th class="rate_th">Rate</th>
                    <th class="comment_th">Comment</th>
                    <th style="width: 120px;">Action</th>
                </tr> 

            <form action="viewFeedback" method="post">
                <tr>
                    <th class="id_th">
                        <input type="text" placeholder="Enter id" name="id" style="width: 50px;">
                    </th>
                    <th class="username_th" >
                        <input type="text" placeholder="Enter username" name="username" style="width: 100px;">
                    </th>
                    <th class="name_th">
                        <input type="text" placeholder="Enter name" name="name" style="width: 100px;"> 
                    </th>
                    <th class="rate_th">
                        <select name="rate">
                            <option value="">All</option>
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                            <option value="5">5</option>
                        </select>
                    </th>
                    <th class="comment_th">
                        <input type="text" placeholder="Enter comment" name="comment" style="width: 700px;">
                    </th>
                    <th>
                        <button type="submit" style="background: transparent; border-width:0px; cursor: pointer; "><img src="assets/img/search-debtor.png" style="max-width: 25px; "></button>                      
                        <a href="viewFeedback"><img src="assets/img/clear-filter-white.png" style="max-width: 25px; margin-left: 7px; border-radius: 5px;"></a>
                    </th>         
                </tr>

            </form>
        </thead>

        <tbody>
            <c:forEach var="feedback" items="${data}" varStatus="loop">
                <tr>
                    <td style="text-align: center;">${feedback.id}</td>
                    <td style="text-align: center;">${feedback.userName}</td>
                    <td style="text-align: center;">${feedback.name}</td>
                    <td style="text-align: center;">${feedback.rate}/5</td>
                    <td>${feedback.comment}</td>

                </tr>
            </c:forEach>
        </tbody>
    </table>



    <div class="paggi">
        <div class="pagination " > 
            <c:forEach begin="${1}" end="${num}" var="i">
                <a style="height: 35px; width: 32px;" class="${i==page?"active":""}" href="viewFeedback?page=${i}">${i}</a>
            </c:forEach>
        </div>
    </div>



    <a href="admin?id= ${sessionScope.userLogin.id}" class="back-button"><button>Back</button></a>
</body>
</html>
