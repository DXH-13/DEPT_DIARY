<%-- 
    Document   : debtbill
    Created on : 14/02/2024, 9:30:09 PM
    Author     : ussat
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet" />
        <meta content="noindex, nofollow" name="robots" />
        <link rel="stylesheet" href="css/debtbill.css">
        <link rel="icon" href="assets/img/logo.png" type="image/png">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <title>DebtDiary</title>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/cleave.js/1.6.0/cleave.min.js"></script>
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <!-- Bootstrap JS and its dependencies -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/cleave.js/1.6.0/cleave.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

    </head>
    <body>
        <section class="container mt-5" id="debtform">
            <div class="row justify-content-center">
                <div class="col-md-6">
                    <form id="debtBill" method="get" action="viewBill" enctype="multipart/form-data">
                        <div>
                            <a href="debtDetailController?id=${sessionScope.Debtor.id}"><img class="exit-button" type="button" src="assets/img/reject.png" class="refresh-icon" ></a> 
                        </div>
                        <h2>Debt Bill: ${sessionScope.Debtor.fullName}</h2>
                        <input type="hidden" name="idDebtor" value="${debtor.id}">


                        <div class="form-group">
                            <label>Debt Type:</label>
                            <c:choose>
                                <c:when test="${DebtBill.idTypeDebt == 1}">
                                    <div style="background: #D60303; color: white; padding: 10px 10px; border-radius: 10px; display: inline-block;">CREDIT </div>-(You borrow money from ${sessionScope.Debtor.fullName})
                                </c:when>
                                <c:when test="${DebtBill.idTypeDebt == 4}">
                                    <div style="background: #D60303; color: white; padding: 10px 10px; border-radius: 10px; display: inline-block;">CREDIT </div>-(${sessionScope.Debtor.fullName} lends you money)
                                </c:when>
                                <c:when test="${DebtBill.idTypeDebt == 2}">
                                    <div style="background: #32850B; color: white; padding: 10px 10px; border-radius: 10px; display: inline-block;">DEBIT </div>-(You lend ${sessionScope.Debtor.fullName} money)
                                </c:when>
                                <c:otherwise>
                                    <div style="background: #32850B; color: white; padding: 10px 10px; border-radius: 10px; display: inline-block;">DEBIT </div>-(${sessionScope.Debtor.fullName} borrows money from you)
                                </c:otherwise>
                            </c:choose>
                        </div>


                        <div class="form-group">
                            <label for="amount">Amount</label>
                            <input type="text" class="form-control" id="amount" name="amount" value="<fmt:formatNumber value="${DebtBill.amount}" type="number"/>VND" disabled>
                            
                            <div id="amount-error" class="text-danger"></div>
                        </div>

                        <div class="form-group">
                            <label for="date">Create Date:</label>
                            <input type="datetime-local" id="date" name="date" value="${DebtBill.createdAt}" class="form-control" disabled>
                            
                        </div>


                        <div class="form-group">
                            <label for="note">Description</label>
                            <textarea id="note" name="note" rows="4" class="form-control" disabled>${DebtBill.description}</textarea>
                            <div id="note-error" class="text-danger"></div>
                        </div>
                        <div class="form-group">
                            <label>Evidence Image:</label>
                            <img style="width: 200px;" src="${DebtBill.evidenceImg1}">
                            <img style="width: 200px;" src="${DebtBill.evidenceImg2}">
                            <img style="width: 200px;" src="${DebtBill.evidenceImg3}">
                            <img style="width: 200px;" src="${DebtBill.evidenceImg4}">
                            <img style="width: 200px;" src="${DebtBill.evidenceImg5}">
                        </div>


                    </form>
                </div>
            </div>
        </section>
        <!-- Bootstrap và jQuery -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <!--        <script src="js/debtbill.js"></script>      -->

    </body>
</html>