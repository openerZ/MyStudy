package com.zmh;

import org.junit.Test;

import java.util.HashMap;
import java.util.List;

public class Test02 {

    //常数变易法
    @Test
    public void printTangle() {

        for (int j = 0; j <7; j++) {
            for (int i = 0; i <7-j; i++) {
                System.out.print(" ");
            }
            for (int i = 0; i < j; i++) {
                System.out.print((char)('A'+i));
            }
            for (int i =j ; i>=0; i--) {
                System.out.print((char)('A'+i));
            }
            System.out.println();
        }
    }
    @Test
    public void T1(){
        StringBuilder s = new StringBuilder();
        s.append(1).append(",").append(3).append(",").append(6).append(",");
        System.out.println(s);
        String substring = s.substring(0, s.length()-1);
        System.out.println(substring);
    }

    private static int test() {
        int temp = 1;
        try {
            System.out.println(temp);
            return ++temp;  //如果finally里没有return会返回的是try暂存的值，如果finally有return会返回finally的值
        } catch (Exception e) {
            System.out.println(temp);
            return ++temp;
        } finally {
            ++temp;
            System.out.println(temp);
            return ++temp;
        }
    }
    @Test
    public void Test3(){
//        System.out.println(test());
        int i = -5;
//        i =  ++(i++);
//        i=++(2);  单目运算符无法后跟一个字面量
        System.out.println(i);
    }


    @Test
    public Menu getMenuTree(List<Menu> menuList) {
        HashMap<Integer, Menu> map = new HashMap<>();
        for (Menu menu : menuList) {
            map.put(menu.getId(),menu);
        }
        Menu root = null;
        for (Menu menu : menuList) {
            int pid = menu.getPid();
            if (pid!=0 && map.containsKey(pid)){
                Menu menu1 = map.get(pid);
                menu1.getChildren().add(menu);
            }else{
                root=menu;
            }
        }

        return root;
    }


}


class Menu {
    private int id; // 主键，菜单id
    private String name; // 菜单名称
    private int pid; // 菜单父id，根节点pid=0
    private List<Menu> children; // 下级菜单

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public List<Menu> getChildren() {
        return children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }
}

interface Map<K,V> {
    V get(Object key);
    V put(K key, V value);
}

class MyHashMap implements Map<Integer,Integer>{
    private class Entry{
        private Object K;
        private Object V;

        public Entry(){

        }

        public Entry(Object k, Object v) {
            K = k;
            V = v;
        }

        public Object getK() {
            return K;
        }

        public void setK(Object k) {
            K = k;
        }

        public Object getV() {
            return V;
        }

        public void setV(Object v) {
            V = v;
        }
    }

    private Entry[] ent;

    public MyHashMap(Integer cap) {
        this.ent = new Entry[cap];
    }

    public MyHashMap() {
        this.ent = new Entry[16];
    }

    @Override
    public Integer get(Object key) {

        return null;
    }

    @Override
    public Integer put(Integer key, Integer value) {
        return null;
    }
}