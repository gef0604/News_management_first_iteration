package com.test.news.dao;

import com.test.news.model.NewsComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2018/3/24.
 */
@Repository
public interface NewsCommentRepository  extends JpaRepository<NewsComment, Integer> {

    List<NewsComment> findByNewsId(Integer newsId);

}
