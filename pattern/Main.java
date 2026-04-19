class Main {
    static void pattern1(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void pattern2(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void pattern3(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    static void pattern4(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i);
            }
            System.out.println();
        }
    }

    static void pattern5(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void pattern6(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i + 1; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    static void pattern7(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i + 1; j++) {
                System.out.print(" ");
            }

            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }

            for (int j = 1; j <= i - 1; j++) {
                if (i == 1)
                    continue;
                else
                    System.out.print("*");
            }
            System.out.println();
        }
    }

    static void pattern8(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(" ");
            }

            for (int j = 0; j <= n - i; j++) {
                System.out.print("*");
            }

            for (int j = 0; j <= n - i - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void pattern9(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i + 1; j++) {
                System.out.print(" ");
            }

            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }

            for (int j = 1; j <= i - 1; j++) {
                if (i == 1)
                    continue;
                else
                    System.out.print("*");
            }
            System.out.println();
        }

        for (int k = 1; k <= n; k++) {
            for (int j = 1; j <= k; j++) {
                System.out.print(" ");
            }

            for (int j = 1; j <= n - k + 1; j++) {
                System.out.print("*");
            }

            for (int j = 1; j <= n - k; j++) {
                if (j == n)
                    continue;
                System.out.print("*");
            }

            System.out.println();
        }
    }

    static void pattern10(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        for (int k = 1; k <= n - 1; k++) {
            for (int j = 1; j < n - k + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        outer:
        // for (int i = 1; i <= 5; i++) {
        // inner:
        // for (int j = 1; j <= 40; j++) {
        // if (i == 1 || i == 5)
        // System.out.print("-");

        // if ((i >= 2 && i < 5) && (j == 1 || j == 39))
        // System.out.print("|");

        // if ((i == 2 || i == 4) && (j != 1 || j != 39))
        // System.out.print(" ");

        // if (i == 3) {
        // if ((2 >= j) && (j <= 16) || (31 >= j) && (j < 38)) {
        // System.out.print(" ");
        // }
        // if (j == 17) {
        // System.out.print("Welcome");
        // }
        // }
        // }
        // System.out.println("");
        // }

        pattern10(4);

    }
}