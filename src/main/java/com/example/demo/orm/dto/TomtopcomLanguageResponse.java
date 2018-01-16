package com.example.demo.orm.dto;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * 语言测试
 * @auther ttm
 * @date 2017/12/5
 */
public class TomtopcomLanguageResponse {

    private Integer webiste;

    private List<LanguageidResponse> languageids;

    public Integer getWebiste() {
        return webiste;
    }

    public void setWebiste(Integer webiste) {
        this.webiste = webiste;
    }

    public List<LanguageidResponse> getLanguageids() {
        return languageids;
    }

    public void setLanguageids(List<LanguageidResponse> languageids) {
        this.languageids = languageids;
    }

}
