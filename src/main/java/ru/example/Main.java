package ru.example;

public class Main {
    public static void main(String[] args) {

        MyOwnArrayList<Integer> myOwnArrayList = new MyOwnArrayList<>();
        System.out.println(myOwnArrayList.size());

        for (int i = 0; i < 10; i++) {
            myOwnArrayList.add(i);
        }

    }
}