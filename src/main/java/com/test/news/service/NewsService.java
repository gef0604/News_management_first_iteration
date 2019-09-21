package com.test.news.service;

import com.test.news.FNLPUtil;
import com.test.news.dao.*;
import com.test.news.model.News;
import com.test.news.model.NewsComment;
import com.test.news.model.NewsTip;
import com.test.news.model.NewsType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author zengliming
 * @date 2018/3/22 17:06
 */
@Service
public class NewsService {

    @Autowired
    private NewsRepository newsRepository;

    @Autowired
    private NewsTipRepository newsTipRepository;

    @Autowired
    private NewsTypeRepository newsTypeRepository;

    @Autowired
    private NewsCommentRepository newsCommentRepository;

    @Autowired
    private UserRepository userRepository;

    public News findOne(Integer id){
        News news =  newsRepository.findOne(id);
        List<NewsComment> comments = newsCommentRepository.findByNewsId(id);
        if(comments!=null){
            for (NewsComment comment : comments) {
               try {
                   comment.setUserName(userRepository.findOne(comment.getUserId()).getName());
               }catch (Exception e){
               }
            }
        }else{
            comments = new ArrayList<>();
        }
        news.setComments(comments);
        return news;
    }


    public List<News> listByType(Integer typeId){
        List<News> list= newsRepository.findByTypeIdOrderByDateDesc(typeId);
        for (News news : list) {
            news.setTips(newsTipRepository.findByNewsId(news.getId()));
        }
        return list;
    }

    public List<News> findByTypeIdIn(List<Integer> typeId){
        List<News> list= newsRepository.findByTypeIdInOrderByDateDesc(typeId);
        for (News news : list) {
            news.setTips(newsTipRepository.findByNewsId(news.getId()));
        }
        return list;
    }

    public List<News> listByTip(String tip){
        List<News> list = new ArrayList<>();
        List<NewsTip> newsTips =  newsTipRepository.findByTip(tip);
        for (NewsTip newsTip : newsTips) {
            News news = newsRepository.findOne(newsTip.getNewsId());
            if(news!=null){
                news.setTips(newsTipRepository.findByNewsId(news.getId()));
            }
            list.add(news);
        }
        return list;
    }



    public List<News> findAll(){
        Sort sort = new Sort(Sort.Direction.DESC, "date");
        List<News> list= newsRepository.findAll(sort);
        for (News news : list) {
            try {
                NewsType newsType =  newsTypeRepository.findOne(news.getTypeId());
                if(newsType!=null){
                    news.setTypeName(newsType.getName());
                }
            }catch (Exception e){
            }
        }
        return list;
    }


    public void delete(Integer id){
        newsRepository.delete(id);
    }


    public void save(News news){
        if(news.getId()==null){
            news.setDate(new Date());
            news.setNum(0);
        }else{
            News n1 = newsRepository.findOne(news.getId());
            news.setDate(n1.getDate());
            news.setNum(n1.getNum());
        }
        news = newsRepository.save(news);
        String []tips = FNLPUtil.factory.seg(news.getTitle());
        if(tips!=null){
            for (String tip : tips) {
                if(tip.length()>=2){
                    NewsTip newsTip = newsTipRepository.findByNewsIdAndTip(news.getId(),tip);
                    if(newsTip==null){
                        newsTip = new NewsTip();
                        newsTip.setNewsId(news.getId());
                        newsTip.setTip(tip);
                        newsTipRepository.save(newsTip);
                    }
                }
            }
        }
    }

    public News getOne(Integer id){
        News news =  newsRepository.findOne(id);
        return news;
    }

}
