package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 查询数据的主要实现
 */
@Service
public class UserSerivceImpl {

    @Autowired
    private UserRepository userRepository;

    public User findUser(String name) {
        return userRepository.findByName(name);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Long save(User user) {
        return userRepository.save(user).getId();
    }

    public void saveListUser(List<User> list) {
        for (User user : list)
            save(user);
    }


    /**
     * 增
     *
     * @param user
     * @return
     */

    public User addUser(User user) {
        return userRepository.save(user);
    }

    /**
     * 删除
     * @param id
     */
    public void delUser(Long id) {
        userRepository.deleteById(id);
    }

    /**
     * 修改
     * @param user
     * @return
     */
    public User updata(User user) {
        return userRepository.save(user);
    }

    /**
     * 根绝id查询
     * @param id
     * @return
     */
    public User findUserById(Long id) {
        return userRepository.findById(id).get();
    }



}
