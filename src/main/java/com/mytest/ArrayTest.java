package com.mytest;

import java.util.ArrayList;
import java.util.List;

public class ArrayTest {
    public static void main(String[] args) {
        //测试数组的协变性
        Person[] a = new Person[5];
        Student[] b= new Student[5];
//        Student[] b= (Student[]) a;

        //集合不具有协变性
        List<Person> l1 = new ArrayList<>();
        List<Student> l2 = new ArrayList<>();

        int az = 5;
    }
}


class Person{

}

class Student extends Person{

}