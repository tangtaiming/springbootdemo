package com.example.demo.orm.distribution;

import java.util.List;

/**
 * <p>@Author tangtaiming</p>
 * <p>@Date 2019-07-04</p>
 * <p>@Version 1.0</p>
 **/
public class CustomerInfo {

    private Integer id;
    private String name;
    private String password;
    private String address;
    private String contactType;
    private String contact;
    private String shippingType;
    private String token;
    private List<String> permissions;
    private String clientId;
    private String clientSecret;
    private Integer creator;
    private String createdDate;
    private String inputUser;
    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }
    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }
    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }
    /**
     * @return the contactType
     */
    public String getContactType() {
        return contactType;
    }
    /**
     * @param contactType the contactType to set
     */
    public void setContactType(String contactType) {
        this.contactType = contactType;
    }
    /**
     * @return the contact
     */
    public String getContact() {
        return contact;
    }
    /**
     * @param contact the contact to set
     */
    public void setContact(String contact) {
        this.contact = contact;
    }
    /**
     * @return the shippingType
     */
    public String getShippingType() {
        return shippingType;
    }
    /**
     * @param shippingType the shippingType to set
     */
    public void setShippingType(String shippingType) {
        this.shippingType = shippingType;
    }
    /**
     * @return the token
     */
    public String getToken() {
        return token;
    }
    /**
     * @param token the token to set
     */
    public void setToken(String token) {
        this.token = token;
    }
    /**
     * @return the creator
     */
    public Integer getCreator() {
        return creator;
    }
    /**
     * @param creator the creator to set
     */
    public void setCreator(Integer creator) {
        this.creator = creator;
    }
    /**
     * @return the createdDate
     */
    public String getCreatedDate() {
        return createdDate;
    }
    /**
     * @param createdDate the createdDate to set
     */
    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }
    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }
    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * @return the permissions
     */
    public List<String> getPermissions() {
        return permissions;
    }
    /**
     * @param permissions the permissions to set
     */
    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
    }
    /**
     * @return the clientId
     */
    public String getClientId() {
        return clientId;
    }
    /**
     * @param clientId the clientId to set
     */
    public void setClientId(String clientId) {
        this.clientId = clientId;
    }
    /**
     * @return the clientSecret
     */
    public String getClientSecret() {
        return clientSecret;
    }
    /**
     * @param clientSecret the clientSecret to set
     */
    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }
    /**
     * @return the inputUser
     */
    public String getInputUser() {
        return inputUser;
    }
    /**
     * @param inputUser the inputUser to set
     */
    public void setInputUser(String inputUser) {
        this.inputUser = inputUser;
    }



}
