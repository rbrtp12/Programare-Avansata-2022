package com.company;

public class Main {

    public static void main(String[] args) {

        System.out.println("Hello World");
        String languages[] = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        //Operations op1 = new Operations();
        int n = (int) (Math.random() * 1_000_000);
        int result = ((n * 3) + 0b10101 + 0xFF) * 6;
        System.out.println(result);
        System.out.println(Operations.digitSum(result));
        System.out.println("Willy-nilly, this semester I will learn " + languages[Operations.digitSum(result)]);

    }
}

