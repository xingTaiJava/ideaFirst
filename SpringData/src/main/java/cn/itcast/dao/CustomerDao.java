package cn.itcast.dao;

import cn.itcast.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerDao extends JpaRepository<Customer,Long> , JpaSpecificationExecutor<Customer> {
    @Query("from Customer where custId <?1 and custName like %?2%")
    public List<Customer> queryCustomerByCustId(Long custId, String custName);

    Customer findByCustIdEquals(Long id);

    List<Customer> findCustomersByCustIdAfterAndCustNameLike(Long id, String name);

    @Query(value = "select * from customer_user where id > ?1",nativeQuery = true)
    public List<Customer> queryById(Long id);

    @Modifying
    @Query("update Customer set custAddress=?2  where custId=?1")
    public void updateByAnnotation(Long id, String address);

}
