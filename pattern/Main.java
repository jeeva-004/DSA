package pattern;

class Main {
    public static void main(String[] args) {
        outer:
        for (int i = 1; i <= 5; i++) {
            inner:
            for (int j = 1; j <= 40; j++) {
                if (i == 1 || i == 5)
                    System.out.print("-");

                if ((i >= 2 && i < 5) && (j == 1 || j == 39))
                    System.out.print("|");

                if ((i == 2 || i == 4) && (j != 1 || j != 39))
                    System.out.print(" ");

                if (i == 3) {
                    if ((2 >= j) && (j <= 16) || (31 >= j) && (j < 38)) {
                        System.out.print(" ");
                    }
                    if (j == 17) {
                        System.out.print("Welcome");
                    }
                }
            }
            System.out.println("");
        }


    }
}