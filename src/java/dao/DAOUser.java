/*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;
import utils.DBContext;

/**
 *
 * @author yuh
 */
public class DAOUser {

    private DBContext db;

    public DAOUser() {
        db = DBContext.getInstance();
    }

    public Vector<User> getAll(String sql) {
        Vector<User> vector = new Vector<User>();
        try {
            Statement state = db.getConnection().createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("ID");
                int idRole = rs.getInt(2);
                String firstName = rs.getString(3);
                String lastName = rs.getString(4);
                String dateOfBirth = rs.getString(5);
                String userName = rs.getString(6);
                String passWord = rs.getString(7);
                String phoneNumber = rs.getString(8);
                String email = rs.getString(9);
                String address = rs.getString(10);
                int temp = rs.getInt(11);
                boolean isDelete = (temp == 1 ? true : false);
                String createdAt = rs.getString(12);
                String createdBy = rs.getString(13);
                String updatedAt = rs.getString(14);
                String deletedAt = rs.getString(15);
                String deletedBy = rs.getString(16);
                User pro = new User(id, idRole, firstName, lastName, dateOfBirth, userName,
                        passWord, phoneNumber, email, address, isDelete, createdAt, createdBy, updatedAt, deletedAt, deletedBy);
                vector.add(pro);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vector;
    }

    public User checkExistentUser(String userName, String passWord) {
        String query = "select * from UserInfor where UserName = ? and Password = ? ";
        try {
            PreparedStatement st = db.getConnection().prepareStatement(query);
            st.setString(1, userName);
            st.setString(2, passWord);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                User u = new User(
                        rs.getInt("ID"),
                        rs.getInt("IDRole"),
                        rs.getString("FirstName"),
                        rs.getString("LastName"),
                        rs.getString("DateOfBirth"),
                        rs.getString("UserName"),
                        rs.getString("PassWord"),
                        rs.getString("PhoneNumber"),
                        rs.getString("Email"),
                        rs.getString("Address"),
                        rs.getBoolean("isDelete"),
                        rs.getString("CreatedAt"),
                        rs.getString("CreatedBy"),
                        rs.getString("UpdatedAt"),
                        rs.getString("DeletedAt"),
                        rs.getString("DeletedBy")
                );
                return u;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public Vector<User> getAllUser() {
        String sql = "select * from UserInfor where IDRole=1 ";
        return getAll(sql);
    }

    public User findByID(int id) {
        String sql = "SELECT * FROM UserInfor where ID = ?";
        try {
            PreparedStatement ptm = db.getConnection().prepareStatement(sql);
            ptm.setInt(1, id);
            ResultSet rs = ptm.executeQuery();
            if (rs.next()) {
                User u = new User();
                u.setId(rs.getInt(1));
                u.setIdRole(rs.getInt(2));
                u.setFirstName(rs.getString(3));
                u.setLastName(rs.getString(4));
                u.setDateOfBirth(rs.getString(5));
                u.setUserName(rs.getString(6));
                u.setPassWord(rs.getString(7));
                u.setPhoneNumber(rs.getString(8));
                u.setEmail(rs.getString(9));
                u.setAddress(rs.getString(10));
                return u;
            }
        } catch (Exception ex) {
            Logger.getLogger(DAOUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int editProfileOfUser(User user) {
        String sql = "UPDATE UserInfor\n"
                + "SET FirstName   = ?\n"
                + "  , LastName    = ?\n"
                + "  , DateOfBirth = ?\n"
                + "  , PhoneNumber = ?\n"
                + "  , Email       = ?\n"
                + "  , Address     = ?\n"
                + "  , IDRole     = ?\n"
                + "  , UpdatedAt   = CURRENT_TIMESTAMP\n"
                + "WHERE ID = ?";

        try {
            PreparedStatement ptm = db.getConnection().prepareStatement(sql);
            ptm.setString(1, user.getFirstName());
            ptm.setString(2, user.getLastName());
            ptm.setString(3, user.getDateOfBirth());
            ptm.setString(4, user.getPhoneNumber());
            ptm.setString(5, user.getEmail());
            ptm.setString(6, user.getAddress());
            ptm.setInt(7, user.getIdRole());
            ptm.setInt(8, user.getId());
            return ptm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public int updateProfile(User user) {
        String sql = "UPDATE UserInfor\n"
                + "SET FirstName   = ?\n"
                + "  , LastName    = ?\n"
                + "  , DateOfBirth = ?\n"
                + "  , PhoneNumber = ?\n"
                + "  , Address     = ?\n"
                + "  , UpdatedAt   = CURRENT_TIMESTAMP\n"
                + "WHERE ID = ?";

        try {
            PreparedStatement ptm = db.getConnection().prepareStatement(sql);
            ptm.setString(1, user.getFirstName());
            ptm.setString(2, user.getLastName());
            ptm.setString(3, user.getDateOfBirth());
            ptm.setString(4, user.getPhoneNumber());
            ptm.setString(5, user.getAddress());
            ptm.setInt(6, user.getId());
            return ptm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public int updatePassWord(User user) {
        String sql = "UPDATE UserInfor\n"
                + "SET Password    = ?\n"
                + "WHERE ID = ?";

        try {
            PreparedStatement ptm = db.getConnection().prepareStatement(sql);
            ptm.setString(1, user.getPassWord());
            ptm.setInt(2, user.getId());
            return ptm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public User findByUserName(String userName) {
        String query = "select * from UserInfor where UserName = ? ";
        try {
            PreparedStatement st = db.getConnection().prepareStatement(query);
            st.setString(1, userName);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                User u = new User(
                        rs.getInt("ID"),
                        rs.getInt("IDRole"),
                        rs.getString("FirstName"),
                        rs.getString("LastName"),
                        rs.getString("DateOfBirth"),
                        rs.getString("UserName"),
                        rs.getString("PassWord"),
                        rs.getString("PhoneNumber"),
                        rs.getString("Email"),
                        rs.getString("Address"),
                        rs.getBoolean("isDelete"),
                        rs.getString("CreatedAt"),
                        rs.getString("CreatedBy"),
                        rs.getString("UpdatedAt"),
                        rs.getString("DeletedAt"),
                        rs.getString("deletedBy")
                );
                return u;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public boolean insertUser(String username, String password, String email) {
        int defaultRoleId = 1; // Mặc định role ID cho 'Base User'
        String createdBy = "System"; // Mặc định người tạo là 'System'

        String sql = "INSERT INTO UserInfor (UserName, Password, Email, IDRole, isDelete, CreatedAt, CreatedBy) "
                + "VALUES (?, ?, ?, ?, ?, CURRENT_TIMESTAMP, ?)";
        try ( PreparedStatement ps = db.getConnection().prepareStatement(sql)) {
            ps.setString(1, username);
            ps.setString(2, password); // Nên mã hóa mật khẩu trước khi lưu
            ps.setString(3, email);
            ps.setInt(4, defaultRoleId); // Sử dụng role ID mặc định
            ps.setBoolean(5, false);

            ps.setString(6, createdBy); // Đặt người tạo là 'System'
            int result = ps.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<User> getListByPage(List<User> list, int start, int end) {
        ArrayList<User> arr = new ArrayList<>();
        for (int i = start; i < end; i++) {
            arr.add(list.get(i));
        }
        return arr;
    }

    public boolean isEmailExists(String email) {
        String sql = "SELECT COUNT(*) FROM UserInfor WHERE Email = ?";
        try ( PreparedStatement ps = db.getConnection().prepareStatement(sql)) {
            ps.setString(1, email);
            try ( ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean isUserNameExists(String userName) {
        String sql = "SELECT COUNT(*) FROM UserInfor WHERE UserName = ?";
        try ( PreparedStatement ps = db.getConnection().prepareStatement(sql)) {
            ps.setString(1, userName);
            try ( ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public int deleteUser(User user) {
        String sql = "UPDATE UserInfor\n"
                + "SET isDelete = ?\n"
                + "WHERE ID = ?";
        try {
            PreparedStatement ptm = db.getConnection().prepareStatement(sql);
            ptm.setInt(1, 1);
            ptm.setInt(2, user.getId());
            return ptm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public int activateUser(User user) {
        String sql = "UPDATE UserInfor\n"
                + "SET isDelete = ?\n"
                + "WHERE ID = ?";
        try {
            PreparedStatement ptm = db.getConnection().prepareStatement(sql);
            ptm.setInt(1, 0);
            ptm.setInt(2, user.getId());
            return ptm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public List<User> searchUser(int id, String firstName, String lastName, String dob, String address, String phoneNumber, String email, int activation) {
        String sql = "select * from UserInfor where  1=1 ";
        if (id >= 0) {
            sql += " AND ID = " + id;
        }
        if (firstName != null && !firstName.isEmpty()) {
            sql += " AND FirstName LIKE '%" + firstName + "%'";
        }
        if (lastName != null && !lastName.isEmpty()) {
            sql += " AND LastName LIKE '%" + lastName + "%'";
        }
        if (dob != null && !dob.isEmpty()) {
            sql += " AND DateOfBirth LIKE '%" + dob + "%'";
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
        if (activation >= 0) {
            sql += " AND isDelete = " + activation;
        }
        return getAll(sql);
    }

    public static void main(String[] args) {
        User user = new User();

        DAOUser dao = new DAOUser();

        dao.updateProfile(user);

    }

}

