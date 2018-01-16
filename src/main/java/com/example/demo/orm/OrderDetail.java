package com.example.demo.orm;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * @auther ttm
 * @date 2017/11/23
 */
public class OrderDetail {

    private String title;
    private Integer orderId;
    private String listingId;
    private Integer qty;
    private Double price;
    private Double totalPrices;
    private String sku;
    private Date createdate;
    private Date expirationDate; 	// 到期时间

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getListingId() {
        return listingId;
    }

    public void setListingId(String listingId) {
        this.listingId = listingId;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getTotalPrices() {
        return totalPrices;
    }

    public void setTotalPrices(Double totalPrices) {
        this.totalPrices = totalPrices;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(Double originalPrice) {
        this.originalPrice = originalPrice;
    }

    private Double originalPrice;	// 商品原价

}
