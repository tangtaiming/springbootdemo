package com.example.demo.dao;

import com.example.demo.orm.TomtopcomLanguage;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @auther ttm
 * @date 2017/12/5
 */
public interface TomtopcomLanguageDao extends MongoRepository<TomtopcomLanguage, Integer> {

    public List<TomtopcomLanguage> findTomtopcomLanguageByWebiste(Integer webiste);

}
