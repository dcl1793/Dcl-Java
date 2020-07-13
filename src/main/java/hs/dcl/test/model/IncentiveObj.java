package hs.dcl.test.model;

import java.util.Date;

/**
 * 激励对象表
 * 
 * @author dacl
 * 
 * @date 2020-06-21
 */
public class IncentiveObj {
    /**
     * ID号
     */
    private Integer objectId;

    /**
     * 对象名称
     */
    private String objectName;

    /**
     * 手机号码
     */
    private String mobileTel;

    /**
     * 电子信箱
     */
    private String email;

    /**
     * 证件类型
     */
    private String creType;

    /**
     * 证件编号
     */
    private String creNo;

    /**
     * 员工号
     */
    private Integer employeeId;

    /**
     * 资产账户
     */
    private String fundAccount;

    /**
     * 股东账号
     */
    private String shaAccount;

    /**
     * 居民状态
     */
    private String residentStatus;

    /**
     * 账户状态
     */
    private String accountStatus;

    /**
     * 员工属性
     */
    private String employeeType;

    /**
     * 复核任务状态
     */
    private String auditStatus;

    /**
     * 分支机构
     */
    private Integer branchNo;

    /**
     * 机构名称
     */
    private String branchName;

    /**
     * 在线状态
     */
    private String onlineStatus;

    /**
     * 三分存管银行编号
     */
    private String depositoryBankNo;

    /**
     * 三方存管银行
     */
    private String depositoryBank;

    /**
     * 转托管状态
     */
    private String retrusteeStatus;

    /**
     * 禁止撤销指定
     */
    private String revokeStatus;

    /**
     * 禁止变更三方存管
     */
    private String changeableStatus;

    /**
     * 禁止交易标的外证券
     */
    private String dealBondStatus;

    /**
     * 组织ID
     */
    private String orgId;

    /**
     * 创建时间
     */
    private Date creaTime;

    /**
     * 更新时间
     */
    private Date updaTime;

    /**
     * 上次修改人的ID
     */
    private Integer lastModifier;

    /**
     * 创建人id
     */
    private Integer creatorId;

    public Integer getObjectId() {
        return objectId;
    }

    public void setObjectId(Integer objectId) {
        this.objectId = objectId;
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName == null ? null : objectName.trim();
    }

    public String getMobileTel() {
        return mobileTel;
    }

    public void setMobileTel(String mobileTel) {
        this.mobileTel = mobileTel == null ? null : mobileTel.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getCreType() {
        return creType;
    }

    public void setCreType(String creType) {
        this.creType = creType == null ? null : creType.trim();
    }

    public String getCreNo() {
        return creNo;
    }

    public void setCreNo(String creNo) {
        this.creNo = creNo == null ? null : creNo.trim();
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getFundAccount() {
        return fundAccount;
    }

    public void setFundAccount(String fundAccount) {
        this.fundAccount = fundAccount == null ? null : fundAccount.trim();
    }

    public String getShaAccount() {
        return shaAccount;
    }

    public void setShaAccount(String shaAccount) {
        this.shaAccount = shaAccount == null ? null : shaAccount.trim();
    }

    public String getResidentStatus() {
        return residentStatus;
    }

    public void setResidentStatus(String residentStatus) {
        this.residentStatus = residentStatus == null ? null : residentStatus.trim();
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus == null ? null : accountStatus.trim();
    }

    public String getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType == null ? null : employeeType.trim();
    }

    public String getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus == null ? null : auditStatus.trim();
    }

    public Integer getBranchNo() {
        return branchNo;
    }

    public void setBranchNo(Integer branchNo) {
        this.branchNo = branchNo;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName == null ? null : branchName.trim();
    }

    public String getOnlineStatus() {
        return onlineStatus;
    }

    public void setOnlineStatus(String onlineStatus) {
        this.onlineStatus = onlineStatus == null ? null : onlineStatus.trim();
    }

    public String getDepositoryBankNo() {
        return depositoryBankNo;
    }

    public void setDepositoryBankNo(String depositoryBankNo) {
        this.depositoryBankNo = depositoryBankNo == null ? null : depositoryBankNo.trim();
    }

    public String getDepositoryBank() {
        return depositoryBank;
    }

    public void setDepositoryBank(String depositoryBank) {
        this.depositoryBank = depositoryBank == null ? null : depositoryBank.trim();
    }

    public String getRetrusteeStatus() {
        return retrusteeStatus;
    }

    public void setRetrusteeStatus(String retrusteeStatus) {
        this.retrusteeStatus = retrusteeStatus == null ? null : retrusteeStatus.trim();
    }

    public String getRevokeStatus() {
        return revokeStatus;
    }

    public void setRevokeStatus(String revokeStatus) {
        this.revokeStatus = revokeStatus == null ? null : revokeStatus.trim();
    }

    public String getChangeableStatus() {
        return changeableStatus;
    }

    public void setChangeableStatus(String changeableStatus) {
        this.changeableStatus = changeableStatus == null ? null : changeableStatus.trim();
    }

    public String getDealBondStatus() {
        return dealBondStatus;
    }

    public void setDealBondStatus(String dealBondStatus) {
        this.dealBondStatus = dealBondStatus == null ? null : dealBondStatus.trim();
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId == null ? null : orgId.trim();
    }

    public Date getCreaTime() {
        return creaTime;
    }

    public void setCreaTime(Date creaTime) {
        this.creaTime = creaTime;
    }

    public Date getUpdaTime() {
        return updaTime;
    }

    public void setUpdaTime(Date updaTime) {
        this.updaTime = updaTime;
    }

    public Integer getLastModifier() {
        return lastModifier;
    }

    public void setLastModifier(Integer lastModifier) {
        this.lastModifier = lastModifier;
    }

    public Integer getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }
}