package com.example.demo.orm.sale.newtomtopcom;

/**
 * 站点语言
 */
public class TomtopSiteLanguage {

    private Integer id;

    /**
     * 语言code
     */
    private String code;

    /**
     * 语言id
     */
    private String language;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
}
