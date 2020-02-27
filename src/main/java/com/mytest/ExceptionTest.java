package com.mytest;

public class ExceptionTest {

    static void f(){
        try{
            throw new RuntimeException();
        }catch (Exception e){
            //打印栈轨迹
            e.printStackTrace();
            System.out.println("我说catch");

        }finally {
            System.out.println("我是finally");
        }
//       throw new RuntimeException();
    }

    static void g(){
        f();
    }

    static void h(){
        g();
    }

    static String z(int i){
        try {
            if (i==0){
                throw new Exception();
            }
            return "赵明辉加油";
        }catch (Exception e){
            return "不要传0";

        }finally { //finally总是执行
            return "小伙子加油";
        }

    }

    public static void main(String[] args) {
//        h();
        System.out.println(z(0));
    }

}
