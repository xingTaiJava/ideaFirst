package cn.itcast.dao;

import cn.itcast.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<Role,Long> {
}
