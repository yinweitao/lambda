package com.example.demo;

import org.junit.Test;

import javax.lang.model.type.IntersectionType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author yinweitao
 * @classname TestLambda3
 * @description
 * @date 2019/4/16/15:17
 **/

/*
*java8 内置的四大核心函数式接口
* Consumer<T>: 消费型接口
*          void accept(T t);
*
* Supplier<T> :供给型接口
*          T get();
*
* Function<T,R>：函数型接口
*          R apply(T t);
*
* Predicate<T> :断言型接口
*          boolean test(T t);
 */
public class TestLambda3 {

    //Predicate<T> :断言型接口
    @Test
    public void test4() {
         List<String> list = Arrays.asList("hello","kdk","lambda","ok");
         List<String> strList = filterSter(list,(s)->s.length()>2);
         for(String str:strList){
             System.out.println(str);
         }
    }

    //将满足条件的字符串，放入集合中
    public List<String> filterSter(List<String> list, Predicate<String> pre) {
        List<String> strList = new ArrayList<>();
        for (String str : list) {
            if (pre.test(str)) {
                strList.add(str);
            }
        }
        return strList;
    }

    //Function<T,R>：函数型接口
    @Test
    public void test3() {
        String newStr = strHandler("\t\t\t 威武  ", (str) -> str.trim());
        System.out.println(newStr);
    }

    //用于处理字符串
    public String strHandler(String str, Function<String, String> fun) {
        return fun.apply(str);
    }

    //Supplier<T> 供给型接口
    @Test
    public void test2() {
        List<Integer> list = getNumberList(10, () -> (int) (Math.random() * 1000));
        for (Integer num : list) {
            System.out.println(num);
        }
    }

    //产生随机整数，放入list中去
    public List<Integer> getNumberList(int num, Supplier<Integer> sup) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            list.add(sup.get());
        }
        return list;
    }

    //Consumer<T> 消费型接口
    @Test
    public void test1() {
        happy(1000, (m) -> System.out.println("消费：" + m + "元"));
    }

    public void happy(double money, Consumer<Double> con) {
        con.accept(money);
    }
}
