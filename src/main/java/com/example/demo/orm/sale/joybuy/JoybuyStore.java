package com.example.demo.orm.sale.joybuy;

/**
 * <p>@Author tangtaiming</p>
 * <p>@Date 2019-03-22</p>
 * <p>@Version 1.0</p>
 **/
public class JoybuyStore {

    /**
     * 仓ID
     */
    private Long id;

    /**
     * 配送中心Code
     */
    private Long dcCode;

    /**
     * 仓Code
     */
    private Long storeCode;

    /**
     * 仓名称
     */
    private String storeName;

    /**
     * 仓类型 1：自营 2：POP自建 3：POP租用
     */
    private Integer storeType;

    /**
     * 仓库状态 1:运营中 2:已停用 3:待审核 4:已拒绝
     */
    private Integer status;

    /**
     * joybuy 配置id
     */
    private Integer apiConfigId;

    /**
     * symbol
     */
    private String symbol;

    /**
     * 店铺id
     */
    private String storeId;

    /**
     * 创建时间
     */
    private String createDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDcCode() {
        return dcCode;
    }

    public void setDcCode(Long dcCode) {
        this.dcCode = dcCode;
    }

    public Long getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(Long storeCode) {
        this.storeCode = storeCode;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public Integer getStoreType() {
        return storeType;
    }

    public void setStoreType(Integer storeType) {
        this.storeType = storeType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getApiConfigId() {
        return apiConfigId;
    }

    public void setApiConfigId(Integer apiConfigId) {
        this.apiConfigId = apiConfigId;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

}
