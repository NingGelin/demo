package com.example.demo.practice;

import java.io.*;
import java.util.Arrays;


public class Hello {
    public static void main(String[] args)
    {
        Class person = Person.class;
        try
        {
            System.out.println(person.getDeclaredField("name"));
        }
        catch (NoSuchFieldException e)
        {
            e.printStackTrace();
        }
    }

    static byte[] toGBK(String s) throws UnsupportedEncodingException
    {
        return s.getBytes("UTF-8");
    }

    // 序列化
    public static void writeObj(Person p) {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("E://1.txt"));
            objectOutputStream.writeObject(p);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 反序列化
    public static Person readObj() {
        Person p = null;
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("E://1.txt"));
            try {
                p = (Person)objectInputStream.readObject();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return p;
    }
}

class Person implements Serializable {
    private static final long serialVersionUID = 8241970228716425282L;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + "]";
    }
}

class Score {
    private int[] scores;
    public Score(int ... scores) {
        this.scores = scores;
    }

    public void printScores() {
        System.out.println(Arrays.toString(scores));
    }
}
