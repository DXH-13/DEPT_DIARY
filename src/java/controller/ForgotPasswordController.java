package controller;

import utils.SendMail;
import dao.DAOUser;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;

public class ForgotPasswordController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher("forgotPassword.jsp").forward(request, response);
    }

//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        HttpSession session = request.getSession();
//        String token = SendMail.generateRandomToken();
//        String user = request.getParameter("username");
//        String captchaInput = request.getParameter("captchaInput");
//        String captchaGen = (String) session.getAttribute("captchaText");
//
//        DAOUser daoUser = new DAOUser();
//        User u = daoUser.findByUserName(user);
//        session.setAttribute("userForgotPass", u);
//        
//        if ("true".equals(request.getParameter("refreshCaptcha"))) {
//            response.sendRedirect("forgotPassword.jsp");
//            return;
//        }
//
//        if (u == null) {
//            //khong thay
//            request.setAttribute("error", "Username not found!!!");
//            request.getRequestDispatcher("forgotPassword.jsp").forward(request, response);
//        } else {
//            //tim thay
//            if (captchaInput != null && captchaInput.equals(captchaGen)) {
//                response.sendRedirect("token.jsp");
//                try {
//                    SendMail.sendMail(u.getEmail(), token);
//                    session.setAttribute("generatedToken", token);
//                } catch (Exception ex) {
//                    Logger.getLogger(ForgotPasswordController.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            } else {
//                request.setAttribute("error", "Captcha invalid!!!");
//                request.getRequestDispatcher("forgotPassword.jsp").forward(request, response);
//            }
//
//        }
//    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        String token = SendMail.generateRandomToken();
        String user = request.getParameter("username");
        String captchaInput = request.getParameter("captchaInput");
        String captchaGen = (String) session.getAttribute("captchaText");

        DAOUser daoUser = new DAOUser();
        User u = daoUser.findByUserName(user);
        session.setAttribute("userForgotPass", u);

        // Kiểm tra xem captcha có đúng không trước khi kiểm tra tên người dùng
        if (captchaInput == null || !captchaInput.equals(captchaGen)) {
            request.setAttribute("error", "Captcha invalid!!!");
            request.getRequestDispatcher("forgotPassword.jsp").forward(request, response);
            return;
        }

        if ("true".equals(request.getParameter("refreshCaptcha"))) {
            response.sendRedirect("forgotPassword.jsp");
            return;
        }

        if (u == null) {
            //khong thay
            request.setAttribute("error", "Username not found!!!");
            request.getRequestDispatcher("forgotPassword.jsp").forward(request, response);
        } else {
            //tim thay
            response.sendRedirect("token.jsp");
            try {
                SendMail.sendMail(u.getEmail(), token);
                session.setAttribute("generatedToken", token);
            } catch (Exception ex) {
                Logger.getLogger(ForgotPasswordController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}


