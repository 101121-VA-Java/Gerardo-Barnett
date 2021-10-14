public class StringArray{
    public static void main(String[] args){
        String[] Room1 = {"Alex", "Brayden", "Albert", "Gerardo", "Kim"};
        String[] reversed = reversedRoom1(Room1);
        for(int j = 0; j < Room1.length; j++){
            System.out.println("The names in reverse are: " + reversed[j]);
        }

    }
    public static String[] reversedRoom1(String[] a){
        
        int i = a.length;
        int y = 0;
        String[] reverseRoom1 = new String[i];
        while(i > 0)
        {
            reverseRoom1[y] = a[i-1];
            i--;
            y++;
        }

        return reverseRoom1;
    }
}