package cn.itcast.dao;

import cn.itcast.domain.CustomerExt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerExtDao extends JpaRepository<CustomerExt,Long> {
}
