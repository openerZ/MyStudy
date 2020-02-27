package com.mytest;

import javax.swing.plaf.PanelUI;
import java.util.ArrayList;

public interface StaticInte {


    default void fun(){
        System.out.println("接口的默认的方法");
    }

     //接口的成员变量默认限定为public final static （也只能是）
     public final static int a=5;

      ArrayList list = new ArrayList();
     void C();
}

class si implements StaticInte{

    int b= StaticInte.a;
    @Override
    public void C() {

    }

    private void C(int i){

    }
}

class FPX{
    public FPX(int a){
        System.out.println(a);
    }
    FPX(){
        System.out.println("asa");
    }
}

class G2 extends FPX{

    private static void aa(){

    }

    public G2(int a) {
        super(a);  //子类必须调用父类的构造函数，如果父类有有参构造并且没有无参构造或默认构造必须super(参数)显式调用

        aa();
    }
}