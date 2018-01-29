package com.example.demo.orm;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.Date;
import java.util.List;

/**
 * @auther ttm
 * @date 2017/11/23
 */
@Document
public class TomtopOrderList {

    @Id
    private Integer id;
    private String email;		// 顾客email
    private Integer storageId;
    private Integer shippingMethodId;
    private String shippingMethodMethod;
    private double shippingPrice;
    private double orderSubtotal;
    private double extra;
    private double grandTotal;
    private Integer status;
    private String paymentMethod;
    private String currency;
    private Date createdate;
    private Date paymentdate;
    private String origin;
    private Integer websiteId;
    private String memberEmail;
    private String message;
    private Integer show;
    private String ip;
    private OrderAddress address;

    private List<AddressItem> addressItem;
    private List<OrderDetail> details;
    private List<OrderStatus> historyStatus;
    private String transactionId; // 交易号
    private String creceiveraccount; // 收款帐号
    private String cordernumber; // 订单号
    private String idType; // 证件类型
    private String customerId; // 身份证
    private String sepNo; // 头程号
    private String cvhost;
    private String buyerid; // 买家Id
    private String receiveridcard; // 收获人身份证
    private String customerservice; // 客服帐号,录入人
    private String remark;
    private String payerName; // 付人姓名
    private Double platformamount; // 平台收入
    private Double clearanceamount; // 报关价格
    private String shopName;
    private String shopKeeper;
    private String shopTelephone;
    private String shopAddress;
    private Integer shopId;
    private Double taxFee; // 进口税费总和taxFee
    private Integer orderLevel;
    private String address2; // 临时添加 不需要进行保存
    private String ccompany; // 收货人公司名
    private String prefixes; // 临时添加 不需要进行保存
    private List<OrderDiscountList> orderDiscountList;
    private String employeeName;
    private String jobNumber;
    private String tag;		//订单类型
    private Double codCost;	//货到付款手续费
    private Integer memberstatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getStorageId() {
        return storageId;
    }

    public void setStorageId(Integer storageId) {
        this.storageId = storageId;
    }

    public Integer getShippingMethodId() {
        return shippingMethodId;
    }

    public void setShippingMethodId(Integer shippingMethodId) {
        this.shippingMethodId = shippingMethodId;
    }

    public String getShippingMethodMethod() {
        return shippingMethodMethod;
    }

    public void setShippingMethodMethod(String shippingMethodMethod) {
        this.shippingMethodMethod = shippingMethodMethod;
    }

    public double getShippingPrice() {
        return shippingPrice;
    }

    public void setShippingPrice(double shippingPrice) {
        this.shippingPrice = shippingPrice;
    }

    public double getOrderSubtotal() {
        return orderSubtotal;
    }

    public void setOrderSubtotal(double orderSubtotal) {
        this.orderSubtotal = orderSubtotal;
    }

    public double getExtra() {
        return extra;
    }

    public void setExtra(double extra) {
        this.extra = extra;
    }

    public double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(double grandTotal) {
        this.grandTotal = grandTotal;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Date getPaymentdate() {
        return paymentdate;
    }

    public void setPaymentdate(Date paymentdate) {
        this.paymentdate = paymentdate;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public Integer getWebsiteId() {
        return websiteId;
    }

    public void setWebsiteId(Integer websiteId) {
        this.websiteId = websiteId;
    }

    public String getMemberEmail() {
        return memberEmail;
    }

    public void setMemberEmail(String memberEmail) {
        this.memberEmail = memberEmail;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getShow() {
        return show;
    }

    public void setShow(Integer show) {
        this.show = show;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public OrderAddress getAddress() {
        return address;
    }

    public void setAddress(OrderAddress address) {
        this.address = address;
    }

    public List<AddressItem> getAddressItem() {
        return addressItem;
    }

    public void setAddressItem(List<AddressItem> addressItem) {
        this.addressItem = addressItem;
    }

    public List<OrderDetail> getDetails() {
        return details;
    }

    public void setDetails(List<OrderDetail> details) {
        this.details = details;
    }

    public List<OrderStatus> getHistoryStatus() {
        return historyStatus;
    }

    public void setHistoryStatus(List<OrderStatus> historyStatus) {
        this.historyStatus = historyStatus;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getCreceiveraccount() {
        return creceiveraccount;
    }

    public void setCreceiveraccount(String creceiveraccount) {
        this.creceiveraccount = creceiveraccount;
    }

    public String getCordernumber() {
        return cordernumber;
    }

    public void setCordernumber(String cordernumber) {
        this.cordernumber = cordernumber;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getSepNo() {
        return sepNo;
    }

    public void setSepNo(String sepNo) {
        this.sepNo = sepNo;
    }

    public String getCvhost() {
        return cvhost;
    }

    public void setCvhost(String cvhost) {
        this.cvhost = cvhost;
    }

    public String getBuyerid() {
        return buyerid;
    }

    public void setBuyerid(String buyerid) {
        this.buyerid = buyerid;
    }

    public String getReceiveridcard() {
        return receiveridcard;
    }

    public void setReceiveridcard(String receiveridcard) {
        this.receiveridcard = receiveridcard;
    }

    public String getCustomerservice() {
        return customerservice;
    }

    public void setCustomerservice(String customerservice) {
        this.customerservice = customerservice;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getPayerName() {
        return payerName;
    }

    public void setPayerName(String payerName) {
        this.payerName = payerName;
    }

    public Double getPlatformamount() {
        return platformamount;
    }

    public void setPlatformamount(Double platformamount) {
        this.platformamount = platformamount;
    }

    public Double getClearanceamount() {
        return clearanceamount;
    }

    public void setClearanceamount(Double clearanceamount) {
        this.clearanceamount = clearanceamount;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopKeeper() {
        return shopKeeper;
    }

    public void setShopKeeper(String shopKeeper) {
        this.shopKeeper = shopKeeper;
    }

    public String getShopTelephone() {
        return shopTelephone;
    }

    public void setShopTelephone(String shopTelephone) {
        this.shopTelephone = shopTelephone;
    }

    public String getShopAddress() {
        return shopAddress;
    }

    public void setShopAddress(String shopAddress) {
        this.shopAddress = shopAddress;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public Double getTaxFee() {
        return taxFee;
    }

    public void setTaxFee(Double taxFee) {
        this.taxFee = taxFee;
    }

    public Integer getOrderLevel() {
        return orderLevel;
    }

    public void setOrderLevel(Integer orderLevel) {
        this.orderLevel = orderLevel;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCcompany() {
        return ccompany;
    }

    public void setCcompany(String ccompany) {
        this.ccompany = ccompany;
    }

    public String getPrefixes() {
        return prefixes;
    }

    public void setPrefixes(String prefixes) {
        this.prefixes = prefixes;
    }

    public List<OrderDiscountList> getOrderDiscountList() {
        return orderDiscountList;
    }

    public void setOrderDiscountList(List<OrderDiscountList> orderDiscountList) {
        this.orderDiscountList = orderDiscountList;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(String jobNumber) {
        this.jobNumber = jobNumber;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Double getCodCost() {
        return codCost;
    }

    public void setCodCost(Double codCost) {
        this.codCost = codCost;
    }

	public Integer getMemberstatus() {
		return memberstatus;
	}

	public void setMemberstatus(Integer memberstatus) {
		this.memberstatus = memberstatus;
	}
}
