package com.example.demo.orm.sale.ozon;

import java.util.List;

/**
 * walmart库存推送设置
 * <p>@Author tangtaiming</p>
 * <p>@Date 2019-08-09</p>
 * <p>@Version 1.0</p>
 **/
public class WalmartQtySetting {

    //站点
    private Integer websiteId;
    //仓库
    private List<Integer> stockIds;
    //特殊属性
    private List<String> specialAttributes;
    //最长边
    private Double longSide;
    //产品总重量
    private Double totalWeight;
    //状态
    private Integer status;
    //日志
    private String sysRemark;
    //创建人
    private Integer creator;
    //创建时间
    private String createDate;

    public Integer getWebsiteId() {
        return websiteId;
    }

    public void setWebsiteId(Integer websiteId) {
        this.websiteId = websiteId;
    }

    public List<Integer> getStockIds() {
        return stockIds;
    }

    public void setStockIds(List<Integer> stockIds) {
        this.stockIds = stockIds;
    }

    public List<String> getSpecialAttributes() {
        return specialAttributes;
    }

    public void setSpecialAttributes(List<String> specialAttributes) {
        this.specialAttributes = specialAttributes;
    }

    public Double getLongSide() {
        return longSide;
    }

    public void setLongSide(Double longSide) {
        this.longSide = longSide;
    }

    public Double getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(Double totalWeight) {
        this.totalWeight = totalWeight;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getSysRemark() {
        return sysRemark;
    }

    public void setSysRemark(String sysRemark) {
        this.sysRemark = sysRemark;
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
}
