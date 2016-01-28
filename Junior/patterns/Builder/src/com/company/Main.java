package com.company;

import sun.security.provider.certpath.Builder;

public class Main {

    public static void main(String[] args) {
        System.out.println(new PersonBuilder("name1","soname1"));
        System.out.println(new PersonBuilder("name2","soname2"));
    }
}
