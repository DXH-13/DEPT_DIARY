<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <link href="assets/img/logo.png" rel="icon">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>DebtDiary</title>
        <link rel="stylesheet" type="text/css" href="css/debtBillDetail.css">
    </head>

    <body>
        <c:set var="page" value="${page}" />
        <main class="table" id="customers_table">
            <section class="table__header">
                <div>
                    <h1 style="font: bold;">${debtor.fullName}</h1>
                    <h1 style="font-size: 14px;">Total: ${listSize} records</h1>
                </div>
                <div class="input-group">
                    <input type="search" placeholder="Search Data...">
                    <img src="assets/img/search.png" alt="">
                </div>
                <div class="export__file">
                    <a class="export__file-btn" href="diary?id=${sessionScope.userLogin.id}"></a>
                </div>
            </section>
            <section class="table__body">

                <table>

                    <thead>
                        <tr>
                            <th> Id <span class="icon-arrow">&UpArrow;</span></th>
                            <th> Description <span class="icon-arrow">&UpArrow;</span></th>
                            <th> Type debt <span class="icon-arrow">&UpArrow;</span></th>
                            <th> Amount <span class="icon-arrow">&UpArrow;</span></th>
                            <th> Create at <span class="icon-arrow">&UpArrow;</span></th>
                            <th> Action <span class="icon-arrow">&UpArrow;</span></th>
                        </tr>

                        <tr class="search-wrapper">
                    <form action="debtDetailController" method="post">
                        
                        <input type="hidden" value="${debtor.id}" name="idDebtor">
                        <th class="searchById">
                            <input  type="text" placeholder="Enter ID" name="idDebtBill" style="width: 100%; padding: 5px; border-radius: 5px;">
                        </th>

                        <th class="searchByDescription">
                            <input  type="text" placeholder="Enter Description" name="description" style="width: 100%; padding: 5px; border-radius: 5px;">
                        </th>

                        <th class="searchByType">
                            <select name="type" style="width: 100%; padding: 5px; border-radius: 5px;">
                                <option value="">All</option>
                                <option value="2">You lend ${debtor.fullName}</option>
                                <option value="1">You borrow ${debtor.fullName}</option>
                                <option value="4">${debtor.fullName} lend you</option>
                                <option value="3">${debtor.fullName} borrow you</option>
                            </select>
                        </th>

                        <th class="searchByAmount" style="white-space: nowrap; ">
                            <div style="display: inline-block;">
                                <input type="text" placeholder="from" name="fromAmount"  style="width: 75px; padding: 5px; border-radius: 5px;">
                                <input type="text" placeholder="to" name="toAmount"  style="width: 75px; padding: 5px; border-radius: 5px;">
                            </div>
                        </th>

                        <th class="searchByTime" style="white-space: nowrap;">
                            <div style="display: inline-block;">
                                <input type="text" placeholder="from" name="fromTime" style="width: 75px; padding: 5px; border-radius: 5px;">
                                <input type="text" placeholder="to" name="toTime" style="width: 75px; padding: 5px; border-radius: 5px;">
                            </div>
                        </th>

                        <th> 
                            <button type="submit" style="background-color: transparent; border: 0px;  " ><img src="assets/img/search.png" style="max-width: 30px;  border-radius: 5px; cursor: pointer;"></button>
                            <a href="debtDetailController?id=${debtor.id}"><img src="assets/img/clear-filter.png" style="max-width: 30px; margin-left: 7px; border-radius: 5px;"></a>
                        </th>
                    </form>
                    </tr>

                    </thead>

                    <tbody>



                        <c:forEach items="${data}" var="debtBill">
                            <tr class="data-row">
                                <td> ${debtBill.id} </td>
                                <td> ${debtBill.description}</td>
                                <td>
                                    <c:choose>
                                        <c:when test="${debtBill.idTypeDebt == 1}">
                                            (-)You borrow ${debtor.fullName}
                                        </c:when>
                                        <c:when test="${debtBill.idTypeDebt == 2}">
                                            (+)You lend ${debtor.fullName}
                                        </c:when>
                                        <c:when test="${debtBill.idTypeDebt == 3}">
                                            (+)${debtor.fullName} borrow You
                                        </c:when>
                                        <c:when test="${debtBill.idTypeDebt == 4}">
                                            (-)${debtor.fullName} lend You
                                        </c:when>
                                    </c:choose>
                                </td>
                                <td> 
                                    <c:choose>
                                        <c:when test="${debtBill.idTypeDebt == 4 || debtBill.idTypeDebt == 1}">
                                            <div style="color: red;"><fmt:formatNumber value="${debtBill.amount}" type="number"/>VND</div>
                                        </c:when>
                                        <c:otherwise>
                                            <div "><fmt:formatNumber value="${debtBill.amount}" type="number"/>VND</div>
                                        </c:otherwise>
                                    </c:choose>
                                </td>
                                <td>${debtBill.createdAt}</td>
                                <td> <a href="viewBill?id=${debtBill.id}" class="status delivered">Detail</a></td>
                            </tr>
                        </c:forEach>


                        <c:if test="${listSizePerPage < numperpage}">
                            <c:forEach begin="0" end="${numperpage - listSizePerPage - 1}">
                                <tr class="data-row">
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                </tr>
                            </c:forEach>
                        </c:if>
                    </tbody>
                </table>
            </section>



            <section>

                <div class="paggi">

                    <div class="numOfRecord">
                        <div class="flex items-center justify-between  bg-white px-2 py-1 sm:px-3 sm:py-2">
                            <div class="hidden sm:flex sm:flex-1 sm:items-center sm:justify-between">
                                <div>
                                    <p class="text-sm text-gray-700">
                                        Showing
                                        <span class="font-medium">${startPage}</span>
                                        to
                                        <span class="font-medium">${endPage}</span>
                                        of
                                        <span class="font-medium">${listSize}</span>
                                        records
                                    </p>
                                </div>  
                            </div>
                        </div>

                        <!--                        <div style="width: 130px; " class="input-field col s2">
                                                    <label for="resultlimit"> Results per page:</label>
                                                    <form action="debtDetailController" method="GET">
                                                        <div style="min-width: 50px;" class="input-field col s1 ">
                                                            <select name="resultlimit" id="resultlimit" ng-model="resultlimit" ng-init="resultlimit = 5" onchange="this.form.submit()">
                                                                <option value="5" selected>5</option>
                                                                <option value="10">10</option>
                                                                <option value="20">20</option>
                                                                <option value="25">25</option>
                                                                <option value="50">50</option>
                                                                <option value="100">100</option>
                                                            </select>
                                                        </div>
                                                    </form>
                                                </div>-->

                    </div>

                    <div class="pagination" style="text-align: center; bottom: 5px;">
                        <c:forEach begin="${1}" end="${num}" var="i">
                            <a style="height: 35px; width: 32px;" class="${i==page?" active":""}"
                               href="debtDetailController?page=${i}">${i}</a>
                        </c:forEach>
                    </div>

                </div>


            </section>
        </main>


        <script src="js/debtBillDetail.js"></script>

    </body>

</html>