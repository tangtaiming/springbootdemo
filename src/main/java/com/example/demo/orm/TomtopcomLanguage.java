package com.example.demo.orm;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.List;

/**
 *
 * @auther ttm
 * @date 2017/12/5
 */
@Document
public class TomtopcomLanguage {

    @Id
    private Integer id;

    private Integer webiste;

    private List<LanguageId> languageids;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getWebiste() {
        return webiste;
    }

    public void setWebiste(Integer webiste) {
        this.webiste = webiste;
    }

    public List<LanguageId> getLanguageids() {
        return languageids;
    }

    public void setLanguageids(List<LanguageId> languageids) {
        this.languageids = languageids;
    }

}
