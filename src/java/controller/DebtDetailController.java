/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.DAODebtBill;
import dao.DAODebtor;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import model.DebtBill;
import model.Debtor;

/**
 *
 * @author namte
 */
public class DebtDetailController extends HttpServlet {

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
            out.println("<title>Servlet DebtDetailController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DebtDetailController at " + request.getContextPath() + "</h1>");
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
        int numPerPage;
        numPerPage = 10; // giá trị mặc định

        HttpSession session = request.getSession();
//        int idDebtor = Integer.parseInt(request.getParameter("id"));
        int idDebtor;
        String idStr = request.getParameter("id");
        if (idStr != null) {
            idDebtor = Integer.parseInt(idStr);
        } else {
            idDebtor = (Integer) session.getAttribute("debtorId");
        }
        if (session.getAttribute("debtorId") == null) {
            session.setAttribute("debtorId", idDebtor);
        }
        DAODebtor daoDebtor = new DAODebtor();
        Debtor d = daoDebtor.findByID(idDebtor);
        session.setAttribute("Debtor", d);
        DAODebtBill dao = new DAODebtBill();
        List<DebtBill> list = dao.getDebtbillByDebtorID(idDebtor);
        int listSize = list.size();
        int page;
        int num = (listSize % numPerPage == 0 ? (listSize / numPerPage) : ((listSize / numPerPage)) + 1);
        String xpage = request.getParameter("page");
        if (xpage == null) {
            page = 1;
        } else {
            page = Integer.parseInt(xpage);
        }
        int start, end;
        start = (page - 1) * numPerPage;
        end = Math.min(page * numPerPage, listSize);
        List<DebtBill> data = dao.getListByPage(list, start, end);
        int startPage = start + 1;

        request.setAttribute("data", data);
        request.setAttribute("startPage", startPage);
        request.setAttribute("endPage", end);
        request.setAttribute("num", num);
        request.setAttribute("listSize", listSize);
        request.setAttribute("listSizePerPage", data.size());
        request.setAttribute("numperpage", numPerPage);
        request.setAttribute("debtor", d);
        request.getRequestDispatcher("debtBillDetail.jsp").forward(request, response);
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
        String idParam = request.getParameter("idDebtBill");
        int id;

        if (idParam != null && !idParam.isEmpty()) {
            id = Integer.parseInt(idParam);
        } else {
            id = -1;
        }
        String description = request.getParameter("description");
        int idDebtor = Integer.parseInt(request.getParameter("idDebtor"));

        String typeParam = request.getParameter("type");

        int type;
        if (typeParam != null && !typeParam.isEmpty()) {
            type = Integer.parseInt(typeParam);
        } else {
            type = -1;
        }

        String fromAmountParam = request.getParameter("fromAmount");
        String toAmountParam = request.getParameter("toAmount");

        int fromAmount;
        int toAmount;

        if (fromAmountParam != null && !fromAmountParam.isEmpty()) {
            fromAmount = Integer.parseInt(fromAmountParam);
        } else {
            fromAmount = Integer.MIN_VALUE;
        }

        if (toAmountParam != null && !toAmountParam.isEmpty()) {
            toAmount = Integer.parseInt(toAmountParam);
        } else {
            toAmount = Integer.MAX_VALUE;
        }
        DAODebtor daoDebtor = new DAODebtor();
        Debtor d = daoDebtor.findByID(idDebtor);
        DAODebtBill dao = new DAODebtBill();
        List<DebtBill> list = dao.searchDebtBill(idDebtor, id, description, type, fromAmount, toAmount);
        int listSize = list.size();
        int numPerPage = 10;
        int page;
        int num = (listSize % numPerPage == 0 ? (listSize / numPerPage) : ((listSize / numPerPage)) + 1);
        String xpage = request.getParameter("page");
        if (xpage == null) {
            page = 1;
        } else {
            page = Integer.parseInt(xpage);
        }
        int start, end;
        start = (page - 1) * numPerPage;
        end = Math.min(page * numPerPage, listSize);
        List<DebtBill> data = dao.getListByPage(list, start, end);
        int startPage = start + 1;

        request.setAttribute("data", data);
        request.setAttribute("startPage", startPage);
        request.setAttribute("endPage", end);
        request.setAttribute("num", num);
        request.setAttribute("listSize", listSize);
        request.setAttribute("listSizePerPage", data.size());
        request.setAttribute("numperpage", numPerPage);
        request.setAttribute("debtor", d);
        request.getRequestDispatcher("debtBillDetail.jsp").forward(request, response);

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
