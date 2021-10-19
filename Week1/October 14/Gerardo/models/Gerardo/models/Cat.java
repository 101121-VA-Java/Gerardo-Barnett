package Gerardo.models;

public class Cat {
    public int age;
    public String name;
    public String race;

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

   
}