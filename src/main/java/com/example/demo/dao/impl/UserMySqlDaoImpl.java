package com.example.demo.dao.impl;

import com.example.demo.orm.User;
import com.example.demo.repository.UserMySqlRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * @auther ttm
 * @date 2017/10/16
 */
@Repository
public class UserMySqlDaoImpl implements UserMySqlRepositoryCustom {

    @Autowired
    private EntityManager entityManager;

    @Override
    public User findUser(String userName, String password) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(criteriaBuilder.and(
                criteriaBuilder.equal(root.get("userName"), userName),
                criteriaBuilder.equal(root.get("password"), password)
        ));
        criteriaQuery.where(predicates.toArray(new Predicate[predicates.size()]));
        return entityManager.createQuery(criteriaQuery).getResultList().get(0);
    }

}
