package com.example.demo.dao;

import com.example.demo.orm.TomtopcomLanguage;

import java.util.List;

/**
 * @auther ttm
 * @date 2017/12/5
 */
public interface TomtopcomLanguageDao {

    public List<TomtopcomLanguage> findTomtopcomLanguageByWebiste(Integer webiste);

}
