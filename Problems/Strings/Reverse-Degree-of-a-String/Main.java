public class Main{
    
    static int reverseDegree(String s){
        int[] reversedAlpha = new int[26];

        int val = 26;

        for(int i = 0; i<reversedAlpha.length; i++)
            reversedAlpha[i] = val--;
        
        int reversedDegree = 0;

        for(int c = 0; c<s.length(); c++){
            val = s.charAt(c) - 'a';
            reversedDegree+= reversedAlpha[val] * (c+1);
        }

        return reversedDegree;
    }

    public static void main(String[] args){
        String s = "abc";

        System.out.print(reverseDegree(s));
    }
}