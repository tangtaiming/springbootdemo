package com.example.demo.orm;

import javax.persistence.*;

/**
 * @auther ttm
 * @date 2017/11/22
 */
@Entity
@Table(name = "tomtop_shipping_template")
public class TomtopShippingTemplate {

    @Id
    @GeneratedValue
    private Integer id;
    @Column(name = "stemp_id")
    private Integer stempId;
    @Column(name = "temp_name")
    private String tempName;
    @Column(name = "warehouse_id")
    private Integer warehouseId;
    @Column(name = "warehouse_name")
    private String warehouseName;
    @Column(name = "website_id")
    private Integer websiteId;
    @Deprecated
    @Column(name = "special")
    private Boolean special;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStempId() {
        return stempId;
    }

    public void setStempId(Integer stempId) {
        this.stempId = stempId;
    }

    public String getTempName() {
        return tempName;
    }

    public void setTempName(String tempName) {
        this.tempName = tempName;
    }

    public Integer getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public Boolean getSpecial() {
        return special;
    }

    public void setSpecial(Boolean special) {
        this.special = special;
    }

    public Integer getWebsiteId() {
        return websiteId;
    }

    public void setWebsiteId(Integer websiteId) {
        this.websiteId = websiteId;
    }
}
