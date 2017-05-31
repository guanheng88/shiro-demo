package com.demo.shiro.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.demo.shiro.entity.embeddable.RolePermissionPK;

@Entity
@Table(name = "role_permission")
public class RolePermissionEntity {

    @EmbeddedId
    private RolePermissionPK pk;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    @MapsId("role_id")
    private RoleEntity role;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "permission_id", referencedColumnName = "id")
    @MapsId("permission_id")
    private PermissionEntity permission;

    public RolePermissionPK getPk() {
        return pk;
    }

    public RolePermissionEntity setPk(RolePermissionPK pk) {
        this.pk = pk;
        return this;
    }

    public RoleEntity getRole() {
        return role;
    }

    public RolePermissionEntity setRole(RoleEntity role) {
        this.role = role;
        return this;
    }

    public PermissionEntity getPermission() {
        return permission;
    }

    public RolePermissionEntity setPermission(PermissionEntity permission) {
        this.permission = permission;
        return this;
    }
}
