package com.test.news;

import org.fnlp.nlp.cn.CNFactory;
import org.fnlp.util.exception.LoadModelException;

/**
 * Created by Administrator on 2018/3/24.
 */
public class FNLPUtil {
    public static CNFactory factory = null;
    static {
        try {
            factory =  CNFactory.getInstance("F:\\fnlp\\models");
        } catch (LoadModelException e) {
            e.printStackTrace();
        }
    }
}
