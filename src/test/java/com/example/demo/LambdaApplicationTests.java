package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Comparator;
import java.util.function.Consumer;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LambdaApplicationTests {
    /*
	* 一、lambda 表达式的基本语法：lava8中引入了一个新的操作符“->" 该操作符称为箭头操作符 或者 lambda 操作符
	*
	* 左侧：lambda 表达式的参数列表
	* 右侧：lambda表达式中所需要执行的功能，即lambda体
	*
	* 语法格式一：无参数，无返回值
	*        ()->System.out.print("hello lambda!");
	*
	 */

    @Test
    public void contextLoads() {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello world!");
            }
        };
        r.run();
        System.out.println("----------------------");
        Runnable r1 = () -> System.out.println("hello lambda!");
        r1.run();

        Consumer<String> con = (x) -> System.out.println(x);
        con.accept("java 威武！");

        Consumer<String> con1 = x -> System.out.println(x);
        con1.accept("java 威武！");

        Comparator<Integer> com =(x,y)->{
            System.out.println("函数式接口");
            return Integer.compare(x,y);
        };
        System.out.println(com.compare(2,3));
    }

}
