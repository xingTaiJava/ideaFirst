package queryTest1;

import cn.itcast.dao.RoleDao;
import cn.itcast.dao.UserDao;
import cn.itcast.domain.Role;
import cn.itcast.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.management.relation.RoleList;
import java.util.List;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestMany2Many {

    @Autowired
    private UserDao ud;
    @Autowired
    private RoleDao rd;

    @Transactional
    @Commit
    @Test
    public void testSave1(){
        User user1 =new User();
        user1.setUsername("康熙");
        User user2 =new User();
        user2.setUsername("乾隆");

        Role r1 =new Role();
        r1.setRoleName("皇上");
        Role r2 = new Role();
        r2.setRoleName("老公");

        user1.getRoleSet().add(r1);
        user1.getRoleSet().add(r2);

        user2.getRoleSet().add(r1);
        user2.getRoleSet().add(r2);

        rd.save(r1);
        rd.save(r2);
        ud.save(user1);
        ud.save(user2);

    }

    @Transactional
    @Commit
    @Test
    public void testSave2(){
        User user1 =new User();
        user1.setUsername("康熙");
        User user2 =new User();
        user2.setUsername("乾隆");

        Role r1 =new Role();
        r1.setRoleName("太子");
        Role r2 = new Role();
        r2.setRoleName("儿子");

        r1.getUserSet().add(user1);
        r1.getUserSet().add(user2);
        r2.getUserSet().add(user1);
        r2.getUserSet().add(user2);


        rd.save(r1);
        rd.save(r2);
       /* ud.save(user1);
        ud.save(user2);*/

    }

    @Test
    public void deleteTest() {
        rd.delete(6l);
        rd.delete(5l);
    }
    //添加关系
    @Transactional
    @Commit
    @Test
    public void addRelation(){
      /*  List<User> userList = ud.findAll();
        for (User user : userList) {
       *//* User user1 = ud.findOne(3l);
        Role role1 = rd.findOne(3l);*//*
            //       Set<Role> roleSet1 = user1.getRoleSet();
            //       roleSet1.remove(role1);
            //         user1.getRoleSet().add(rd.findOne(4l));

   //         user.getRoleSet().add(rd.findOne(3l));

            ud.save(user);
        }*/
        User user = ud.findOne(4l);
        for(Role role :rd.findAll()){
            user.getRoleSet().add(role);
        };
        ud.save(user);
    }

    //解除关系
    @Transactional
    @Commit
    @Test
    public void testRemoveRelation (){
        User us = ud.findOne(4l);
        List<Role> roleList = rd.findAll();
        us.getRoleSet().removeAll(roleList);
        ud.save(us);
    }



}
