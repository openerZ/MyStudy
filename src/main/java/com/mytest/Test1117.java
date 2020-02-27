package com.mytest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Test1117 {

    public static void main(String[] args) {
        List<String> a = new ArrayList<>();
        a.add("as");
        a.add("as");
        a.add("as");
        a.add("as");
        a.add("asas");

        System.out.println(a);
    }

}


class Java{

    public Java() {
        f();
    }

    void f(){
        System.out.println("你好，我说java");
    }

}

class Scala extends Java{

    private String a = "我是Scala";

    @Override
    void f() {
        System.out.println(a);
    }

    public static void main(String[] args) {
        new Scala(); //打印null
    }
}