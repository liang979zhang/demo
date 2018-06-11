package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * 查询数据的主要实现
 */
@Service
public class UserSerivceImpl {
    @Autowired
    private UserRepository userRepository;

    public Page<User> findByPage(final User user, int page, int pageSize) throws Exception {
        Sort sort = new Sort(Sort.Direction.DESC, "registerTime");
        PageRequest pageRequest =  new PageRequest(page, pageSize, sort);

        return userRepository.findAll(new Specification<User>(){
            @Override
            public Predicate toPredicate(Root<User> root,
                                         CriteriaQuery<?> query, CriteriaBuilder builder) {
                List<Predicate> predicates = new ArrayList<Predicate>();
//                if(null != user.getUserType()){
//                    predicates.add(builder.equal(root.get("userType"), user.getUserType()));
//                }
//                if(null != user.getStatus()){
//                    predicates.add(builder.equal(root.get("status"), user.getStatus()));
//                }
                query.where(predicates.toArray(new Predicate[predicates.size()]));
                return null;
            }
        }, pageRequest);
    }



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
