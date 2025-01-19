/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.DAOUser;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;
import utils.SHA256;

/**
 *
 * @author yuh
 */
public class AdminChangeUserPassController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AdminChangeUserPassController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AdminChangeUserPassController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DAOUser userDao = new DAOUser();
        int id = Integer.parseInt(request.getParameter("id"));
        User user = userDao.findByID(id);
        request.setAttribute("user", user);
        request.getRequestDispatcher("adminChangePassUser.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        DAOUser userDao = new DAOUser();

        int userId = Integer.parseInt(request.getParameter("id"));
        String oldPassword = request.getParameter("oldPassword");
        String newPassword = request.getParameter("newPassword");
        String retypePassword = request.getParameter("retypePassword");
        User user = userDao.findByID(userId);
        request.setAttribute("user", user);

        if (oldPassword.isEmpty()) {
            request.setAttribute("newPassword", newPassword);
            request.setAttribute("retypePassword", retypePassword);
            request.setAttribute("oldPassBlankError", "Old password must not be blank");
        }

        if (newPassword.isEmpty() ) {
            request.setAttribute("oldPassword", oldPassword);
            request.setAttribute("newPassBlankError", "New password must not be blank");
        }
        
        if (retypePassword.isEmpty() || retypePassword.isEmpty()) {
            request.setAttribute("oldPassword", oldPassword);
            request.setAttribute("newPassword", newPassword);
            request.setAttribute("retypePassBlankError", "Re-type password must not be blank");
        }

        if (!oldPassword.isEmpty() && !newPassword.isEmpty() && !retypePassword.isEmpty()) {
            if (!SHA256.hashPassword(oldPassword).equals(user.getPassWord())) {
                request.setAttribute("newPassword", newPassword);
                request.setAttribute("retypePassword", retypePassword);
                request.setAttribute("oldPassError", "Old password is incorrect. Please try again.");
            } else if (SHA256.hashPassword(newPassword).equals(oldPassword)) {
                request.setAttribute("oldPassword", oldPassword);
                request.setAttribute("newNotOldError", "New password must not be the same as old password");
            } else if (!newPassword.equals(retypePassword)) {
                request.setAttribute("oldPassword", oldPassword);
                request.setAttribute("newPassword", newPassword);
                request.setAttribute("retypePassError", "Re-type password must be the same as new password");
            } else {
                String encryptedPassword = SHA256.hashPassword(newPassword);
                user.setPassWord(encryptedPassword);
                int updatePassword = userDao.updatePassWord(user);
                if (updatePassword == 1) {
                    request.setAttribute("noti", "success");
                } else {
                    request.setAttribute("noti", "fail");
                }
            }
        }
        request.getRequestDispatcher("adminChangePassUser.jsp").forward(request, response);

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
