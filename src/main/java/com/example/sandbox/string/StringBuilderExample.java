package com.example.sandbox.string;

public class StringBuilderExample {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= 100; i++) {
            sb.append("String").append(i);
        }

        System.out.println(sb.toString());
    }
}