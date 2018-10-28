package cn.itcast.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Table(name = "role")
@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "roleid")
    private long roleId;
    @Column(name = "role_name")
    private String roleName;
    @Column(name = "memo")
    private String memo;

    @ManyToMany(mappedBy = "roleSet")
    private Set<User>  userSet= new HashSet<>();

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Set<User> getUserSet() {
        return userSet;
    }

    public void setUserSet(Set<User> userSet) {
        this.userSet = userSet;
    }
}
