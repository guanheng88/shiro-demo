package com.demo.shiro.dao;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.demo.shiro.entity.UserEntity;

@Repository
public class UserDao extends AbstractDao<UserEntity> {

    public UserEntity findUserByUsername(String username) {
        CriteriaBuilder builder = entityManager().getCriteriaBuilder();
        CriteriaQuery<UserEntity> query = builder.createQuery(UserEntity.class);
        Root<UserEntity> root = query.from(UserEntity.class);
        Predicate predicate = builder.equal(root.get("username"), username);
        query.select(root).where(predicate);

        return fetchSingleResult(query);
    }
}
