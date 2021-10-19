package com.revature.driver;

import com.revature.models.Cat;

public class Katty{

    public static void main(String[] args){
        Cat katty = new Cat();

        Cat patuda = new Cat("Patuda");

        Cat silver = new Cat("Silver", 9, "Siamese");

        System.out.println(patuda.name);
        System.out.println(silver.age);

        System.out.println(katty.eat("meat"));
        System.out.println(patuda.scratch("chair"));
        System.out.println(silver.purr);
        System.out.println(katty.play("rat"));
        patuda.sleep();
    }
}