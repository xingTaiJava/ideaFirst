package cn.itcast.Hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtils {
    private static EntityManagerFactory factory ;
    static{
       factory= Persistence.createEntityManagerFactory("dipianpian");
    }

    public static EntityManager createEntityManager(){
        EntityManager em = factory.createEntityManager();
        return em;
    }

}
