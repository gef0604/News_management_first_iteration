package com.test.news.service;

import com.test.news.dao.NewsTypeRepository;
import com.test.news.model.NewsType;
import com.test.news.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/3/23.
 */
@Service
public class NewsTypeService {
    @Autowired
    private NewsTypeRepository newsTypeRepository;

    public List<NewsType> findAll(){
        return newsTypeRepository.findAll();
    }

    public void save(NewsType newsType){
        if(newsType.getId()==null){
            newsType.setCreateTime(new Date());
        }else{
            newsType.setCreateTime(newsTypeRepository.findOne(newsType.getId()).getCreateTime());
        }
        newsType.setUpdateTime(new Date());
        newsTypeRepository.save(newsType);
    }


    public void del(Integer id){
        newsTypeRepository.delete(id);
    }


}
