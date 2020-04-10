package com.example.demo.orm.sale.joc;

import java.util.List;

/**
 * <p>@Author tangtaiming</p>
 * <p>@Date 2020/3/23</p>
 * <p>@Version 1.0</p>
 **/
public class JocApiConfig {

    private Integer id;

    /**
     * Symbol
     */
    private String symbol;

    /**
     * 店铺名
     */
    private String storeName;

    /**
     * 店铺ID
     */
    private String storeId;

    /**
     * 用户id
     */
    private Integer recorder;

    /**
     * login name 对应订单中的 input user字段
     */
    private String inputUser;

    /**
     * 发货代码
     */
    private String shippingCode;

    /**
     * 收款类型
     */
    private String receiptType;

    /**
     * 收款邮箱
     */
    private String receivingEmail;

    /**
     * 币种
     */
    private String currency;

    /**
     * 应用key
     */
    private String applicationKey;

    /**
     * 应用秘钥
     */
    private String applicationPass;

    private String accessToken;

    private String refreshToken;

    /**
     * Token失效时间
     */
    private String tokenFailureTime;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 国家
     */
    private String country;

    /**
     * 仓库
     */
    private List<Integer> warehouses;

    /**
     * 创建人
     */
    private Integer creator;

    /**
     * 创建时间
     */
    private String createDate;

    /**
     * 修改时间
     */
    private String updateDate;

    /**
     * 日志
     */
    private String sysRemark;

    /**
     * 销售员
     */
    private List<Integer> saleId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public Integer getRecorder() {
        return recorder;
    }

    public void setRecorder(Integer recorder) {
        this.recorder = recorder;
    }

    public String getShippingCode() {
        return shippingCode;
    }

    public void setShippingCode(String shippingCode) {
        this.shippingCode = shippingCode;
    }

    public String getReceiptType() {
        return receiptType;
    }

    public void setReceiptType(String receiptType) {
        this.receiptType = receiptType;
    }

    public String getReceivingEmail() {
        return receivingEmail;
    }

    public void setReceivingEmail(String receivingEmail) {
        this.receivingEmail = receivingEmail;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getApplicationKey() {
        return applicationKey;
    }

    public void setApplicationKey(String applicationKey) {
        this.applicationKey = applicationKey;
    }

    public String getApplicationPass() {
        return applicationPass;
    }

    public void setApplicationPass(String applicationPass) {
        this.applicationPass = applicationPass;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getTokenFailureTime() {
        return tokenFailureTime;
    }

    public void setTokenFailureTime(String tokenFailureTime) {
        this.tokenFailureTime = tokenFailureTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Integer> getWarehouses() {
        return warehouses;
    }

    public void setWarehouses(List<Integer> warehouses) {
        this.warehouses = warehouses;
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

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getSysRemark() {
        return sysRemark;
    }

    public void setSysRemark(String sysRemark) {
        this.sysRemark = sysRemark;
    }

    public List<Integer> getSaleId() {
        return saleId;
    }

    public void setSaleId(List<Integer> saleId) {
        this.saleId = saleId;
    }

    public String getInputUser() {
        return inputUser;
    }

    public void setInputUser(String inputUser) {
        this.inputUser = inputUser;
    }
}
