/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Feedback;
import model.User;
import utils.DBContext;

/**
 *
 * @author yuh
 */
public class DAOFeedback {

    static DBContext db;

    public DAOFeedback() {
        db = DBContext.getInstance();
    }

    public Vector<Feedback> getAll(String sql) {
        Vector<Feedback> vector = new Vector<Feedback>();
        try {
            Statement state = db.getConnection().createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("ID");
                int rate = rs.getInt("Rate");
                String comment = rs.getString("Comment");
                int temp = rs.getInt("isDelete");
                boolean isDelete = (temp == 1 ? true : false);
                String createdAt = rs.getString("CreatedAt");
                int createdBy = rs.getInt("CreatedBy");
                String updatedAt = rs.getString("UpdatedAt");
                String deletedAt = rs.getString("DeletedAt");
                String deletedBy = rs.getString("DeletedBy");
                Feedback pro = new Feedback(id, rate, comment, isDelete, createdAt,
                        createdBy, updatedAt, deletedAt, deletedBy);
                vector.add(pro);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOFeedback.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vector;
    }

    public Vector<Feedback> getAll2(String sql) {
        Vector<Feedback> vector = new Vector<Feedback>();
        try {
            Statement state = db.getConnection().createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("ID");
                int rate = rs.getInt("Rate");
                String comment = rs.getString("Comment");
                int temp = rs.getInt("isDelete");
                boolean isDelete = (temp == 1 ? true : false);
                String createdAt = rs.getString("CreatedAt");
                int createdBy = rs.getInt("CreatedBy");
                String updatedAt = rs.getString("UpdatedAt");
                String deletedAt = rs.getString("DeletedAt");
                String deletedBy = rs.getString("DeletedBy");
                String name = rs.getString("FirstName");
                String userName = rs.getString("UserName");
                Feedback pro = new Feedback(id, rate, comment, isDelete, createdAt,
                        createdBy, updatedAt, deletedAt, deletedBy, userName, name);
                vector.add(pro);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOFeedback.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vector;
    }

    public Vector<Feedback> getAllFeedback() {
        String sql = "select * from FeedBack where isDelete=0 ";
        return getAll(sql);
    }

    public boolean addFeedback(int rate, String comment, int createdBy) {
        String sql = "INSERT INTO FeedBack(Rate,Comment, isDelete, CreatedAt, CreatedBy)\n"
                + "VALUES\n"
                + "(?, ?, 0, CURRENT_TIMESTAMP,?)";
        try {
            PreparedStatement ptm = db.getConnection().prepareStatement(sql);
            ptm.setInt(1, rate);
            ptm.setString(2, comment);
            ptm.setInt(3, createdBy);
            int result = ptm.executeUpdate();
            return result > 0;
        } catch (SQLException ex) {
            Logger.getLogger(DAOFeedback.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean updateFeedback(int rate, String comment, int createdBy) {
        String sql = "UPDATE FeedBack\n"
                + "SET Rate = ?,\n"
                + "Comment = ?\n"
                + "WHERE CreatedBy = ?";
        try {
            PreparedStatement ptm = db.getConnection().prepareStatement(sql);
            ptm.setInt(1, rate);
            ptm.setString(2, comment);
            ptm.setInt(3, createdBy);
            int result = ptm.executeUpdate();
            return result > 0;
        } catch (SQLException ex) {
            Logger.getLogger(DAOFeedback.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public List<Feedback> getListByPage(List<Feedback> list, int start, int end) {
        ArrayList<Feedback> arr = new ArrayList<>();
        for (int i = start; i < end; i++) {
            arr.add(list.get(i));
        }
        return arr;
    }

    public Vector<Feedback> getAllFeedbackJoin() {
        Vector<Feedback> vector = new Vector<Feedback>();
        String sql = "SELECT FeedBack.*, UserInfor.UserName , UserInfor.FirstName \n"
                + "FROM FeedBack INNER JOIN UserInfor ON FeedBack.CreatedBy = UserInfor.ID";
        try {
            Statement state = db.getConnection().createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("ID");
                int rate = rs.getInt("Rate");
                String comment = rs.getString("Comment");
                int temp = rs.getInt("isDelete");
                boolean isDelete = (temp == 1 ? true : false);
                String createdAt = rs.getString("CreatedAt");
                int createdBy = rs.getInt("CreatedBy");
                String updatedAt = rs.getString("UpdatedAt");
                String deletedAt = rs.getString("DeletedAt");
                String deletedBy = rs.getString("DeletedBy");
                String name = rs.getString("FirstName");
                String userName = rs.getString("UserName");
                Feedback pro = new Feedback(id, rate, comment, isDelete, createdAt,
                        createdBy, updatedAt, deletedAt, deletedBy, userName, name);
                vector.add(pro);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOFeedback.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vector;
    }

    public List<Feedback> searchFeedback(int id, int rate, String userName, String name, String comment) {
        String sql = "SELECT FeedBack.*, UserInfor.UserName , UserInfor.FirstName \n"
                + "FROM FeedBack INNER JOIN UserInfor ON FeedBack.CreatedBy = UserInfor.ID where  1=1 ";
        if (id >= 0) {
            sql += " AND Feedback.ID = " + id;
        }
        if (userName != null && !userName.isEmpty()) {
            sql += " AND UserInfor.UserName LIKE '%" + userName + "%'";
        }
        if (name != null && !name.isEmpty()) {
            sql += " AND UserInfor.FirstName LIKE '%" + name + "%'";
        }
        if (rate >= 0) {
            sql += " AND Feedback.Rate = " + rate;
        }
        if (comment != null && !comment.isEmpty()) {
            sql += " AND Feedback.Comment LIKE '%" + comment + "%'";
        }
        return getAll2(sql);
    }

    public Vector<Feedback> getAllFeedbackByCreatedBy(int id) {
        String sql = "select * from FeedBack where isDelete=0 AND CreatedBy = " + id;
        return getAll(sql);
    }

    public Feedback getFeedbackByCreatedBy(int idUser) {
        String sql = "select * from FeedBack where isDelete=0 AND CreatedBy = ?";
        try {
            PreparedStatement st = db.getConnection().prepareStatement(sql);
            st.setInt(1, idUser);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Feedback fb = new Feedback(
                        rs.getInt("ID"),
                        rs.getInt("Rate"),
                        rs.getString("Comment"),
                        rs.getBoolean("isDelete"),
                        rs.getString("CreatedAt"),
                        rs.getInt("CreatedBy"),
                        rs.getString("UpdatedAt"),
                        rs.getString("DeletedAt"),
                        rs.getString("DeletedBy")
                );
                return fb;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public static void main(String[] args) {

//        String sql = "SELECT FeedBack.*, UserInfor.UserName , UserInfor.FirstName \n"
//                + "FROM FeedBack INNER JOIN UserInfor ON FeedBack.CreatedBy = UserInfor.ID where  1=1 ";
//
//        int id = 1;
//        int rate = -1;
//        String name = "";
//        String userName = "";
//        String comment = "";
//
//        if (id >= 0) {
//            sql += " AND Feedback.ID = " + id;
//        }
//        if (userName != null && !userName.isEmpty()) {
//            sql += " AND UserInfor.UserName LIKE '%" + userName + "%'";
//        }
//        if (name != null && !name.isEmpty()) {
//            sql += " AND UserInfor.FirstName LIKE '%" + name + "%'";
//        }
//        if (rate >= 0) {
//            sql += " AND Feedback.Rate = " + rate;
//        }
//        if (comment != null && !comment.isEmpty()) {
//            sql += " AND Feedback.Comment LIKE '%" + comment + "%'";
//        }
//        System.out.println(sql);
        DAOFeedback dao = new DAOFeedback();
        int rate = 5;
        int id = 5;
        String comment = "bad";

//        boolean add = dao.addFeedback(rate, comment, rate);
        boolean update = dao.updateFeedback(rate, comment, id);
//        }
        if (update) {
            System.out.println("ss");
        } else {
            System.out.println("ff");
        }
    }

}
