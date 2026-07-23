import java.lang.StringBuilder;

public class Main{
    
    static String removeAdjacents(String s){
        if(s.length()<=1)
            return s;
        
        StringBuilder res = new StringBuilder();

        for(int i = 0; i<s.length(); i++){
            char currentChar = s.charAt(i);
            int lastIndex = res.length()-1;

            if(res.length()>0&& currentChar==res.charAt(lastIndex))
                res.deleteCharAt(lastIndex);
            else
                res.append(currentChar);
        }

        return res.toString();
    }

    public static void main(String[] args){
        System.out.print(removeAdjacents("ddaccba"));
    }
}