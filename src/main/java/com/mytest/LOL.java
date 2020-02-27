package com.mytest;

public class LOL {

    public void play(){
        XiaoPao xiaoPao = new XiaoPao();
//        xiaoPao.She();
    }

    static int a=5;
    int a1=5;
    final static String str = "aaaa";

    /**
     * 成员内部类(可以当作普通的成员变量)：
     *  1.可以访问外部类的所有的成员属性和成员方法(包括private成员和静态成员)
     *  2.不能拥有静态成员和静态方法
     *  3.可以拥有所有的权限访问修饰符
     */
    public class XiaoPao{

//        public static int a=5;

        /*static void HJTY(){

        }*/

        int b =a;
        private String s = str;
        public void She(){
            play();
        }

        private void Beidong(){
            System.out.println("增加射程");
        }
    }

    /**
     * 静态内部类(静态成员内部类):
     *  1.只能访问外部的静态成员和静态方法
     *  2.可以创建静态和非静态的成员和方法
     *  3.不依赖于外部类
     *  ps：static 修饰类时只能修饰静态成员内部类，不能修饰顶级类
     */
    static class AnNi{

        static int x =a;
//        int x1 = a1;

        public  void TiBos(){

        }
    }

    /**
     * 内部成员抽象类
     */
    abstract static class A{

    }
    public void JiaoYue(StringBuilder name){
        /**
         * 局部内部类(可以当作方法的局部变量)：定义在方法内或者作用域中
         *   不能有访问修饰符和static的
         *
         */
        class DaiAnNA{
            StringBuilder myname  = name;
        }

        DaiAnNA daiAnNA = new DaiAnNA();
        System.out.println(daiAnNA.myname);

    }

    public void ShuGuang(XiaoPao xp){

        /**
         * 匿名内部类
         *  ；没有名字所以不能手写构造函数
         *  不能有访问修饰符和static
         *
         */
        Phone phone = new Phone() {
            @Override
            public void phone() {
                System.out.println(xp.b);
            }
        };
        phone.phone();

    }

    public static void main(String[] args) {
        LOL lol = new LOL();
//        lol.JiaoYue(new StringBuilder("赵明辉"));
        XiaoPao xiaoPao = lol.new XiaoPao();
        lol.ShuGuang(xiaoPao);
    }

}

//不能修饰外部类(顶级类)
/*static class BB{

}*/

