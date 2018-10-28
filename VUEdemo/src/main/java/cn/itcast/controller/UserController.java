package cn.itcast.controller;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.List;

@Controller
@RequestMapping("/user")
@ResponseBody
public class UserController {

    @Autowired
    private UserDao userDao;

    @RequestMapping("/findAll.do")
    public List<User> findAll(){
        return userDao.findAll();
    }

    @RequestMapping("/findOne")
    public User findOne(Integer id){
       return userDao.findOne(id);
    }

    @RequestMapping("/update")
    public void update(@RequestBody User user){
        userDao.save(user);
    }

    @RequestMapping("/delete")
    public void deleteById(Integer id){
        userDao.delete(id);
    }
}
