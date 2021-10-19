package Gerardo.driver;

import Gerardo.models.Gerardo.models.Cat;

public class Katty{

    public static void main(String[] args){
        

        Cat katty = new Cat("Katty", 10 , "Siamese");

        Cat patuda = new Cat("Silver", 9 , "Siamese");

        System.out.println(katty.name);
        System.out.println(katty.age);
        System.out.println(katty.race);

        System.out.println(patuda.name);
        System.out.println(patuda.age);
        System.out.println(patuda.race);

        System.out.println(katty.eat("meat"));
        System.out.println(katty.scratch("chair"));
        System.out.println(katty.play("rat"));

        System.out.println(patuda.eat("chicken"));
        System.out.println(patuda.scratch("sofa"));
        System.out.println(patuda.play("bell"));


    }
}