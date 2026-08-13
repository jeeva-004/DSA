import java.util.ArrayDeque;
import java.util.Deque;

public class Main{
    
    static String removeKDigits(String num, int k){
        if(num.length() == k)
            return "0";
        
        int j = 0, digit = 0;
        Deque<Integer> dStack = new ArrayDeque<>();

        for(int i = 0; i<num.length(); i++){
            digit = Character.getNumericValue(num.charAt(i));
            while(!dStack.isEmpty() && dStack.peek() > digit && j<k){
                dStack.pop();
                j++;
            }
            dStack.push(Character.getNumericValue(num.charAt(i)));
        }

        while(j<k){
            dStack.pop();
            j++;
        }

        StringBuilder sb = new StringBuilder();

        while (!dStack.isEmpty()) {
            sb.append(dStack.pollLast());
        }

        j = 0;

        while(j<sb.length() && sb.charAt(j)=='0')
            j++;

        num = sb.substring(j);

        return num.isEmpty()?"0":num;
    }

    public static void main(String[] args){
        String num = "1432219";
        int k = 3;

        System.out.println(removeKDigits(num, k));
    }
}