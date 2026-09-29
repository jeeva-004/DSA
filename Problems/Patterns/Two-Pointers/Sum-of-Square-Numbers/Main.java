public class Main{
    // Given a non-negative integer c, decide whether there're two integers a and b such that a2 + b2 = c.
    static boolean judgeSqureSum(int c){
        for(long a = 0; a*a<=c; a++){
            long remainder = c - (a*a);
            long b = (long) Math.sqrt(remainder);

            if(b*b==remainder)
                return true;
        }

        return false;
    }

    public static void main(String[] args){
        int c = 5;
        System.out.print(judgeSqureSum(c));
    }
}