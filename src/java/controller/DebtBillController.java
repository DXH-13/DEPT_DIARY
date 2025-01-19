/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.DAODebtBill;
import dao.DAODebtor;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpSession;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import model.Debtor;
import model.User;

/**
 *
 * @author ussat
 */
// Thêm annotation này ngay trước định nghĩa lớp của servlet
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
        maxFileSize = 1024 * 1024 * 10, // 10 MB
        maxRequestSize = 1024 * 1024 * 15 // 15 MB
)
public class DebtBillController extends HttpServlet {

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
            out.println("<title>Servlet DebtBillServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DebtBillServlet at " + request.getContextPath() + "</h1>");
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
        HttpSession session = request.getSession();
        User u = (User) session.getAttribute("userLogin");
        int idDebtor = Integer.parseInt(request.getParameter("id"));
        DAODebtor dao = new DAODebtor();
        Debtor d = dao.findByID(idDebtor);
        request.setAttribute("debtor", d);
        if (d.getCreatedBy() == u.getId()) {
            request.getRequestDispatcher("debtbill.jsp").forward(request, response);
        } else {
            response.sendRedirect("wrongDebtorError.jsp");
        }
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
        // Lấy các giá trị cơ bản từ form
        int idDebtor = Integer.parseInt(request.getParameter("idDebtor"));
        String debtType = request.getParameter("debtType");
        int amount = Integer.parseInt(request.getParameter("amount").replace(",", ""));
        String note = request.getParameter("note");
//        String createdDate = request.getParameter("date");
//        String debtTerm = request.getParameter("debtTerm");
        HttpSession session = request.getSession();
        User u = (User) session.getAttribute("userLogin");
        //id debtor

        DAODebtBill DAOdebtBill = new DAODebtBill();
        // Xử lý giá trị tuỳ chọn cho debit và credit
        int IDTypeDebt = 0;
        if ("debit".equals(debtType)) {
            IDTypeDebt = Integer.parseInt(request.getParameter("debitOption"));
        } else if ("credit".equals(debtType)) {
            IDTypeDebt = Integer.parseInt(request.getParameter("creditOption"));
        }

        // Lấy tất cả các parts từ request
        Collection<Part> parts = request.getParts();

        // Đường dẫn lưu ảnh trong project
        String projectPath = "C:/Users/yuh/Documents/GitHub/ISP392_DeptDiary/web";
        String savePath = projectPath + File.separator + "uploads"; // Đường dẫn lưu ảnh

        File fileSaveDir = new File(savePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdirs(); // Tạo thư mục nếu chưa tồn tại
        }

        List<String> imgPathsForDB = new ArrayList<>();

        for (Part part : parts) {
            // Kiểm tra nếu phần này là một phần của trường 'images[]'
            if (part.getName().equals("images[]")) {
                String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();
                if (fileName != null && !fileName.isEmpty()) {
                    String filePath = savePath + File.separator + fileName;
                    part.write(filePath); // Lưu file
                    imgPathsForDB.add("uploads/" + fileName);
                }
            }
        }

        //Insert thông tin vào database
        boolean insertResult = DAOdebtBill.insertDebtBill(IDTypeDebt, idDebtor, amount, note, imgPathsForDB, u.getId());
        if (insertResult) {
            response.sendRedirect("diary"); // Redirect sau khi insert thành công

        } else {
            request.setAttribute("errorMessage", "Không thể chèn dữ liệu vào cơ sở dữ liệu.");
            request.getRequestDispatcher("/errorPage.jsp").forward(request, response);
        }
    }
}
