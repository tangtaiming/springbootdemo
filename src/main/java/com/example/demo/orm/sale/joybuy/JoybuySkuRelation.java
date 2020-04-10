package com.example.demo.orm.sale.joybuy;

/**
 * joybuy sku对应关系
 * <p>@Author tangtaiming</p>
 * <p>@Date 2020/3/17</p>
 * <p>@Version 1.0</p>
 **/
public class JoybuySkuRelation {

    private Integer id;

    /**
     * 商品对应sku 标识或者 scu标识
     */
    private String productTag;

    /**
     * joybuy 标识
     */
    private Long skuId;

    /**
     * 虚拟sku
     */
    private String imitationSku;

    /**
     * 店铺ID
     */
    private String shopId;

    /**
     * 创建人
     */
    private Integer creator;

    /**
     * 创建时间
     */
    private String createDate;

    /**
     * 日志
     */
    private String sysRemark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductTag() {
        return productTag;
    }

    public void setProductTag(String productTag) {
        this.productTag = productTag;
    }

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    public String getImitationSku() {
        return imitationSku;
    }

    public void setImitationSku(String imitationSku) {
        this.imitationSku = imitationSku;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
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

    public String getSysRemark() {
        return sysRemark;
    }

    public void setSysRemark(String sysRemark) {
        this.sysRemark = sysRemark;
    }
}

