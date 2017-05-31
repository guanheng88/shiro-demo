package com.demo.shiro.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.demo.shiro.entity.embeddable.UserRolePK;

@Entity
@Table(name = "user_role")
public class UserRoleEntity {

    @EmbeddedId
    private UserRolePK pk;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @MapsId("user_id")
    private UserEntity user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    @MapsId("role_id")
    private RoleEntity role;

    public UserRolePK getPk() {
        return pk;
    }

    public UserRoleEntity setPk(UserRolePK pk) {
        this.pk = pk;
        return this;
    }

    public UserEntity getUser() {
        return user;
    }

    public UserRoleEntity setUser(UserEntity user) {
        this.user = user;
        return this;
    }

    public RoleEntity getRole() {
        return role;
    }

    public UserRoleEntity setRole(RoleEntity role) {
        this.role = role;
        return this;
    }
}
