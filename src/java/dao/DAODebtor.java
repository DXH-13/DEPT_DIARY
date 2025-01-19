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
import model.Debtor;
import utils.DBContext;

/**
 *
 * @author yuh
 */
public class DAODebtor {

    static DBContext db;

    public DAODebtor() {
        db = DBContext.getInstance();
    }

    public Vector<Debtor> getAll(String sql) {
        Vector<Debtor> vector = new Vector<Debtor>();
        try {
            Statement state = db.getConnection().createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("ID");
                String avatar = rs.getString("Avatar");
                String fullName = rs.getString("FullName");
                String phoneNumber = rs.getString("PhoneNumber");
                String email = rs.getString("Email");
                String address = rs.getString("Address");
                int amount = rs.getInt("Amount");
                int temp = rs.getInt("isDelete");
                boolean isDelete = (temp == 1 ? true : false);
                String createdAt = rs.getString("CreatedAt");
                int createdBy = rs.getInt("CreatedBy");
                String updatedAt = rs.getString("UpdatedAt");
                String deletedAt = rs.getString("DeletedAt");
                String deletedBy = rs.getString("DeletedBy");
                Debtor pro = new Debtor(id, avatar, fullName,
                        phoneNumber, email, address, amount, isDelete, createdAt, createdBy,
                        updatedAt, deletedAt, deletedBy);
                vector.add(pro);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAODebtor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vector;
    }

    public Vector<Debtor> getAllDebtor(int id) {
        String sql = "select * from Debtor where  isDelete = 0 and CreatedBy =" + id;
        return getAll(sql);
    }

    public List<Debtor> searchDebtor(String name, String address, String phoneNumber, String email, int amountFrom, int amountTo) {
        String sql = "select * from Debtor where  isDelete = 0 ";
        if (name != null && !name.isEmpty()) {
            sql += " AND FullName LIKE '%" + name + "%'";
        }
        if (address != null && !address.isEmpty()) {
            sql += " AND Address LIKE '%" + address + "%'";
        }
        if (phoneNumber != null && !phoneNumber.isEmpty()) {
            sql += " AND PhoneNumber LIKE '%" + phoneNumber + "%'";
        }
        if (email != null && !email.isEmpty()) {
            sql += " AND Email LIKE '%" + email + "%'";
        }
        if (amountFrom >= 0 && amountTo >= 0 && amountFrom <= amountTo) {
            sql += " AND Amount BETWEEN " + amountFrom + " AND " + amountTo;
        }
        return getAll(sql);
    }

    public List<Debtor> getListByPage(List<Debtor> list, int start, int end) {
        ArrayList<Debtor> arr = new ArrayList<>();
        for (int i = start; i < end; i++) {
            arr.add(list.get(i));
        }
        return arr;
    }

    public boolean addProfileOfDebtor(String avatar, String name, String phoneNumber, String email, String address, int createdBy) {
        String sql = "INSERT INTO Debtor (Avatar, FullName, PhoneNumber, Email, Address,amount, isDelete, CreatedAt,CreatedBy)\n"
                + "VALUES\n"
                + "(?, ?, ?, ?, ?,0, 0, CURRENT_TIMESTAMP,?)";
        try {
            PreparedStatement ptm = db.getConnection().prepareStatement(sql);
            ptm.setString(1, avatar);
            ptm.setString(2, name);
            ptm.setString(3, phoneNumber);
            ptm.setString(4, email);
            ptm.setString(5, address);
            ptm.setInt(6, createdBy);
            int result = ptm.executeUpdate();
            return result > 0;
        } catch (SQLException ex) {
            Logger.getLogger(DAODebtor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public Debtor findByID(int id) {
        String sql = "SELECT * FROM Debtor where ID = ?";
        try {
            PreparedStatement ptm = db.getConnection().prepareStatement(sql);
            ptm.setInt(1, id);
            ResultSet rs = ptm.executeQuery();
            if (rs.next()) {
                Debtor d = new Debtor();
                d.setId(rs.getInt("ID"));
                d.setAvatar(rs.getString("Avatar"));
                d.setFullName(rs.getString("FullName"));
                d.setPhoneNumber(rs.getString("PhoneNumber"));
                d.setEmail(rs.getString("Email"));
                d.setAddress(rs.getString("Address"));
                d.setAmount(rs.getInt("Amount"));
                d.setCreatedBy(rs.getInt("CreatedBy"));
                d.setCreatedAt(rs.getString("CreatedAt"));
                return d;
            }
        } catch (Exception ex) {
            Logger.getLogger(DAODebtor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean updateProfile(String avatar, String name, String phoneNumber, String email, String address, int id) {
        String sql = "UPDATE Debtor\n"
                + "SET FullName   = ?\n"
                + "  , Avatar = ?\n"
                + "  , PhoneNumber = ?\n"
                + "  , Address     = ?\n"
                + "  , Email     = ?\n"
                + "  , UpdatedAt   = CURRENT_TIMESTAMP\n"
                + "WHERE ID = ?";
        try {
            PreparedStatement ptm = db.getConnection().prepareStatement(sql);
            ptm.setString(1, name);
            ptm.setString(2, avatar);
            ptm.setString(3, phoneNumber);
            ptm.setString(4, address);
            ptm.setString(5, email);
            ptm.setInt(6, id);
            int result = ptm.executeUpdate();
            return result > 0;
        } catch (SQLException ex) {
            Logger.getLogger(DAODebtor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static void main(String[] args) {
        DAODebtor dao = new DAODebtor();
        int id=34;
        String name = "";
        String address = "";
        String phoneNumber = "";
        String email = "";
        int amountFrom = 0;
        int amountTo = 1000;
        Debtor d = dao.findByID(id);
        System.out.println(d);
        System.out.println(d.getCreatedBy());

    }
}
