package cn.itcast;

import cn.itcast.domain.Customer;

import cn.itcast.dao.CustomerDao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.Predicate;
import java.util.List;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Test1 {

    @Autowired
    private CustomerDao customerDao;

 //   @Transactional
    @Test
    public void updateTest(){
        Customer cus =new Customer();
        cus.setCustName("max4");
        cus.setCustAddress("迪拜");
        cus.setCustAge("54");
        customerDao.save(cus);

 //       return null;

    }

    @Test
    public void queryTest (){
        List cu = customerDao.findAll();
        System.out.println(cu);
  //      return cu;
    }

    @Test
    public void updateTest2() {
        Customer customer =customerDao.findOne(3l);
        customer.setCustAddress("西三旗");
        customerDao.save(customer);
    }

    @Test
    public void deleTest() {
//        Customer cus =customerDao.findOne(1l);
        customerDao.delete(4l);
    }

    @Test
    public void pageTest() {
        Page<Customer> page=customerDao.findAll(new PageRequest(1,3));
        System.out.println(page.getContent());
    }

    @Test
    public void pageTest2() {
        Page<Customer> page=customerDao.findAll(new PageRequest(0,4));
        System.out.println(page.getTotalElements());
        System.out.println(page.getContent());
    }

    @Test
    public void queryTest3() {
        customerDao.findAll((root,query,bu) ->{
            Predicate pre1 = bu.like(root.get("custName").as(String.class),"%max%");
            Predicate pre2 = bu.lessThanOrEqualTo(root.get("custId").as(Long.class),9l);
            Predicate pre3 = bu.and(pre2,pre1);
            Predicate pre4 = query.where(pre3).orderBy(bu.desc(root.get("custId").as(Long.class))).getRestriction();
                    return pre4;
        }).stream().forEach(l -> System.out.println(l));
    }
}
