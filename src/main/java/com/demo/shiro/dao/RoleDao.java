package com.demo.shiro.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.demo.shiro.entity.RoleEntity;
import com.demo.shiro.entity.UserEntity;
import com.demo.shiro.entity.UserRoleEntity;

@Repository
public class RoleDao extends AbstractDao<RoleEntity> {

    public List<RoleEntity> findRolesByUser(UserEntity user) {
        CriteriaBuilder builder = entityManager().getCriteriaBuilder();
        CriteriaQuery<RoleEntity> query = builder.createQuery(RoleEntity.class);
        
        Root<UserRoleEntity> root = query.from(UserRoleEntity.class);
        Join<UserRoleEntity, RoleEntity> roleRoot = root.join("role");
        
        Predicate predicate = builder.equal(root.get("user"), user);
        query.select(roleRoot).where(predicate);

        return fetchResultList(query);
    }
}
