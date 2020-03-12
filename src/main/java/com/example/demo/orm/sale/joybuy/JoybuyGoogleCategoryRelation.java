package com.example.demo.orm.sale.joybuy;

/**
 * joybuy google 类别关系
 * <p>@Author tangtaiming</p>
 * <p>@Date 2020/3/4</p>
 * <p>@Version 1.0</p>
 **/
public class JoybuyGoogleCategoryRelation {

    private Integer id;

    /**
     * erp类目
     */
    private String erpCategoryName;

    /**
     * erp类目 id
     */
    private Integer erpCategoryId;

    /**
     * erp 父类目
     */
    private String erpParentCategoryName;

    /**
     * erp 父类目id
     */
    private Integer erpParentCategoryId;

    /**
     * 平台类目名
     */
    private String categoryName;

    /**
     * 平台类目id
     */
    private Integer categoryId;

    /**
     * 平台类目路径
     */
    private String categoryPath;

    /**
     * 创建人
     */
    private Integer creator;

    /**
     * 创建时间
     */
    private String createDate;

    /**
     * 修改人/跟新人
     */
    private Integer updator;

    /**
     * 修改时间
     */
    private String updateDate;

    /**
     * 日志
     */
    private String sysRemark;

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the erpCategoryName
     */
    public String getErpCategoryName() {
        return erpCategoryName;
    }

    /**
     * @param erpCategoryName the erpCategoryName to set
     */
    public void setErpCategoryName(String erpCategoryName) {
        this.erpCategoryName = erpCategoryName;
    }

    /**
     * @return the erpCategoryId
     */
    public Integer getErpCategoryId() {
        return erpCategoryId;
    }

    /**
     * @param erpCategoryId the erpCategoryId to set
     */
    public void setErpCategoryId(Integer erpCategoryId) {
        this.erpCategoryId = erpCategoryId;
    }

    /**
     * @return the erpParentCategoryName
     */
    public String getErpParentCategoryName() {
        return erpParentCategoryName;
    }

    /**
     * @param erpParentCategoryName the erpParentCategoryName to set
     */
    public void setErpParentCategoryName(String erpParentCategoryName) {
        this.erpParentCategoryName = erpParentCategoryName;
    }

    /**
     * @return the erpParentCategoryId
     */
    public Integer getErpParentCategoryId() {
        return erpParentCategoryId;
    }

    /**
     * @param erpParentCategoryId the erpParentCategoryId to set
     */
    public void setErpParentCategoryId(Integer erpParentCategoryId) {
        this.erpParentCategoryId = erpParentCategoryId;
    }

    /**
     * @return the categoryName
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * @param categoryName the categoryName to set
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    /**
     * @return the categoryId
     */
    public Integer getCategoryId() {
        return categoryId;
    }

    /**
     * @param categoryId the categoryId to set
     */
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * @return the categoryPath
     */
    public String getCategoryPath() {
        return categoryPath;
    }

    /**
     * @param categoryPath the categoryPath to set
     */
    public void setCategoryPath(String categoryPath) {
        this.categoryPath = categoryPath;
    }

    /**
     * @return the creator
     */
    public Integer getCreator() {
        return creator;
    }

    /**
     * @param creator the creator to set
     */
    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    /**
     * @return the createDate
     */
    public String getCreateDate() {
        return createDate;
    }

    /**
     * @param createDate the createDate to set
     */
    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    /**
     * @return the updator
     */
    public Integer getUpdator() {
        return updator;
    }

    /**
     * @param updator the updator to set
     */
    public void setUpdator(Integer updator) {
        this.updator = updator;
    }

    /**
     * @return the updateDate
     */
    public String getUpdateDate() {
        return updateDate;
    }

    /**
     * @param updateDate the updateDate to set
     */
    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * @return the sysRemark
     */
    public String getSysRemark() {
        return sysRemark;
    }

    /**
     * @param sysRemark the sysRemark to set
     */
    public void setSysRemark(String sysRemark) {
        this.sysRemark = sysRemark;
    }


}
