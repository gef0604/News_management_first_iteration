package com.test.news;

import org.fnlp.nlp.cn.CNFactory;

import java.util.HashMap;

/**
 * Created by Administrator on 2018/3/20.
 */
public class Test {
    public static void main(String[] args) throws Exception {
        // 创建中文处理工厂对象，并使用“models”目录下的模型文件初始化
        CNFactory factory = CNFactory.getInstance("F:\\fnlp\\models");

        // 使用分词器对中文句子进行分词，得到分词结果
        String[] words = factory.seg("关注自然语言处理、语音识别、深度学习等方向的前沿技术和业界动态。");

        // 打印分词结果
        for (String word : words) {
            System.out.print(word + " ");
        }
        System.out.println();
    }
}


//        // 创建中文处理工厂对象，并使用“models”目录下的模型文件初始化
//        CNFactory factory = CNFactory.getInstance("F:\\fnlp\\models");
//
//        // 使用分词器对中文句子进行分词，得到分词结果
//        String[] words = factory.seg("关注自然语言处理、语音识别、深度学习等方向的前沿技术和业界动态。");
//
//        // 打印分词结果
//        for (String word : words) {
//            System.out.print(word + " ");
//        }
//        System.out.println();
//    }
//}
