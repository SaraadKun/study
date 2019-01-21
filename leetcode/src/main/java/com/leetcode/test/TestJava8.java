package com.leetcode.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * All rights Reserved, Designed By SARAAD
 *
 * @version V1.0
 * @Title: TestJava8
 * @Package:com.leetcode.test
 * @Description:
 * @author: saraad
 * @date: 2019/1/14 23:10
 * @Copyright: 2019  Inc. All rights reserved.
 * PROJECT FOR PRACTICE
 */

public class TestJava8 {
    public static List<Emp> list = new ArrayList<>();
    static {
        list.add(new Emp("xiaoHong1", 20, 1000.0));
        list.add(new Emp("xiaoHong2", 25, 2000.0));
        list.add(new Emp("xiaoHong3", 30, 3000.0));
        list.add(new Emp("xiaoHong4", 35, 4000.0));
        list.add(new Emp("xiaoHong5", 38, 5000.0));
        list.add(new Emp("xiaoHong6", 45, 9000.0));
        list.add(new Emp("xiaoHong7", 55, 10000.0));
        list.add(new Emp("xiaoHong8", 42, 15000.0));
    }

    public static void println(Stream<Emp> stream) {
        stream.forEach(emp -> {
            System.out.println(String.format("名字：%s，年纪：%s，薪水：%s", emp.getName(), emp.getAge(), emp.getSalary()));
        });
    }

    public static void main(String[] args) {
        peek();
    }
//    public static void main(String[] args) {
//        // 对数组流，先过滤重复，在排序，再控制台输出 1，2，3
//        Arrays.asList(3, 1, 2, 1).stream().distinct().sorted().forEach(str -> {
//            System.out.println(str);
//        });
//        // 对list里的emp对象，取出薪水，并对薪水进行排序，然后输出薪水的内容，map操作，改变了Strenm的泛型对象
//        list.stream().map(emp -> emp.getSalary()).sorted().forEach(salary -> {
//            System.out.println(salary);
//        });
//        // 根据emp的属性name，进行排序
//        println(list.stream().sorted(Comparator.comparing(Emp::getName)));
//
//        // 给年纪大于30岁的人，薪水提升1.5倍，并输出结果
//        Stream<Emp> stream = list.stream().filter(emp -> {
//            return emp.getAge() > 30;
//        }).peek(emp -> {
//            emp.setSalary(emp.getSalary() * 1.5);
//        });
//        println(stream);
//        // 数字从1开始迭代（无限流），下一个数字，是上个数字+1，忽略前5个 ，并且只取10个数字
//        // 原本1-无限，忽略前5个，就是1-5数字，不要，从6开始，截取10个，就是6-15
//        Stream.iterate(1, x -> ++x).skip(5).limit(10).forEach(System.out::println);
//    }

    static void map(){
        List<Double> list = TestJava8.list.stream().map(Emp::getSalary).collect(Collectors.toList());
    }
    static void peek(){
        List<Emp> collect = list.stream().filter(o -> o.getAge() > 30).peek(o -> o.setSalary(o.getSalary() * 1.5)).collect(Collectors.toList());
        System.out.println(list.toString());
        System.out.println(collect.toString());
    }

    public static class Emp {
        private String name;

        private Integer age;

        private Double salary;

        public Emp(String name, Integer age, Double salary) {
            super();
            this.name = name;
            this.age = age;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public Double getSalary() {
            return salary;
        }

        public void setSalary(Double salary) {
            this.salary = salary;
        }

    }
}