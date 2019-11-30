package com.example.demo.orm.sale.ozon;

/**
 * ozon订单确认记录
 */
public class OzonOrderConfirm {

    private Integer id;
    private Long erpOrderId;
    private Long ozonId;
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

    public Long getErpOrderId() {
        return erpOrderId;
    }

    public void setErpOrderId(Long erpOrderId) {
        this.erpOrderId = erpOrderId;
    }

    public Long getOzonId() {
        return ozonId;
    }

    public void setOzonId(Long ozonId) {
        this.ozonId = ozonId;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
}
