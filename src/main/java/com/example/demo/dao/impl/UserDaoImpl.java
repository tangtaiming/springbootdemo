package com.example.demo.dao.impl;

import com.example.demo.orm.User;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.*;
import java.util.regex.Pattern;

/**
 * @auther ttm
 * @date 2017/9/5
 */
public class UserDaoImpl {

    private Class<User> clazz;

    private final MongoOperations mongoOperations;

    public UserDaoImpl(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
        //当前对象的直接超类的 Type
        Type genericSuperclass = getClass().getGenericSuperclass();
        if(genericSuperclass instanceof ParameterizedType){
            //参数化类型
            ParameterizedType parameterizedType= (ParameterizedType) genericSuperclass;
            //返回表示此类型实际类型参数的 Type 对象的数组
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            this.clazz= (Class<User>) actualTypeArguments[0];
        }else{
            this.clazz= (Class<User>) genericSuperclass;
        }
    }

    public List<User> userList(Map<String, Object> request) {
        System.out.println("ttm | --> " + mongoOperations.toString());
        return null;
    }

    public User userOne(Map<String, Object> request) {
        System.out.println("ttm | --> " + clazz);
        Map<String, Object> query = (Map<String, Object>) request.get("query");
        Criteria criteria = getRequestRestriction(query);
        Query myQuery = new Query(criteria);

        return mongoOperations.findOne(myQuery, clazz);
    }

    public String userNextId() {
        String sequence_collection = "seq";
        String sequence_field = "seq";
        DBCollection seq = mongoOperations.getCollection(sequence_collection);

        DBObject query = new BasicDBObject();
        query.put("_id", User.class.getName());

        DBObject change = new BasicDBObject(sequence_field, Integer.valueOf(1));
        DBObject update = new BasicDBObject("$inc", change);

        DBObject res = seq.findAndModify(query, new BasicDBObject(),
                new BasicDBObject(), false, update, true, true);
        return res.get(sequence_field).toString();
    }

    /**
     * 获取查询条件
     * @param query
     * @return
     */
    public Criteria getRequestRestriction(Map<String, Object> query) {
        Criteria allCriteria = new Criteria();
        List<Criteria> criterias = new ArrayList<>();
        if (null != query) {
            for (String key : query.keySet()) {
                if ("$or".equals(key)) {
                    Object orObject = query.get(key);
                    if ((orObject instanceof Map)) {
                        Map<String, Object> orValues = (Map<String, Object>) orObject;
                        criterias.add(_parseRequestRestrictionOr(orValues));
                    } else if ((orObject instanceof List)) {

                        List<Map<String, Object>> orValues = (List<Map<String, Object>>) orObject;
                        Map<String, Object> orBigMap = new HashMap<>();
                        Map<String, Object> orValue;
                        for (Iterator<Map<String, Object>> localIterator2 = orValues.iterator(); localIterator2.hasNext();) {
                            orValue = localIterator2.next();

                            for (String orMapKey : orValue.keySet()) {
                                orBigMap.put(orMapKey, orValue.get(orMapKey));
                            }
                        }
                        criterias.add(_parseRequestRestrictionOr(orBigMap));
                    }
                } else {
                    Object value = query.get(key);
                    criterias.addAll(_parseCriteria(key, value));
                }
            }
        }
        if (!criterias.isEmpty()) {
            allCriteria.andOperator((Criteria[]) criterias
                    .toArray(new Criteria[criterias.size()]));
        }

        return allCriteria;
    }

    @SuppressWarnings("unchecked")
    protected Criteria _parseRequestRestrictionOr(Map<String, Object> query) {
        Criteria allOrCriteria = new Criteria();
        List<Criteria> criterias = new ArrayList<>();
        if (null != query) {
            for (String key : query.keySet()) {
                Object value = query.get(key);
                if (StringUtils.startsWith(key, "$and")) {
                    criterias.add(getRequestRestriction((Map<String, Object>) value));
                } else {
                    criterias.addAll(_parseCriteria(key, value));
                }
            }
        }
        if (!criterias.isEmpty()) {
            allOrCriteria.orOperator((Criteria[]) criterias.toArray(new Criteria[criterias.size()]));
        }

        return allOrCriteria;
    }

    @SuppressWarnings("unchecked")
    private List<Criteria> _parseCriteria(String key, Object value) {
        if ("id".equals(key)) {
            key = "_id";
        }
        List<Criteria> criterias = new ArrayList<>();
        Map<String, Object> compareValue;
        if (value instanceof Map) {
            compareValue = (Map<String, Object>) value;
            for (String compare : compareValue.keySet()) {
                Object _compareValue = compareValue.get(compare);
                if ("$ge".equals(compare)) {
                    criterias.add(Criteria.where(key).gte(_compareValue));
                } else if ("$le".equals(compare)) {
                    criterias.add(Criteria.where(key).lte(_compareValue));
                } else if ("$gt".equals(compare)) {
                    criterias.add(Criteria.where(key).gt(_compareValue));
                } else if ("$lt".equals(compare)) {
                    criterias.add(Criteria.where(key).lt(_compareValue));
                } else if ("$in".equals(compare)) {
                    criterias.add(Criteria.where(key).in(
                            (Collection<?>) _compareValue));
                } else if ("$like".equals(compare)) {
                    criterias.add(Criteria.where(key).regex(
                            Pattern.compile(Pattern.quote((String) _compareValue), 2)));
                } else if ("$left_like".equals(compare)) {
                    criterias.add(Criteria
                            .where(key)
                            .regex(Pattern.compile(
                                    Pattern.quote((String) _compareValue + "$"), 2)));
                } else if ("$right_like".equals(compare)) {
                    criterias.add(Criteria.where(key).regex(
                            Pattern.compile(
                                    Pattern.quote("^" + (String) _compareValue), 2)));
                } else if ("$not_like".equals(compare)) {
                    criterias.add(Criteria.where(key).not()
                            .regex((String) _compareValue));
                } else if ("$left_like".equals(compare)) {
                    criterias.add(Criteria
                            .where(key)
                            .not()
                            .regex(Pattern.compile(
                                    Pattern.quote((String) _compareValue + "$"), 2)));
                } else if ("$not_right_like".equals(compare)) {
                    criterias.add(Criteria
                            .where(key)
                            .not()
                            .regex(Pattern.compile(
                                    Pattern.quote("^" + (String) _compareValue), 2)));
                } else if ("$ne".equals(compare)) {
                    criterias.add(Criteria.where(key).ne(_compareValue));
                } else if ("$null".equals(compare)) {
                    criterias.add(Criteria.where(key).is(null));
                } else if ("$not_null".equals(compare)) {
                    criterias.add(Criteria.where(key).not().is(null));
                } else if ("$not_in".equals(compare)) {
                    criterias.add(Criteria.where(key).not().in((Collection<?>) _compareValue));
                } else if ("$where".equals(compare)) {
                    criterias.add(Criteria.where("$where").is(_compareValue));
                } else if ("$exists".equals(compare)) {
                    criterias.add(Criteria.where(key).exists((boolean)_compareValue));
                }
            }
        } else {
            criterias.add(Criteria.where(key).is(value));
        }

        return criterias;
    }

}
