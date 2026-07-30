public class Main{
    
    static int minimumPushes(String word){
        int pushes = 0;

        for(int i = 0; i<word.length(); i++)
            pushes+= (i/8) + 1;

        return pushes;
    }

    public static void main(String[] args){
        String word = "abcde";

        System.out.println(minimumPushes(word));

    }
}