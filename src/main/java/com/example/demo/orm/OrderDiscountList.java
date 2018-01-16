package com.example.demo.orm;

/**
 * @auther ttm
 * @date 2017/11/23
 */
public class OrderDiscountList {

    private String code;

    private String currency;

    private Double discount;

    private String orderNumber;

    private String type;

    private Integer website;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getWebsite() {
        return website;
    }

    public void setWebsite(Integer website) {
        this.website = website;
    }
}
