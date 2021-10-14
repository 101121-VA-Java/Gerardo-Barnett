public class ArrayBasics{
    public static void main(String[] args){
        System.out.println("Hello World!");
        String[] names = {"Andrew","Kim","Alex","Andre"};
        String[] batch = new String[3];
        System.out.println("This is the third element: " + names[2]);
        System.out.println("This is the size of batch: " + batch.length + ", this is element at index 1: " +batch[1]); 

        // Print all elements of names Array
        for(int i = 0; i < names.length; i++){
            if(names[i].equals("Andrew") || names[i].equals("Alex")){
                System.out.Println("Yay! This is " +names[i]);

            }
            else{
                System.out.Println("Dang it! This is " +names[i]);
            }
           
            String s = (names[i].equals("Kim")) ? "KIMKIMKIM" : "Not Kim";
            System.out.println(s);
        }
    }
}