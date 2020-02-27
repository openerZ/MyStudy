package com.zmh;

public class Inner {

    private int a = 5;
    private static int c = 5;

    private String str;
    class ShanZha{
        //普通得内部类不能有static修饰的字段和方法
//        static int a=6;
        public ShanZha(){

        }

        private int b=c;
        public Inner getInner(){
            //使用外部类名.this生成外部类引用
            return Inner.this;
        }

    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    Inner(String str){
        this.str = str;
    }

    static class ChenPi{
        //静态内部类不能访问外部的非静态成员，只能访问静态属性
//        private int sa = a;
        private int sb= c;
    }
    public static void main(String[] args) {
        /*ShanZha shanZha = new Inner("你好").new ShanZha();
        Inner inner = shanZha.getInner();
        System.out.println(inner.getStr());*/

        Inner a = new Inner("啊啊");
        //非静态内部类需要先有外部类对象，通过这个外部类对象才能创建内部类对象
        ShanZha shanZha = a.new ShanZha();
        System.out.println(shanZha.getInner());
        System.out.println(a);
        System.out.println(a==shanZha.getInner());

        //静态内部类可以直接创建，不需要外部对象
        ChenPi chenPi = new ChenPi();
       /* Inner inner = new Inner();
        ShanZha shanZha = inner.new ShanZha();*/ //通过外部对象new 内部类
    }
}
