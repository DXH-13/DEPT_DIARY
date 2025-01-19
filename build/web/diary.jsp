<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>DebtDiary</title>
        <link href="assets/img/logo.png" rel="icon">
        <link href="https://cdn.lineicons.com/4.0/lineicons.css" rel="stylesheet" />
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
        <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <link rel="stylesheet" href="css/diary.css">
    </head>

    <body>
        
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
        
        
        <div class="wrapper">
            <aside id="sidebar">
                <div class="d-flex">
                    <button class="toggle-btn" type="button">
                        <img src="assets/img/logo.png" style="max-width: 30px; display: block;">
                    </button>
                    <div class="sidebar-logo">
                        <a href="#">DebtDiary</a>
                    </div>
                </div>
                <ul class="sidebar-nav">

                    <li class="sidebar-item">
                        <c:choose>
                            <c:when test="${sessionScope.userLogin.idRole eq 2}">
                                <a href="admin" class="sidebar-link">
                                    <i class="lni lni-agenda"></i>
                                    <span>Home</span>
                                </a>
                            </c:when>
                            <c:when test="${sessionScope.userLogin.idRole eq 1}">
                                <a href="welcome?id=${sessionScope.userLogin.id}" class="sidebar-link">
                                    <i class="lni lni-agenda"></i>
                                    <span>Home</span>
                                </a>
                            </c:when>
                        </c:choose>
                    </li>
                    <li class="sidebar-item">
                        <a href="#" class="sidebar-link collapsed has-dropdown" data-bs-toggle="collapse"
                           data-bs-target="#auth" aria-expanded="false" aria-controls="auth">
                            <i class="lni lni-protection"></i>
                            <span>Auth</span>
                        </a>
                        <ul id="auth" class="sidebar-dropdown list-unstyled collapse" data-bs-parent="#sidebar">
                            <li class="sidebar-item">
                                <a href="login" class="sidebar-link">Login</a>
                            </li>
                            <li class="sidebar-item">
                                <a href="signup" class="sidebar-link">Register</a>
                            </li>
                        </ul>
                    </li>

                    <!--                    <li class="sidebar-item">
                                            <a href="feedback" class="sidebar-link">
                                                <i class="lni lni-popup"></i>
                                                <span>Feed Back</span>
                                            </a>
                                        </li>-->
                    <c:set var="sizeFeed" value="${sizeFeed}" />

                    <li class="sidebar-item">
                        <c:choose>
                            <c:when test="${sizeFeed == 1}">
                                <c:set var="hrefValue" value="updatefeedback" />
                            </c:when>
                            <c:otherwise>
                                <c:set var="hrefValue" value="feedback" />
                            </c:otherwise>
                        </c:choose>
                        <a href="${hrefValue}" class="sidebar-link">
                            <i class="lni lni-popup"></i>
                            <span>Feed Back</span>
                        </a>
                    </li>

                </ul>
                <div class="sidebar-footer">
                    <a href="logout" class="sidebar-link">
                        <i class="lni lni-exit"></i>
                        <span>Logout</span>
                    </a>
                </div>
            </aside>
            <div class="main p-3">
                <div class="text-center">

                    <div style="display: inline-block; font-size: 30px; font-weight: bold;">
                        List of Debtors
                    </div>


                    <div class="top-bar">

                        <a href="addDebtor" class="link-wrapper" >
                            <img class="plus-bt" src="assets/img/plus.png"><strong>Add Debtor</strong>
                        </a>
                        <!--SEARCH BAR-->

                        <div class="container">
                            <form action="diary" method="post">
                                <div class="search-wrapper">
                                    <div class="search-container">
                                        <a href="diary?id=${sessionScope.userLogin.id}"><img src="assets/img/reload.png" style="max-width: 30px; margin-right: 7px; border-radius: 5px;"></a>
                                        <input type="text" class="search" placeholder="Name" name="name">  
                                        <input type="text" class="search" placeholder="Address" name="address">
                                        <input type="text" class="search" placeholder="Phone Number" name="phoneNumber">
                                        <input type="text" class="search" placeholder="Email" name="email">
                                        <input type="text" class="search" placeholder="Amount from" name="amountFrom" style="width: 150px">
                                        <input type="text" class="search" placeholder="Amount to" name="amountTo" style="width: 150px">
                                        <button type="submit" class="search-button"><img src="assets/img/search-debtor.png" style="max-width: 25px; "></button>

                                    </div>
                                </div>
                            </form>
                        </div>

                    </div>

                    <!-- CARDS -->
                    <div class="profile-container">
                        <table>
                            <tr>
                                <c:forEach var="debtor" items="${data}" varStatus="loop">
                                    <td>
                                        <div class="profile-card">
                                            <div class="dropdown">
                                                <img class="more-img" src="assets/img/more.png" alt="Dropdown">
                                                <div class="dropdown-content">
                                                    <a href="bill?id=${debtor.id}">Add bill</a>
                                                    <a href="updateDebtor?id=${debtor.id}">Information</a>
                                                </div>
                                            </div>
                                            <img src="${debtor.avatar}" alt="Avatar" class="profile-image">
                                            <div class="profile-name">${debtor.fullName}</div>
                                            <div class="total-debt">Total debt</div>
                                            <div class="money" id="debtorAmount" style="color: ${debtor.amount < 0 ? 'red' : 'inherit'}">${debtor.amount}</div> 
                                            <a href="debtDetailController?id=${debtor.id}" class="view-detail">View detail</a>  
                                        </div>
                                    </td>
                                    <c:if test="${loop.index % 4 == 3}">
                                    </tr><tr>
                                    </c:if>
                                </c:forEach>
                            </tr>
                        </table>
                    </div>


                </div>
                <!-- End CARDS -->

                <!--  PAGINATINON -->
                <div class="paggi">
                    <div class="flex items-center justify-between   px-2 py-1 sm:px-3 sm:py-2" style="border-radius: 5px;">
                        <div class="hidden sm:flex sm:flex-1 sm:items-center sm:justify-between ">
                            <div class="bg-white" style="margin-right: 410px; padding: 8px; border-radius: 5px;">
                                <p class="text-sm text-gray-700">
                                    Showing
                                    <span class="font-medium">${startPage}</span>
                                    to
                                    <span class="font-medium">${endPage}</span>
                                    of
                                    <span class="font-medium">${listSize}</span>
                                    debtors
                                </p>
                            </div>

                            <div class="pagination " > 
                                <c:forEach begin="${1}" end="${num}" var="i">
                                    <a style="height: 35px; width: 32px;" class="${i==page?"active":""}" href="diary?page=${i}">${i}</a>
                                </c:forEach>
                            </div>

                        </div>
                    </div>
                </div>


                <!-- End PAGINATINON -->                




            </div>
        </div>


        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
        crossorigin="anonymous"></script>
        <script src="js/diary.js"></script>
        <script type="module" src="node_modules/@material-tailwind/html@latest/scripts/popover.js"></script>

        <!-- from cdn -->
        <script type="module" src="https://unpkg.com/@material-tailwind/html@latest/scripts/popover.js"></script>
        <script>
            $(document).ready(function () {
                $(".money").each(function () {
                    var text = $(this).text();
                    console.log(text)
                    text = (+text).toLocaleString() + "VND";
                    $(this).text(text);
                });
            });
        </script>
    </body>

</html>