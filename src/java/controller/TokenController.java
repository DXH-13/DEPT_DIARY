package controller;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class TokenController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher("token.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        String generatedToken = (String) session.getAttribute("generatedToken");
        String enteredToken = (String) request.getParameter("enteredToken");

        if (enteredToken != null && enteredToken.equals(generatedToken)) {
            response.sendRedirect("reset_password");
            session.removeAttribute("generatedToken");
        } else {
            request.setAttribute("error", "Token invalid!!!");
            request.getRequestDispatcher("token.jsp").forward(request, response);
        }
    }
    
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//    response.setContentType("text/html;charset=UTF-8");
//
//    HttpSession session = request.getSession();
//    String generatedToken = (String) session.getAttribute("generatedToken");
//    String enteredToken = (String) request.getParameter("enteredToken");
//
//    if (generatedToken != null) {
//        // Lần thứ nhất: kiểm tra token và chuyển hướng hoặc thông báo lỗi
//        if (enteredToken != null && enteredToken.equals(generatedToken)) {
//            response.sendRedirect("resetPassword.jsp");
//        } else {
//            session.removeAttribute("generatedToken");
//            request.setAttribute("noti", "Incorrect Token");
//            request.getRequestDispatcher("token.jsp").forward(request, response);
//        }
//    } else {
//        // Lần thứ hai: kiểm tra token và xử lý tương ứng
//        if (enteredToken != null && enteredToken.equals(generatedToken)) {
//            response.sendRedirect("resetPassword.jsp");
//        } else {
//            request.setAttribute("error", "Token invalid!!!");
//            request.getRequestDispatcher("token.jsp").forward(request, response);
//        }
//    }
//}


}
