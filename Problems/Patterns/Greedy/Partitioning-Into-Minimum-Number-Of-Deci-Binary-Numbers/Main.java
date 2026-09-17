public class Main {

    static int minPartitions(String n) {
        char maxDigit = '0';

        for(int i = 0; i<n.length(); i++)
            maxDigit = maxDigit<n.charAt(i)?n.charAt(i):maxDigit;
        
        return Character.getNumericValue(maxDigit);
    }

    public static void main(String[] args) {
        String n = "392";
        System.out.print(minPartitions(n));
    }
}