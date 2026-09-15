import java.util.*;

public class Main{
    
    static boolean backSpaceCompare(String s, String t){
        Deque<Character> forS = new ArrayDeque<>();
        Deque<Character> forT = new ArrayDeque<>();
        int i = 0;
        for(i = 0; i<s.length(); i++){
            if(forS.isEmpty() && s.charAt(i)=='#')
                continue;
            
            if(!forS.isEmpty() && s.charAt(i) == '#')
                forS.pop();
            else
                forS.push(s.charAt(i));
        }

        for(int j = 0; j<t.length(); j++){
            if(forT.isEmpty() && t.charAt(j)=='#')
                continue;
            
            if(!forT.isEmpty() && t.charAt(j) == '#')
                forT.pop();
            else
                forT.push(t.charAt(j));
        }

        if(forT.size() != forS.size())
            return false;
        
        for(i = 0; i<forS.size(); i++)
        {
            if(forS.peek() == forT.peek()){
                forS.pop();
                forT.pop();
            }
            else    
                return false;
        }

        return true;
    }

    public static void main(String[] args){
        String s = "ab#c", t = "ad#c";

        System.out.print(backSpaceCompare(s, t));
    }
}