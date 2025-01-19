/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.DAOUser;
import utils.SendMail;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import utils.SHA256;

/**
 *
 * @author yuh
 */
public class OTPController extends HttpServlet {

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
            out.println("<title>Servlet OTPController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet OTPController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("otp.jsp").forward(request, response);

    }

    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//        DAOUser daoUser = new DAOUser();
//        HttpSession session = request.getSession();
//        String emailSignUp = (String) session.getAttribute("emailSignUp");
//        String username = (String) session.getAttribute("username");
//        String password = (String) session.getAttribute("password");
//        String enteredToken = request.getParameter("enteredToken");
//
//        // Kiểm tra xem token đã được tạo và lưu trong phiên làm việc chưa
//        String generatedToken = (String) session.getAttribute("generatedToken");
//        // Nếu token không tồn tại trong phiên làm việc, hãy tạo một token mới
//        if (generatedToken == null) {
//            generatedToken = SendMail.generateRandomToken();
//            try {
//                SendMail.sendMail(emailSignUp, generatedToken);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            // Lưu trữ token được tạo trong phiên làm việc
//            session.setAttribute("generatedToken", generatedToken);
//        }
//        System.out.println("token input "+enteredToken);
//        System.out.println("token gen "+ generatedToken);
//        System.out.println("username "+ username);
//        System.out.println("password "+ password);
//        System.out.println("emailSignUp "+ emailSignUp);
//        
//        if (enteredToken != null && enteredToken.equals(generatedToken)) {
//            String encryptedPassword = SHA256.hashPassword(password);
//            daoUser.insertUser(username, encryptedPassword, emailSignUp);
//            response.sendRedirect("login.jsp");
//        }
//        else {
//            request.setAttribute("error", "Token không hợp lệ!!!");
//            request.getRequestDispatcher("otp.jsp").forward(request, response);
//        }
//    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

    DAOUser daoUser = new DAOUser();
    HttpSession session = request.getSession();
    String emailSignUp = (String) session.getAttribute("emailSignUp");
    String username = (String) session.getAttribute("username");
    String password = (String) session.getAttribute("password");
    String enteredToken = request.getParameter("enteredToken");

    // Kiểm tra xem token đã được tạo và lưu trong phiên làm việc chưa
    String generatedToken = (String) session.getAttribute("generatedToken");
    // Nếu token không tồn tại trong phiên làm việc, hãy tạo một token mới
    if (generatedToken == null) {
        generatedToken = SendMail.generateRandomToken();
        try {
            SendMail.sendMail(emailSignUp, generatedToken);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Lưu trữ token được tạo trong phiên làm việc
        session.setAttribute("generatedToken", generatedToken);
    }
    System.out.println("token input " + enteredToken);
    System.out.println("token gen " + generatedToken);
    System.out.println("username " + username);
    System.out.println("password " + password);
    System.out.println("emailSignUp " + emailSignUp);

    // Check if enteredToken is empty before comparing
    if (enteredToken != null && !enteredToken.isEmpty() && enteredToken.equals(generatedToken)) {
        String encryptedPassword = SHA256.hashPassword(password);
        daoUser.insertUser(username, encryptedPassword, emailSignUp);
        request.setAttribute("notif", "success");
        request.getRequestDispatcher("login.jsp").forward(request, response);
    } else {
        // Only set the error attribute if the enteredToken is not empty
        if (enteredToken != null && !enteredToken.isEmpty()) {
            request.setAttribute("error", "Token incorrect");
        }
        request.getRequestDispatcher("otp.jsp").forward(request, response);
    }
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
