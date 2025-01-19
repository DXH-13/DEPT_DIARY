package model;

/**
 *
 * @author yuh
 */
public class DebtBill {

    private int id;
    private int idDebtor;
    private int idTypeDebt;
    private int amount;
    private String description;
    private String evidenceImg1;
    private String evidenceImg2;
    private String evidenceImg3;
    private String evidenceImg4;
    private String evidenceImg5;
    private boolean isDelete;
    private String createdAt;
    private String createdBy;
    private String updatedAt;
    private String deletedAt;
    private String deletedBy;
    private String type;

    public DebtBill() {
    }

    public DebtBill(int id, int idDebtor, int idTypeDebt, int amount, String description, String evidenceImg1, String evidenceImg2, String evidenceImg3, String evidenceImg4, String evidenceImg5, boolean isDelete, String createdAt, String createdBy, String updatedAt, String deletedAt, String deletedBy) {
        this.id = id;
        this.idDebtor = idDebtor;
        this.idTypeDebt = idTypeDebt;
        this.amount = amount;
        this.description = description;
        this.evidenceImg1 = evidenceImg1;
        this.evidenceImg2 = evidenceImg2;
        this.evidenceImg3 = evidenceImg3;
        this.evidenceImg4 = evidenceImg4;
        this.evidenceImg5 = evidenceImg5;
        this.isDelete = isDelete;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
        this.deletedBy = deletedBy;
    }
    
    

    public DebtBill(int id, int idDebtor, int idTypeDebt, int amount, String description, String evidenceImg1, String evidenceImg2, String evidenceImg3, String evidenceImg4, String evidenceImg5, boolean isDelete, String createdAt, String createdBy, String updatedAt, String deletedAt, String deletedBy, String type) {
        this.id = id;
        this.idDebtor = idDebtor;
        this.idTypeDebt = idTypeDebt;
        this.amount = amount;
        this.description = description;
        this.evidenceImg1 = evidenceImg1;
        this.evidenceImg2 = evidenceImg2;
        this.evidenceImg3 = evidenceImg3;
        this.evidenceImg4 = evidenceImg4;
        this.evidenceImg5 = evidenceImg5;
        this.isDelete = isDelete;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
        this.deletedBy = deletedBy;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdDebtor() {
        return idDebtor;
    }

    public void setIdDebtor(int idDebtor) {
        this.idDebtor = idDebtor;
    }

    public int getIdTypeDebt() {
        return idTypeDebt;
    }

    public void setIdTypeDebt(int idTypeDebt) {
        this.idTypeDebt = idTypeDebt;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEvidenceImg1() {
        return evidenceImg1;
    }

    public void setEvidenceImg1(String evidenceImg1) {
        this.evidenceImg1 = evidenceImg1;
    }

    public String getEvidenceImg2() {
        return evidenceImg2;
    }

    public void setEvidenceImg2(String evidenceImg2) {
        this.evidenceImg2 = evidenceImg2;
    }

    public String getEvidenceImg3() {
        return evidenceImg3;
    }

    public void setEvidenceImg3(String evidenceImg3) {
        this.evidenceImg3 = evidenceImg3;
    }

    public String getEvidenceImg4() {
        return evidenceImg4;
    }

    public void setEvidenceImg4(String evidenceImg4) {
        this.evidenceImg4 = evidenceImg4;
    }

    public String getEvidenceImg5() {
        return evidenceImg5;
    }

    public void setEvidenceImg5(String evidenceImg5) {
        this.evidenceImg5 = evidenceImg5;
    }

    public boolean isIsDelete() {
        return isDelete;
    }

    public void setIsDelete(boolean isDelete) {
        this.isDelete = isDelete;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(String deletedAt) {
        this.deletedAt = deletedAt;
    }

    public String getDeletedBy() {
        return deletedBy;
    }

    public void setDeletedBy(String deletedBy) {
        this.deletedBy = deletedBy;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "DebtBill{" + "id=" + id + ", idDebtor=" + idDebtor + ", idTypeDebt=" + idTypeDebt + ", amount=" + amount + ", description=" + description + ", evidenceImg1=" + evidenceImg1 + ", evidenceImg2=" + evidenceImg2 + ", evidenceImg3=" + evidenceImg3 + ", evidenceImg4=" + evidenceImg4 + ", evidenceImg5=" + evidenceImg5 + ", isDelete=" + isDelete + ", createdAt=" + createdAt + ", createdBy=" + createdBy + ", updatedAt=" + updatedAt + ", deletedAt=" + deletedAt + ", deletedBy=" + deletedBy + ", type=" + type + '}';
    }

    
    
}