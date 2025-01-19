/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.DAOUser;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;
import utils.Validate;

/**
 *
 * @author kienb
 */
public class UpdateProfileController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User u = (User) session.getAttribute("userLogin");
        int id = u.getId();
        DAOUser userDAO = new DAOUser();
        User user = userDAO.findByID(id);
        request.setAttribute("user", user);
        request.getRequestDispatcher("profileUser.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User u = (User) session.getAttribute("userLogin");
        int id = u.getId();
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String dob = request.getParameter("dob");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");

        User user = new User();
        user.setId(id);
        user.setFirstName(firstname);
        user.setAddress(address);
        user.setLastName(lastname);
        user.setPhoneNumber(phone);
        user.setDateOfBirth(dob);

        DAOUser userDAO = new DAOUser();
        int update = userDAO.updateProfile(user);
        User userUpdate = userDAO.findByID(id);
        if(update != -1){
            request.setAttribute("user", userUpdate);
            request.setAttribute("noti", "success");
            request.getRequestDispatcher("profileUser.jsp").forward(request, response);
        }else{
            request.setAttribute("noti", "fail");
            request.setAttribute("user", userUpdate);
            request.getRequestDispatcher("profileUser.jsp").forward(request, response);
        }
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
