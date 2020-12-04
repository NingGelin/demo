package com.example.demo;

public class TempTest {
    public static void main(String[] args) {
        String price = "255.00";

        if (Double.valueOf(price) < 0)
        {
            System.out.println("error");
        }
        else
        {
            System.out.println(Double.valueOf(price));
        }
    }
}
