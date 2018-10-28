package cn.itcast.dao;

import cn.itcast.domain.LinkMan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LinkManDao extends JpaRepository<LinkMan,Long> {
}
