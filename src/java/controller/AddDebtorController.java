/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.DAODebtor;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import java.io.File;
import model.User;
import utils.GetFileName;
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50 // 50MB
)
/**
 *
 * @author admin
 */
public class AddDebtorController extends HttpServlet {

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
            out.println("<title>Servlet AddDebtorController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddDebtorController at " + request.getContextPath() + "</h1>");
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
      request.getRequestDispatcher("addDebtor.jsp").forward(request, response);
      
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
        User u = (User) session.getAttribute("userLogin");
        Part avatarPart = request.getPart("avatar");
        String fullName = request.getParameter("fullName");
        String phoneNumber = request.getParameter("phoneNumber");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        DAODebtor daoDebtor = new DAODebtor();

        String fileName = GetFileName.extractFileName(avatarPart);
        if (!fileName.isEmpty()) { // Kiểm tra xem người dùng đã chọn ảnh hay không
            // Đường dẫn đến thư mục uploads
            String uploadPath = "C:/Users/yuh/Documents/GitHub/ISP392_DeptDiary/web/uploads";
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdirs(); // Tạo thư mục nếu chưa tồn tại
            }
            String avatarFilePath = uploadPath + File.separator + fileName;
            try {
                avatarPart.write(avatarFilePath);
            } catch (IOException e) {
                e.printStackTrace();
            }
            
            String impPath = "uploads/"+fileName;
            boolean added = daoDebtor.addProfileOfDebtor(impPath, fullName, phoneNumber, email, address, u.getId());
            if (added) {
                response.sendRedirect("diary?id="+u.getId()); 
            } else {
                request.getRequestDispatcher("addDebtor.jsp").forward(request, response);
            }
        } else { // Trường hợp người dùng không chọn ảnh
            String avatarFilePath = "assets/img/team/Blank-Avatar.png";
            boolean added = daoDebtor.addProfileOfDebtor(avatarFilePath, fullName, phoneNumber, email, address, u.getId());
            if (added) {
                response.sendRedirect("diary?id="+u.getId()); 
            } else {
                request.getRequestDispatcher("addDebtor.jsp").forward(request, response);
            }
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
