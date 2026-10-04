import java.util.*;

public class Main{
    
    static boolean isValid(String s){
        HashMap<Character,Character> pairs = new HashMap<>();
        pairs.put('(', ')');
        pairs.put('{', '}');
        pairs.put('[', ']');

        Deque<Character> stack = new ArrayDeque<>();

        for(int i = 0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(pairs.containsKey(ch))
                stack.push(ch);
            else if(!stack.isEmpty() && pairs.containsKey(stack.peek()) && pairs.get(stack.peek())==ch){
                stack.pop();
            }
            else
                return false;
        }

        return stack.isEmpty();
    }

    public static void main(String[] args){
        String s = "{}";

        System.out.print(isValid(s));
    }
}