package com.example.demo.orm.sale.joybuy;

/**
 * joybuy 类别
 * <p>@Author tangtaiming</p>
 * <p>@Date 2020/3/6</p>
 * <p>@Version 1.0</p>
 **/
public class JoybuyGoogleCategory {

    private Integer id;

    /**
     * 类别id
     */
    private Integer categoryId;

    private Integer parentId;

    private String categoryName;

    /**
     * 父类别名称
     */
    private String parentName;

    /**
     * 路径
     */
    private String categoryPath;

    /**
     * 是否启用: 1 启用 / 0 禁止
     */
    private Integer status;

    /**
     * 创建人
     */
    private Integer creator;

    /**
     * 创建时间
     */
    private String createDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getCreator() {
        return creator;
    }

    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getCategoryPath() {
        return categoryPath;
    }

    public void setCategoryPath(String categoryPath) {
        this.categoryPath = categoryPath;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
}
