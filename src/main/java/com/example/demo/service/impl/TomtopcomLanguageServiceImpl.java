package com.example.demo.service.impl;

import com.example.demo.dao.TomtopcomLanguageDao;
import com.example.demo.libraries.JsonHelper;
import com.example.demo.orm.TomtopcomLanguage;
import com.example.demo.orm.dto.TomtopcomLanguageResponse;
import com.example.demo.service.TomtopcomLanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @auther ttm
 * @date 2017/12/5
 */
@Service
public class TomtopcomLanguageServiceImpl implements TomtopcomLanguageService {

    @Autowired
    private TomtopcomLanguageDao tomtopcomLanguageDao;

    @Override
    public List<TomtopcomLanguageResponse> tomtopLanguageList() {
        List<TomtopcomLanguage> tomtopcomLanguageList = tomtopcomLanguageDao.findAll();
        return (List<TomtopcomLanguageResponse>) JsonHelper.fromJson(JsonHelper.toJson(tomtopcomLanguageList), List.class, TomtopcomLanguageResponse.class);
    }

    @Override
    public List<TomtopcomLanguageResponse> tomtopLanuageListByWebsite(Integer website) {
        if (website == null) {
            return tomtopLanguageList();
        }

        List<TomtopcomLanguage> tomtopcomLanguageList = tomtopcomLanguageDao.findTomtopcomLanguageByWebiste(website);
        return (List<TomtopcomLanguageResponse>) JsonHelper.fromJson(JsonHelper.toJson(tomtopcomLanguageList), List.class, TomtopcomLanguageResponse.class);
    }

}
