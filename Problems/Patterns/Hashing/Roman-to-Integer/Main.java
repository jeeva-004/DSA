import java.util.*;

// Symbol       Value
// I             1
// V             5
// X             10
// L             50
// C             100
// D             500
// M             1000


public class Main{
    static int romanToInt(String s){
        
        HashMap<Character, Integer> kv = new HashMap<>();

        kv.put('I', 1);
        kv.put('V', 5);
        kv.put('X', 10);
        kv.put('L', 50);
        kv.put('C', 100);
        kv.put('D', 500);
        kv.put('M', 1000);

        int integer = 0;

        for(int i = 0; i<s.length(); i++){
            int value = kv.get(s.charAt(i));

            if(i+1<s.length()&&value<kv.get(s.charAt(i+1)))
                integer-=value;
            else
                integer+=value;
        }

        return integer;
    }
    
    public static void main(String[] args) {
        String s = "LVIII";

        System.out.println(romanToInt(s));
    }
}