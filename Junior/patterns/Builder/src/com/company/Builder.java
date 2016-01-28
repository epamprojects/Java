package com.company;

/**
 * Created by Mykolai_Lytvyn on 27.01.2016.
 */

/*
* Patter Builder return instance with with a portion default method
* */

 class PersonBuilder {
    private String name;
    private String secondName;
    private String status;

    public PersonBuilder(){

    };

    public PersonBuilder(String name, String secondName){
        this.name = name;
        this.secondName = secondName;
        this.status = "unknow";
    }

    @Override
    public String toString(){
        return "name: "  + this.name +
                " secondName: " + this.secondName+
                " status: " + this.status;

    };

    public String getName(){
       return  name;
    };

    public String getSecondName(){
        return  secondName;
    };
}
