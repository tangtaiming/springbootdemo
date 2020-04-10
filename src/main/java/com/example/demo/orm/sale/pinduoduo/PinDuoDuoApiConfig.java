package com.example.demo.orm.sale.pinduoduo;

import com.example.demo.http.ErpBaseHttpResponse;
import com.example.demo.http.api.response.ErpDaoResponse;

import java.util.List;

/**
 * <p>@Author tomtop 2159</p>
 * <p>@Date 2020/4/1</p>
 * <p>@Version 1.0</p>
 **/
public class PinDuoDuoApiConfig extends ErpDaoResponse {

    private Integer id;

    /**
     * 站点
     */
    private String website;

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
    private String storePassword;

    /**
     * 用户id
     */
    private Integer recorder;

    /**
     * login name 对应订单中的 input user字段
     */
    private String inputUser;

    /**
     * 销售员
     */
    private List<Integer> saleId;

    /**
     * 发货代码
     */
    private String shippingCode;

    /**
     * 收款类型
     */
    private String receiptType;

    /**
     * 付款方式
     */
    private String paymentMethod;

    /**
     * 收款邮箱
     */
    private String receivingEmail;

    /**
     * 币种
     */
    private String currency;

    private String accessToken;

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

    public String getStorePassword() {
        return storePassword;
    }

    public void setStorePassword(String storePassword) {
        this.storePassword = storePassword;
    }

    public Integer getRecorder() {
        return recorder;
    }

    public void setRecorder(Integer recorder) {
        this.recorder = recorder;
    }

    public String getInputUser() {
        return inputUser;
    }

    public void setInputUser(String inputUser) {
        this.inputUser = inputUser;
    }

    public List<Integer> getSaleId() {
        return saleId;
    }

    public void setSaleId(List<Integer> saleId) {
        this.saleId = saleId;
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

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
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

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
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

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

}
