package com.revature.models;

public class Cat{
    int age;
    String name;
    String race;
    
    public Cat(){
        
    }

    public Cat(String name){
        this.name = name;
    }

    public Cat(String name, int age, String race){
        this.name = name;
        this.age = age;
        this.race = race;
    }

    public String eat(String food){
        return "I'm eating " + food;
    }

    public String play(String toy){
        return "I'm playing with my " + toy;
    }

    public String scratch(String furn){
        return "I'm scratching the " + furn;
    }

    public String purr(){
        System.out.println("purrrrrrrrrrrr");
    }

    public void sleep(){
        System.out.println("zzzz");
    }
}
}