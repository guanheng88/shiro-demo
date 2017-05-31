package com.demo.shiro.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.demo.shiro.entity.PermissionEntity;
import com.demo.shiro.entity.RoleEntity;
import com.demo.shiro.entity.RolePermissionEntity;

@Repository
public class PermissionDao extends AbstractDao<PermissionEntity> {

    public List<PermissionEntity> findPermissionsByRole(RoleEntity role) {
        CriteriaBuilder builder = entityManager().getCriteriaBuilder();
        CriteriaQuery<PermissionEntity> query = builder.createQuery(PermissionEntity.class);

        Root<RolePermissionEntity> root = query.from(RolePermissionEntity.class);
        Join<RolePermissionEntity, PermissionEntity> permissionRoot = root.join("permission");

        Predicate predicate = builder.equal(root.get("role"), role);
        query.select(permissionRoot).where(predicate);

        return fetchResultList(query);
    }
}
