public class Main {

    static boolean lemanadeChange(int[] bills) {

        int fives = 0, tens = 0;

        for (int n : bills) {
            if (n == 5)
                fives++;
            else if (n == 10) {
                if (fives <= 0)
                    return false;
                fives--;
                tens++;
            } else {
                if (fives <= 0)
                    return false;
                else if (tens > 0 && fives > 0) {
                    tens--;
                    fives--;
                } else {
                    if (fives < 3)
                        return false;
                    fives -= 3;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] bills = { 5, 5, 5, 10, 20 };
        System.out.print(lemanadeChange(bills));
    }
}