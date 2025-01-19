/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Role;
import utils.DBContext;

/**
 *
 * @author yuh
 */
public class DAORole {
    
    private DBContext db;
    
    public DAORole(){
        db = DBContext.getInstance();
    }
    
      
    public List<Role> getAll() {
        String sql = "SELECT *\n"
                + "  FROM Role";
        try {
            List<Role> list = new ArrayList<>();
            PreparedStatement ptm = db.getConnection().prepareStatement(sql);
            ResultSet rs = ptm.executeQuery();
            while (rs.next()) {
                Role role = new Role();
                role.setId(rs.getInt(1));
                role.setPosition(rs.getString(2));
                list.add(role);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(DAORole.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static void main(String[] args) {

        DAORole daoRole = new DAORole();


    }
}
