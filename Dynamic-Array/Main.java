import java.util.*;

class DynamicArray {

}

public class Main {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        DynamicArray arr = new DynamicArray();
        int choise = 0;
        while (true) {
            System.out.println("-----------------List Menu-----------------");
            
            System.out.println("1. Insert at End");
            System.out.println("2. Display the List");
            System.out.println("3. Insert at the specified position");
            System.out.println("4. Delete at the specified position");
            System.out.println("5. Exit");

            System.out.println("--------------------------------------------");
            System.out.print("Enter you Choise");
            choise = s.nextInt();
            switch (choise) {
                case 1:
                    System.out.println("Enter a value: ");
                    int val = s.nextInt();
                    // arr.add(val);
                    break;
                case 2:
                    // arr.displayList();
                case 3:
                    System.out.println("Enter a position & element : (position start form 0):");
                    int pos = s.nextInt();
                    val = s.nextInt();
                    if(pos<0){
                        System.out.println("Enter a positive position. Position start from 0");
                    pos = s.nextInt();
                    }
                    // else
                        // arr.insertElement(pos, element);
                case 4:
                    System.out.println("Enter a position : (postion start from 0)");
                    pos = s.nextInt();
                    if(pos<0){
                        System.out.println("Enter a positive position. Position start from 0");
                    pos = s.nextInt();
                    }
                    // arr.removeElement(pos);
                case 5:
                    System.exit(0);
            
                default:
                    break;
            }
        }
    }
}