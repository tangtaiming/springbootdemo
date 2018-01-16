package com.example.demo.orm;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @auther ttm
 * @date 2017/12/5
 */
public class LanguageId {

    private String code;

    private Integer languageid;

    private String name;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getLanguageid() {
        return languageid;
    }

    public void setLanguageid(Integer languageid) {
        this.languageid = languageid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
