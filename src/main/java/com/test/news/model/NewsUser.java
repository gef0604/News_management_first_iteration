package com.test.news.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Administrator on 2018/3/27.
 */
@Entity
@Data
public class NewsUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;//id

    private Integer userId;

    private Integer typeId;

    private Integer num;
}
