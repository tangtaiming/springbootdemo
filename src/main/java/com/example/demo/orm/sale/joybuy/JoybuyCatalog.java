package com.example.demo.orm.sale.joybuy;

/**
 * 商品类别
 * <p>@Author tangtaiming</p>
 * <p>@Date 2019-06-15</p>
 * <p>@Version 1.0</p>
 **/
public class JoybuyCatalog {

    private Long id;
    //类别名称
    private String name;
    //佣金比率
    private Double pcCommissionRatio;
    //商家编号
    private Long venderId;
    //父类别
    private Long parentId;
    //joybuy对应类别
    private Integer joybuyCatalogId;
    //状态
    private Integer status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPcCommissionRatio() {
        return pcCommissionRatio;
    }

    public void setPcCommissionRatio(Double pcCommissionRatio) {
        this.pcCommissionRatio = pcCommissionRatio;
    }

    public Long getVenderId() {
        return venderId;
    }

    public void setVenderId(Long venderId) {
        this.venderId = venderId;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Integer getJoybuyCatalogId() {
        return joybuyCatalogId;
    }

    public void setJoybuyCatalogId(Integer joybuyCatalogId) {
        this.joybuyCatalogId = joybuyCatalogId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
