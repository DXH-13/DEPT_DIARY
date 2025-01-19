package controller;

import dao.DAOUser;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import model.User;
import utils.SHA256;

public class ResetPasswordController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher("resetNewPass.jsp").forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        DAOUser userDao = new DAOUser();  
        HttpSession session = request.getSession();
        User userForgotPass = (User)session.getAttribute("userForgotPass");
        int userId = userForgotPass.getId();

        String oldPassword = request.getParameter("oldPassword");
        String newPassword = request.getParameter("newPassword");
        String retypePassword = request.getParameter("retypePassword"); 
        
        if (newPassword.isEmpty() || retypePassword.isEmpty()) {
            String noti = "New password and re-type password must not be blank";
            request.setAttribute("noti", noti);
            response.sendRedirect("reset_password?id=" + userId);
        } else if (newPassword.equals(oldPassword)) {
            String noti = "New password must not be the same as old password";
            request.setAttribute("noti", noti);
            response.sendRedirect("reset_password?id=" + userId);
        } else if (!newPassword.equals(retypePassword)) {
            String noti = "Re-type password must be the same as new password";
            request.setAttribute("noti", noti);
            response.sendRedirect("reset_password?id=" + userId);
        } else {
            User user = userDao.findByID(userId);
            String encryptedPassword = SHA256.hashPassword(newPassword);
            user.setPassWord(encryptedPassword);
            
            int updatePassword = userDao.updatePassWord(user);
            if (updatePassword == 1) {
                String noti = "Update password success";
                request.setAttribute("noti", noti);
                response.sendRedirect("login.jsp");
            } else {
                String noti = "Update password fail.";
                request.setAttribute("noti", noti);
                response.sendRedirect("reset_password?id=" + userId);
            }
        }       
    }
}





















