public class User{
    public String name;
    public static int numberOfUser;

    public User(String name){
        this.name = name;
        numberOfUser++;
        
    }

    public User(){
       numberOfUser++;

    }

    public String sayMyName(){
        return name;
    }


}