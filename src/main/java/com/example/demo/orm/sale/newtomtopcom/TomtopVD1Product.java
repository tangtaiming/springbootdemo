package com.example.demo.orm.sale.newtomtopcom;

/**
 * VD1商品记录
 * <p>@Author tangtaiming</p>
 * <p>@Date 2019-02-18</p>
 * <p>@Version 1.0</p>
 **/
public class TomtopVD1Product {

    private Long id;

    /**
     * sku
     */
    private String sku;

    /**
     * 站点
     */
    private Integer websiteId;

    /**
     * 是否删除
     */
    private Integer delete;

    /**
     * 创建时间
     */
    private String createDate;

    /**
     * 创建人
     */
    private Integer creator;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Integer getWebsiteId() {
        return websiteId;
    }

    public void setWebsiteId(Integer websiteId) {
        this.websiteId = websiteId;
    }

    public Integer getDelete() {
        return delete;
    }

    public void setDelete(Integer delete) {
        this.delete = delete;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public Integer getCreator() {
        return creator;
    }

    public void setCreator(Integer creator) {
        this.creator = creator;
    }
}
