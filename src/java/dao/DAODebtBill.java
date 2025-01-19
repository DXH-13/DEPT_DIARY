/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DebtBill;
import utils.DBContext;

/**
 *
 * @author yuh
 */
public class DAODebtBill {

    DBContext db;

    public DAODebtBill() {
        db = DBContext.getInstance();
    }

    public Vector<DebtBill> getAll(String sql) {
        Vector<DebtBill> vector = new Vector<DebtBill>();
        try {
            Statement state = db.getConnection().createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("ID");
                int idDebtor = rs.getInt("IDDebtor");
                int idTypeDebt = rs.getInt("IDTypeDebt");
                int amount = rs.getInt("Amount");
                String description = rs.getString("Description");
                String EvidenceImg1 = rs.getString("EvidenceImg1");
                String EvidenceImg2 = rs.getString("EvidenceImg2");
                String EvidenceImg3 = rs.getString("EvidenceImg3");
                String EvidenceImg4 = rs.getString("EvidenceImg4");
                String EvidenceImg5 = rs.getString("EvidenceImg5");
                String debtTerm = rs.getString("DebtTerm");
                int temp = rs.getInt("isDelete");
                boolean isDelete = (temp == 1 ? true : false);
                String createdAt = rs.getString("CreatedAt");
                String createdBy = rs.getString("CreatedBy");
                String updatedAt = rs.getString("UpdatedAt");
                String deletedAt = rs.getString("DeletedAt");
                String deletedBy = rs.getString("DeletedBy");

                DebtBill pro = new DebtBill(id, idDebtor, idTypeDebt, amount,
                        description, EvidenceImg1, EvidenceImg2, EvidenceImg3,
                        EvidenceImg4, EvidenceImg5, isDelete, createdAt,
                        createdBy, updatedAt, deletedAt, deletedBy);
                vector.add(pro);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAODebtor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vector;
    }

    public boolean insertDebtBill(int IDTypeDebt, int idDebtor, float amount, String note, List<String> imgPathsForDB, int createdBy) {
        // Assume db is a properly initialized database connection object
        String sql = "INSERT INTO DebtBill (IDDebtor, IDTypeDebt, Amount, Description, EvidenceImg1, EvidenceImg2, EvidenceImg3, EvidenceImg4, EvidenceImg5, CreatedAt, CreatedBy, isDelete) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, CURRENT_TIMESTAMP, ?, 0)";
        try ( PreparedStatement ps = db.getConnection().prepareStatement(sql)) {
            ps.setInt(1, idDebtor);
            ps.setInt(2, IDTypeDebt);
            ps.setFloat(3, amount);
            ps.setString(4, note);
            // Fill image paths or NULL
            for (int i = 0; i < 5; i++) {
                if (i < imgPathsForDB.size()) {
                    ps.setString(5 + i, imgPathsForDB.get(i));
                } else {
                    ps.setNull(5 + i, java.sql.Types.VARCHAR);
                }
            }
            ps.setInt(10, createdBy);
            int result = ps.executeUpdate();
            if (result > 0) {
                if (IDTypeDebt == 2 || IDTypeDebt == 3) {
                    String updateSql = "UPDATE Debtor SET Amount = Amount + ? WHERE ID = ?";
                    try ( PreparedStatement psUpdate = db.getConnection().prepareStatement(updateSql)) {
                        psUpdate.setFloat(1, amount);
                        psUpdate.setInt(2, idDebtor);
                        psUpdate.executeUpdate();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                } else if (IDTypeDebt == 1 || IDTypeDebt == 4) {
                    String updateSql = "UPDATE Debtor SET Amount = Amount - ? WHERE ID = ?";
                    try ( PreparedStatement psUpdate = db.getConnection().prepareStatement(updateSql)) {
                        psUpdate.setFloat(1, amount);
                        psUpdate.setInt(2, idDebtor);
                        psUpdate.executeUpdate();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    public List<DebtBill> getDebtbillByDebtorID(int debtorID) {
        List<DebtBill> list = new ArrayList<>();
        String sql = "SELECT * FROM DebtBill WHERE IDDebtor = ? ";
        try ( PreparedStatement st = db.getConnection().prepareStatement(sql)) {
            st.setInt(1, debtorID);
            try ( ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    DebtBill debtBill = new DebtBill(
                            rs.getInt("ID"),
                            rs.getInt("IDDebtor"),
                            rs.getInt("IDTypeDebt"),
                            rs.getInt("Amount"),
                            rs.getString("Description"),
                            rs.getString("EvidenceImg1"),
                            rs.getString("EvidenceImg2"),
                            rs.getString("EvidenceImg3"),
                            rs.getString("EvidenceImg4"),
                            rs.getString("EvidenceImg5"),
                            rs.getBoolean("isDelete"),
                            rs.getString("CreatedAt"),
                            rs.getString("CreatedBy"),
                            rs.getString("UpdatedAt"),
                            rs.getString("DeletedAt"),
                            rs.getString("DeletedBy")
                    );
                    list.add(debtBill);
                }
            }
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
            e.printStackTrace();
        }
        return list;
    }

    public List<DebtBill> getListByPage(List<DebtBill> list, int start, int end) {
        ArrayList<DebtBill> arr = new ArrayList<>();
        for (int i = start; i < end; i++) {
            arr.add(list.get(i));
        }
        return arr;
    }

    public List<DebtBill> getAllDebtBillByIDDebtor(int debtorID) {
        List<DebtBill> list = new ArrayList<>();
        String sql = "SELECT DebtBill.*, TypeDebt.Type "
                + "FROM DebtBill "
                + "INNER JOIN TypeDebt ON DebtBill.IDTypeDebt = TypeDebt.ID "
                + "WHERE DebtBill.IDDebtor = ?";
        try ( PreparedStatement st = db.getConnection().prepareStatement(sql)) {
            st.setInt(1, debtorID);
            try ( ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    DebtBill debtBill = new DebtBill(
                            rs.getInt("ID"),
                            rs.getInt("IDDebtor"),
                            rs.getInt("IDTypeDebt"),
                            rs.getInt("Amount"),
                            rs.getString("Description"),
                            rs.getString("EvidenceImg1"),
                            rs.getString("EvidenceImg2"),
                            rs.getString("EvidenceImg3"),
                            rs.getString("EvidenceImg4"),
                            rs.getString("EvidenceImg5"),
                            rs.getBoolean("isDelete"),
                            rs.getString("CreatedAt"),
                            rs.getString("CreatedBy"),
                            rs.getString("UpdatedAt"),
                            rs.getString("DeletedAt"),
                            rs.getString("DeletedBy"),
                            rs.getString("Type")
                    );
                    list.add(debtBill);
                }
            }
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
            e.printStackTrace();
        }
        return list;
    }

    public DebtBill findByID(int id) {
        String sql = "SELECT * FROM DebtBill where ID = ?";
        try {
            PreparedStatement ptm = db.getConnection().prepareStatement(sql);
            ptm.setInt(1, id);
            ResultSet rs = ptm.executeQuery();
            if (rs.next()) {
                DebtBill db = new DebtBill();
                db.setId(rs.getInt("ID"));
                db.setIdDebtor(rs.getInt("IDDebtor"));
                db.setIdTypeDebt(rs.getInt("IDTypeDebt"));
                db.setAmount(rs.getInt("Amount"));
                db.setDescription(rs.getString("Description"));
                db.setEvidenceImg1(rs.getString("EvidenceImg1"));
                db.setEvidenceImg2(rs.getString("EvidenceImg2"));
                db.setEvidenceImg3(rs.getString("EvidenceImg3"));
                db.setEvidenceImg4(rs.getString("EvidenceImg4"));
                db.setEvidenceImg5(rs.getString("EvidenceImg5"));
                db.setCreatedAt(rs.getString("CreatedAt"));
                return db;
            }
        } catch (Exception ex) {
            Logger.getLogger(DAOUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<DebtBill> searchDebtBill(int idDebtor, int id, String description, int typeDebt, int amountFrom, int amountTo) {
        String sql = "select * from DebtBill where isDelete = 0 AND IDDebtor = " + idDebtor;
        if (id >= 0) {
            sql += " AND ID = " + id;
        }
        if (description != null && !description.isEmpty()) {
            sql += " AND Description LIKE '%" + description + "%'";
        }
        if (typeDebt >=0 && typeDebt == 1 || typeDebt == 2 || typeDebt == 3 || typeDebt == 4) {
            sql += " AND IDTypeDebt = " + typeDebt;
        }
        if (amountFrom >= 0 && amountTo >= 0 && amountFrom <= amountTo) {
            sql += " AND Amount BETWEEN " + amountFrom + " AND " + amountTo;
        }
        return getAll(sql);
    }

    public static void main(String[] args) {
        DAODebtBill dao = new DAODebtBill();
        DebtBill db = dao.findByID(1);
            System.out.println(db);

    }

}
