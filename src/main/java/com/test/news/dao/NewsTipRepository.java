package com.test.news.dao;

import com.test.news.model.NewsTip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zengliming
 * @date 2018/3/20 17:36
 */
@Repository
public interface NewsTipRepository extends JpaRepository<NewsTip, Integer> {

    void  deleteNewsTipByNewsId(Integer newsId);


    List<NewsTip> findByTip(String tip);

    NewsTip findByNewsIdAndTip(Integer newsId,String tip);

    List<NewsTip> findByNewsId(Integer newsId);



}
