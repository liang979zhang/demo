package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserSerivceImpl userSerivce;

    @GetMapping("/users")
    public List findUserList() {
        return userRepository.findAll();
    }


    /**
     * post注解方式提交访问数据
     *
     * @param username
     * @param name
     * @param password
     * @return
     */
    @PostMapping("/users/add")
    public User addUser(@RequestParam("username") String username, @RequestParam("name") String name, @RequestParam("password") String password) {
        User user = new User();
        user.setUsername(username);
        user.setName(name);
        user.setPassword(password);
        User user1 = userSerivce.addUser(user);
        return user1;
    }


    @PostMapping("/users/getString")
    public String getStrng() {
        List<User> list = userSerivce.findAll();
        return list.size() + "";
    }


    @PostMapping("/users/findUserById")
    public User getUserById(@RequestParam("id") Long id) {

        return userSerivce.findUserById(id);
    }


}
