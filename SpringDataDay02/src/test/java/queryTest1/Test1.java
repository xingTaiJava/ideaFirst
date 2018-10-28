package queryTest1;

import cn.itcast.dao.CustomerDao;
import cn.itcast.dao.CustomerExtDao;

import cn.itcast.dao.LinkManDao;
import cn.itcast.domain.Customer;
import cn.itcast.domain.CustomerExt;
import cn.itcast.domain.LinkMan;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Test1 {

    @Autowired
    private CustomerDao cusdao;
    @Autowired
    private LinkManDao lkmdao;
    @Autowired
    private CustomerExtDao extDao;

    @Transactional
    @Commit
    @Test
    public void queryTest1(){
      /*  LinkMan lin1 =new LinkMan();
        LinkMan lin2 =new LinkMan();
        Customer cust =new Customer();
        cust.setCustName("古天乐");
        lin1.setLkmName("王力宏");
        lin1.setLkmPhone("15512949680");
        lin1.setLkmGender("男");
        lin2.setLkmName("张国荣");
        lin2.setLkmPhone("13931966581");
      //  Set<LinkMan> sett = new HashSet<>();
        Set<LinkMan> sett = cust.getLinkMen();
        sett.add(lin1);
        sett.add(lin2);
     //   cust.setLinkMen(sett);
        cust.getLinkMen().add(lin1);
        cust.getLinkMen().add(lin2);
        lin1.setCus(cust);
        lin2.setCus(cust);
        lkmdao.save(lin1);
        lkmdao.save(lin2);
  //      cusdao.save(cust);*/

      Customer customer= new Customer();
      customer.setCustName("javaEE");

      LinkMan li1 = new LinkMan();
        li1.setLkmName("java大数据");

        LinkMan li2 = new LinkMan();
        li2.setLkmName("下鱼");

     /*   customer.getLinkMen().add(li1);
        customer.getLinkMen().add(li2);*/

        li1.setCus(customer);
        li2.setCus(customer);

        cusdao.save(customer);
        lkmdao.save(li1);
        lkmdao.save(li2);




    }

    @Test
   /* @Transactional
    @Commit*/
    public void testOne2One() {
        Customer customer =new Customer();
        CustomerExt ext =new CustomerExt();
        ext.setExt("详情");
        customer.setCustName("客户");
        customer.setExt(ext);
        extDao.save(ext);
        cusdao.save(customer);
    }

    @Test
    public void queryOne2One() {
        Customer cust =cusdao.findOne(1l);
        cust.setCustAge("34");
        cust.setCustAddress("大栅栏");
        cusdao.save(cust);

        System.out.println(cusdao.findOne(cust.getCustId()));
    }
}
