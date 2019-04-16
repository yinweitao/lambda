package com.example.demo;

/**
 * @author yinweitao
 * @classname TestMethodRef
 * @description
 * @date 2019/4/16/16:46
 **/

import net.bytebuddy.asm.Advice;
import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * 方法引用：若lambda 体中的内容有方法实现了，我们可以使用“方法引用”
 *
 * 主要有三种语法格式：
 *
 * 对象::实例方法名
 *类::静态方法名
 * 类::实例方法名
 */
public class TestMethodRef {
    //数组引用
    @Test
    public void test4(){
        Function<Integer,String[]>fun = (x)->new String[x];
        String[] strs= fun.apply(10);
        System.out.println(strs.length);

        Function<Integer,String[]>fun1=String[]::new;
        String[] strs2= fun1.apply(20);
        System.out.println(strs2.length);
    }
    //类::实例方法名
    @Test
    public void test3(){
        BiPredicate<String,String> bp=(x,y)->x.equals(y);
        BiPredicate<String,String>bp1=String::equals;
    }

    //类::静态方法名
    @Test
    public void test2(){
        Comparator<Integer> com=(x,y)->Integer.compare(x,y);
        Comparator<Integer> com1=Integer::compare;
    }

    //对象::实例方法名
    @Test
    public void test1(){
        PrintStream ps = System.out;
        Consumer<String> con = (x)->ps.println(x);

        Consumer<String> con1= ps::println;

        Consumer<String> con2= System.out::println;
    }
}
