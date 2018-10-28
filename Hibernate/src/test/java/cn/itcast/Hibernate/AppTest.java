package cn.itcast.Hibernate;

import static org.junit.Assert.assertTrue;

import cn.itcast.domain.Customer;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**新增
     * Rigorous Test :-)
     */
    @Test
    public void testHibernate(){
        EntityManager em =JPAUtils.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        //---------------------------------------------------------
        Customer cust =new Customer();
        cust.setCust_name("merriry");
        cust.setCust_age("48");
        cust.setCust_address("库尔勒");
        cust.setCust_birthday("1969");
        em.persist(cust);
        //---------------------------------------------------------
        transaction.commit();
        em.close();
    }
    @Test
    public void testQuery(){
        EntityManager em=JPAUtils.createEntityManager();
        EntityTransaction tranQuery =em.getTransaction();
        tranQuery.begin();
        Customer customer=em.find(Customer.class,3l);
        System.out.println(customer);
        tranQuery.commit();
        em.close();
    }
    @Test
    public void testDelete(){
        EntityManager de =JPAUtils.createEntityManager();
        EntityTransaction transaction = de.getTransaction();
        transaction.begin();

        Customer cu =de.find(Customer.class,1l);
        Customer cus =new Customer();
        de.remove(cus);
        transaction.commit();
        de.close();
    }
    @Test
    public void testUpdate(){
        EntityManager em =JPAUtils.createEntityManager();
        EntityTransaction tran = em.getTransaction();
        tran.begin();
        Customer cus = em.find(Customer.class, 1l);
        cus.setCust_birthday("2018.10.24");
        cus.setCust_address("回龙观");
        em.merge(cus);
        tran.commit();
        em.close();

    }
}
