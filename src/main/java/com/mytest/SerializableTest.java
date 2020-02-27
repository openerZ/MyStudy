package com.mytest;

import java.io.*;

public class SerializableTest {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        //序列化
//        serialize();
        //反序列化
        decreSerialize();
    }

    /**
     * 序列化对象
     */
    public static void serialize() throws IOException {
        DataObject obj = new DataObject();
        obj.setWord("zmhzmh");
        DataObject.setI(23);

        System.out.println(obj.toString());

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("E:/dd.txt"));
        oos.writeObject(obj);
        System.out.println("对象序列化成功！");
        oos.close();

    }

    /**
     * 反序列化
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static void decreSerialize() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("E:/dd.txt"));
        DataObject o = (DataObject) ois.readObject();
        System.out.println("对象反序列化成功！");
        System.out.println(o.toString());
        ois.close();
    }
}


class DataObject implements Serializable {

    //主要用于反序列标识用，该序列号在反序列化过程中用于验证序列化对象的发送者和接收者是否为该对象加载了与序列化兼容的类
    private static final long serialVersionUID=22L;

    //静态字段不会被序列化
    private static int i=555;
    private String word=" ";
    public void setWord(String word){
        this.word=word;
    }
    public static void setI(int i){
        DataObject.i=i;
    }

    @Override
    public String toString() {
        return "i="+DataObject.i+"word="+word;
    }
}