package com.company;

public class Main {
    public static void main(String[] args) {
        Parent parent1 = new Child1();
        Parent parent2 = new Child2();

        Parent parent3 = new Child1(new Child2());

	// write your code here
    }
}
