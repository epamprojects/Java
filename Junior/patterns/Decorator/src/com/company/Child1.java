package com.company;

/**
 * Created by Mykolai_Lytvyn on 27.01.2016.
 */
public class Child1 implements Parent {
    private Parent previousChild;

    public Child1(){
        System.out.println("Child1 constructor without params");
    }
    public Child1(Parent parent) {
         this.previousChild = parent;
        System.out.println("Child1 constructor with params");
    };

    public Parent getPreviousClass() {
        return previousChild;
    }
}
