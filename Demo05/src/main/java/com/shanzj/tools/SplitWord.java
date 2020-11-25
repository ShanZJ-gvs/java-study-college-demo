package com.shanzj.tools;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class SplitWord {

    public static Map<String, String> SplitWord(String filePath, String rule) {
        //读取文件
        String s = ReadFile.readFile(filePath);
        //拆分字符串
        String[] str = s.split(rule);
        //打印数组进行查看
        System.out.println(Arrays.toString(str));
        //执行countWord方法返回一个HashMap
        return countWord(str);
    }

    public static Map<String, String> countWord(String[] str){
        //将str压缩，使得单词不会重复
        HashMap<String, String> wordsHashMap = new HashMap<String, String>();
        for (int i = 0; i < str.length;i=i+2) {
            wordsHashMap.put(str[i],str[i+1]);
        }

        return wordsHashMap;
    }

}
