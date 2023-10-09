package ru.example;

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        MyOwnArrayList<Integer> myOwnArrayList = new MyOwnArrayList<>();
        System.out.println(myOwnArrayList.size());
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            myOwnArrayList.add(i);
        }

        System.out.println(myOwnArrayList.get(4));



    }
}