package com.xf.test;

import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * All rights Reserved, Designed By SARAAD
 *
 * @version V1.0
 * @Title: RepeatString
 * @Package:com.xf.test
 * @Description:
 * @author: saraad
 * @date: 2019/3/2 21:04
 * @Copyright: 2019  Inc. All rights reserved.
 * PROJECT FOR PRACTICE
 */
public class RepeatString {

    public static void  main(String[] args){
        String srcStr = "012夏夏芳芳0515夏芳12313夏芳21133";
        String replace = "夏芳";
        String delStr = srcStr.replace(replace, "");
        int count = 0;
        int temp = srcStr.split(replace).length -1;
        while (temp != 0){
            count += temp;
            temp = delStr.split(replace).length -1;
            delStr = delStr.replace(replace,"");
        }
        System.out.println("替换后的字符串:"+delStr);
        System.out.println("共替换掉:"+count+"个"+replace);
    }
//    public static void  main(String[] args){
//        String srcStr = "012夏夏芳芳0515夏芳12313夏芳21133";
//        String replace = "夏芳";
//        List<String> list = replaceStr(srcStr, replace);
//        System.out.println("替换后的字符串:"+list.get(0));
//        System.out.println("共替换掉:"+list.get(1)+"个"+replace);
//    }

    static List<String> replaceStr(String srcStr, String replace){
        if (StringUtils.isEmpty(srcStr)) return Collections.emptyList();
        int totalReplace = 0;
        List<String> list = new ArrayList<>(2);
        String delStr = srcStr.replace(replace, "");
        int count = srcStr.split(replace).length -1;
        totalReplace += count;
        if (count != 0){
            List<String> list2 = replaceStr(delStr, replace);
            totalReplace += Integer.parseInt(list2.get(1));
            delStr = list2.get(0);
        }
        list.add(0,delStr);
        list.add(1,totalReplace+"");
        return list;
    }

    static List<String> recursionMethod(List<String> list,String replace){
        if (CollectionUtils.isEmpty(list)) return Collections.emptyList();
        String srcStr = list.get(0);
        int total = Integer.parseInt(list.get(1));
        String delStr = srcStr.replace(replace, "");
        int count = srcStr.split(replace).length -1;
        list.set(0,delStr);
            list.set(1,String.valueOf(total + count));
        if (count != 0){
            return recursionMethod(list,replace);
        }
        return null;
    }

}
