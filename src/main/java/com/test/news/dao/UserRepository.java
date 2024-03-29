package com.test.news.dao;

import com.test.news.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2018/3/21.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByName(String name);

    void  deleteById(Integer id);
}
