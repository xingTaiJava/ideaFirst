package cn.itcast.Hibernate;

import cn.itcast.domain.Customer;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class JPQLdemo {
    @Test
    public void testQuery() {
        EntityManager en = JPAUtils.createEntityManager();
        EntityTransaction tx =en.getTransaction();
        tx.begin();
            String jpql ="from Customer";
        Query query =en.createQuery(jpql);
        List<Customer>customerList=query.getResultList();
        System.out.println(customerList);
        tx.commit();
        en.close();
    }
    @Test
    public void testPage(){
        EntityManager ent =JPAUtils.createEntityManager();
        EntityTransaction tx = ent.getTransaction();
        tx.begin();
        String jpql ="from Customer";
        Query query = ent.createQuery(jpql);
        query.setFirstResult(2);
        query.setMaxResults(2);
        List resultList = query.getResultList();
        System.out.println(resultList);
        tx.commit();
        ent.close();
    }
    @Test
    public void testCriteria(){
        EntityManager emm = JPAUtils.createEntityManager();
        EntityTransaction transaction = emm.getTransaction();
        transaction.begin();
        String jpql="from Customer where id= :ids";
        Query query = emm.createQuery(jpql);
        query.setParameter("ids",4l);
        List resultList = query.getResultList();
        System.out.println(resultList);

        transaction.commit();
        emm.close();

    }

    @Test
    public void testcount(){
        EntityManager emm = JPAUtils.createEntityManager();
        EntityTransaction transaction = emm.getTransaction();
        transaction.begin();
        //  select count(c.cust_id) from Customer c where cust_name like ? ";
        String jpql="select count(c.cust_name) from Customer c where id >= :ii";
        Query query = emm.createQuery(jpql);
        query.setParameter("ii",5l);
        Long singleResult = (Long) query.getSingleResult();
        System.out.println(singleResult);

        transaction.commit();
        emm.close();

    }


}
