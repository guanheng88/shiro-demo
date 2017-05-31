package com.demo.shiro.entity.embeddable;

import java.io.Serializable;

import javax.persistence.Column;

public class RolePermissionPK implements Serializable {

    private static final long serialVersionUID = -4918068876731277693L;

    @Column(name = "role_id")
    private String roleId;

    @Column(name = "permission_id")
    private String permissionId;

    public RolePermissionPK() {
    }

    public RolePermissionPK(String roleId, String permissionId) {
        this.roleId = roleId;
        this.permissionId = permissionId;
    }

    public String getRoleId() {
        return roleId;
    }

    public RolePermissionPK setRoleId(String roleId) {
        this.roleId = roleId;
        return this;
    }

    public String getPermissionId() {
        return permissionId;
    }

    public RolePermissionPK setPermissionId(String permissionId) {
        this.permissionId = permissionId;
        return this;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null) {
            return false;
        }
        if (!(other instanceof RolePermissionPK)) {
            return false;
        }
        RolePermissionPK castOther = (RolePermissionPK) other;

        return this.getPermissionId() != null && castOther.getPermissionId() != null && this.getPermissionId().equals(castOther.getPermissionId())
                && this.getRoleId() != null && castOther.getRoleId() != null && this.getRoleId().equals(castOther.getRoleId());
    }

    public int hashCode() {
        int result = 17;

        result = 37 * result + (getPermissionId() == null ? 0 : this.getPermissionId().hashCode());
        result = 37 * result + (getRoleId() == null ? 0 : this.getRoleId().hashCode());
        return result;
    }
}
