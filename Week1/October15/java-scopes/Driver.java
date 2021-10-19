public class Driver{
    public static void main(String[] args){
       // for(int i = 0; i < 10; i++){
        //    System.out.println(i);
       // }

       // saySomething();

        //System.out.println(s);

      int i = 0;

      plusTwo(i);

      System.out.println("i = " + i);

      User u = new User();

      u.name = "Gerardo";

      //setNameToKevin(u);

      //System.out.println(u.name);

      System.out.println(u.sayMyName());

      Driver.sayStatic();

      System.out.println(u.numberOfUser);

      System.out.println(User.numberOfUser);

    }

    public static void saySomething(){
        String s = "Hello";

        System.out.println(s);
    }

    public static void plusTwo(int i){
        i = i + 2;
        System.out.println(i);
    }

    public static void setNameToKevin(User u){
        u.name = "Gerardo";
        System.out.println(u.name);
    }

    public static void sayStatic(){
        System.out.println("Hello");
    }

}