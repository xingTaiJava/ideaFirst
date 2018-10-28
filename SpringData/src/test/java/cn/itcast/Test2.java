package cn.itcast;

import cn.itcast.dao.CustomerDao;
import cn.itcast.domain.Customer;
import org.aspectj.weaver.ast.Var;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Test2 {

    @Autowired
    private CustomerDao cu;

    @Test
    public void queryById(){
       cu.queryCustomerByCustId(8l,"max").stream().forEach(c -> System.out.println(c));
   //     System.out.println(cus);
    }

    @Test
    public void queryTest2() {
       cu.queryById(4l).stream().forEach(c -> System.out.println(c));

  //      System.out.println(customer);
    }

    @Test
    public void queryTest3() {
       Customer cus=cu.findByCustIdEquals(10l);
        System.out.println(cus);
    }

    @Test
    public void queryTest4() {
        cu.findCustomersByCustIdAfterAndCustNameLike(3l,"%max%").stream().forEach(v -> System.out.println(v));
    }
    @Transactional
    @Commit
    @Test
    public void updateTest2() {
     /*   Customer cus = cu.findByCustIdEquals(7l);
        cus.setCustAddress("轮南小区");*/
        cu.updateByAnnotation(5l,"轮南小区");
    }

    @Test
    public void queryTest5() {
        cu.findAll((root, query, criteria) -> {
            Predicate p = criteria.like(root.get("custName").as(String.class), "%max%");
            return p;
        }).stream().forEach(c -> System.out.println(c));

    }

    @Test
    public void queryTest6() {
        cu.findAll((root,query,bud) ->{
           return bud.equal(root.get("custId").as(Long.class),6l);
        }).stream().forEach(s -> System.out.println(s));
    }


    @Test
    public void queryTest7() {
        /**  root  用来指定条件中的属性名称(实体类中的变量)  root.get(" 属性名 ")即可获得属性
         *   query  用来指定附加条件   如 order by / group by 等
         * *   bur   (1) 指定第一个条件, 如 equal / like  /  between / before 等   (2) 可用 if / or 拼接两个已定义好的条件
         */
        cu.findAll((root,query,bur)->{
           Predicate pre1= bur.like(root.get("custName").as(String .class),"%max%");
           Predicate pre2 =bur.between(root.get("custId").as(Long.class),3l,10l);
           Predicate pre3 =bur.and(pre1,pre2);
           return pre3;
        }).stream().forEach(c-> System.out.println(c));
    }

    @Test
    public void queryTest8() {
        cu.findAll((root,query,bu) ->{
            Predicate pr1 =bu.like(root.get("custName").as(String.class),"%max%");
            Predicate pr2 =bu.lessThan(root.get("custId").as(Long.class),8l);
            Predicate pr3 =bu.and(pr1,pr2);

            Predicate pr4 =query.where(pr3).orderBy(bu.desc(root.get("custId").as(Long.class))).getRestriction();
            return pr4;
        }).stream().forEach(b -> System.out.println(b));
    }

    @Test
    public void queryTest9() {
        cu.findAll((root,query,br) ->{
            Predicate pre1 =br.like(root.get("custName").as(String.class),"%max%");
            Predicate pre2 =br.greaterThan(root.get("custId").as(Long.class),7l);
            Predicate pre3 =br.and(pre1,pre2);
            Predicate pre4 =query.where(pre3).orderBy(br.desc(root.get("custId"))).getRestriction();
            return pre4;
        }).stream().forEach(n -> System.out.println(n));
    }
}
