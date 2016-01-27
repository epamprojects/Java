package com.company;

import com.company.Parent;

public class Child2 implements Parent {
    private Parent previousChild;

    public Child2(){
        System.out.println("Child2 constructor without params");
    }

    public Child2(Parent parent) {
        this.previousChild = parent;
        System.out.println("Child2 constructor with params");
    };

    public Parent getPreviousClass() {
        return previousChild;
    }
}
