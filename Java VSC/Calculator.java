public class Calculator{
    public static void main(String []args) {
        
        
        int a = 10;
        int b = 5;
        int sum = add(a=b);
        int sub= subtract(a, b);
        int mul= multiply(a, b);
        int r = remainder(a, b);
        System.out.println(sum);
        System.out.println(sub);
        System.out.println(mul);
        System.out.println(r);
        System.out.println("Day:" + weekday("Friday"));
        System.out.println("Countdown starting at");
        countdown(10);
        System.out.println("Greetings:");
        greeting("Gerardo");

    }

    public static int add(int a, int b){
           
        return a + b;
    }

    public static int subtract(int a, int b){
        return a - b;
    }

    public static double multiply(double a, double b){
        return a * b;
    }

    public static int remainder(int a, int b){
        return a % b;

    }

    static String weekday(String weekday)

 {

   String Day;	 
    switch(weekday) {
    case "Monday":
    Day = "It's Monday";
    break;
    case "Tuesday":
    Day = "It's Tuesday";
    break;
    case "Wednesday":
    Day = "It's Wednesday";
    break;
    case "Thursday":
    Day = "It's Thursday";
    break;
    case "Friday":
    Day = "It's Friday";
    break;
    default:
    Day = "It is not a Weekday";
    break;    	
    }
    return Day;
 }	 

 public static void countdown(int startValue) {

int n;
for(n=startValue; n>=0; n--) { 
     System.out.println(n);
   }

}

 static void greeting(String name)
 {
 System.out.println(name);
 }


}
  
