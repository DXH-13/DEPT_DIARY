<%-- 
    Document   : feedback
    Created on : Mar 18, 2024, 9:02:06 PM
    Author     : yuh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DebtDiary</title>
        <link href="assets/img/logo.png" rel="icon">
        <link rel="stylesheet" href="css/feedback.css">
        <link rel="stylesheet" href="https://cdn.qbd.one/font-awesome/css/all.css">

    </head>
    <body>
        <form action="feedback" method="post" >
            <div>
                <a href="diary?id=${sessionScope.userLogin.id}"><img class="exit-button" type="button" src="assets/img/reject.png" class="refresh-icon" ></a> 
            </div>
            <p>Please rate our service out of 5</p>
            <div class="star-rating">
                <input name="star" id="star1" value="1" type="radio">
                <input name="star" id="star2" value="2" type="radio">
                <input name="star" id="star3" value="3" type="radio" selected>
                <input name="star" id="star4" value="4" type="radio">
                <input name="star" id="star5" value="5" type="radio">
                <label class="star-label fal fa-star" for="star5"></label>
                <label class="star-label fal fa-star" for="star4"></label>
                <label class="star-label fal fa-star selected" for="star3"></label>
                <label class="star-label fal fa-star" for="star2"></label>
                <label class="star-label fal fa-star" for="star1"></label>
            </div>
            <br/>
            <p>Please leave a comment below</p>
            <textarea name="comment">Easy to work with. Whilst the response did help, I found that it took too long for said response.</textarea>
            <br/>
            <br/>
            <button type="submit">Send Feedback</button>
        </form>


        <script src="js/feedback.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    </body>
</html>
