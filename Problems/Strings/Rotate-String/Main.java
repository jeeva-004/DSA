import java.lang.StringBuilder;

public class Main{
    
    static boolean rotateString(String s, String goal){
        if(s.length()!=goal.length())
            return s.equals(goal)?true:false;

        StringBuilder str = new StringBuilder(s);

        for(int i = 0; i<s.length(); i++){
            char firstChar = s.charAt(0);
            str.deleteCharAt(0);
            str.append(firstChar);  
        
            if(str.toString().equals(goal))
                return true;
        }

        return false;
    }
    
    public static void main(String[] args) {
        String s = "abcde", goal = "cdeab";
        
        System.out.print(s, goal);
    }
}