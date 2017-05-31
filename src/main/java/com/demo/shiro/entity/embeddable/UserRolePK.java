package com.demo.shiro.entity.embeddable;

import java.io.Serializable;

import javax.persistence.Column;

public class UserRolePK implements Serializable {

    private static final long serialVersionUID = -4918068876731277693L;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "role_id")
    private String roleId;

    public UserRolePK() {
    }

    public UserRolePK(String userId, String roleId) {
        this.userId = userId;
        this.roleId = roleId;
    }

    public String getUserId() {
        return userId;
    }

    public UserRolePK setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public String getRoleId() {
        return roleId;
    }

    public UserRolePK setRoleId(String roleId) {
        this.roleId = roleId;
        return this;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null) {
            return false;
        }
        if (!(other instanceof UserRolePK)) {
            return false;
        }
        UserRolePK castOther = (UserRolePK) other;

        return this.getUserId() != null && castOther.getUserId() != null && this.getUserId().equals(castOther.getUserId())
                && this.getRoleId() != null && castOther.getRoleId() != null && this.getRoleId().equals(castOther.getRoleId());
    }

    public int hashCode() {
        int result = 17;

        result = 37 * result + (getUserId() == null ? 0 : this.getUserId().hashCode());
        result = 37 * result + (getRoleId() == null ? 0 : this.getRoleId().hashCode());
        return result;
    }
}
