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

    static void pattern11(int n) {
        int start = 1;
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0)
                start = 0;
            else
                start = 1;
            for (int j = 1; j <= i; j++) {
                System.out.print(start + " ");
                start = 1 - start;
            }
            System.out.println();
        }
    }

    static void pattern12(int n) {
        int insSpaces = (2 * n) - 2;
        for (int i = 1; i <= n; i++) {
            // numbers
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            // spaces
            for (int j = 1; j <= insSpaces; j++) {
                System.out.print("-");
            }

            // numbers
            for (int j = i; j >= 1; j--) {
                System.out.print(j);
            }
            System.out.println();
            insSpaces -= 2;
        }
    }

    static void pattern13(int n) {
        int previousNum = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0)
                previousNum = 1;
            for (int j = 0; j <= i; j++) {
                System.out.print(previousNum + " ");
                previousNum++;
            }
            System.out.println();
        }
    }

    static void pattern14(int n) {
        for (int i = 0; i < n; i++) {
            for (char c = 'A'; c <= 'A' + i; c++) {
                System.out.print(c);
            }
            System.out.println();
        }

    }

    static void pattern15(int n) {
        for (int i = 0; i < n; i++) {
            char c = 'A';
            for (int j = 0; j <= n - i - 1; j++) {
                System.out.print((char) (c + j));
            }
            System.out.println();
        }
    }

    static void pattern16(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print((char) ('A' + i));
            }
            System.out.println();
        }
    }

    static void pattern17(int n) {
        for (int i = 0; i < n; i++) {
            // spaces
            for (int j = 0; j <= n - i - 1; j++) {
                System.out.print(" ");
            }

            // alphabets
            char c = 'A';
            int breakPoint = i + 1;
            for (int j = 1; j <= i * 2 + 1; j++) {
                System.out.print(c);
                if (j >= breakPoint)
                    c--;
                else
                    c++;
            }

            // spaces
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    static void pattern18(int n) {
        for (int i = 0; i < n; i++) {
            for (char c = (char) ('E' - i); c <= 'E'; c++) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }

    static void pattern19(int n) {
        int intSpaces = 0;
        for (int i = 0; i < n; i++) {
            // stars
            for (int j = 1; j <= n - i; j++) {
                System.out.print("*");
            }
            // spaces
            for (int j = 1; j <= intSpaces; j++) {
                System.out.print(" ");
            }

            // stars
            for (int j = 1; j <= n - i; j++) {
                System.out.print("*");
            }
            System.out.println();
            intSpaces += 2;
        }

        intSpaces = 2 * n - 2;
        for (int i = 0; i < n; i++) {
            // stars
            for (int j = 1; j <= i + 1; j++) {
                System.out.print("*");
            }

            // spaces
            for (int j = 1; j <= intSpaces; j++) {
                System.out.print(" ");
            }

            // stars
            for (int j = 1; j <= i + 1; j++) {
                System.out.print("*");
            }

            intSpaces -= 2;
            System.out.println();
        }
    }

    static void pattern20(int n) {
        int intSpaces = 2 * n - 2;
        for (int i = 0; i < n; i++) {
            // stars
            for (int j = 1; j <= i + 1; j++) {
                System.out.print("*");
            }

            // spaces
            for (int j = 1; j <= intSpaces; j++) {
                System.out.print(" ");
            }

            for (int j = 1; j <= i + 1; j++) {
                System.out.print("*");
            }

            intSpaces -= 2;
            System.out.println();
        }
        intSpaces = 2;
        for (int i = 0; i < n; i++) {
            // stars
            for (int j = 1; j <=n-i-1; j++) {
                System.out.print("*");
            }

            // spaces
            for (int j = 1; j <= intSpaces; j++) {
                System.out.print(" ");
            }

            for (int j = 1; j <= n-i-1; j++) {
                System.out.print("*");
            }

            intSpaces += 2;
            System.out.println();
        }

    }

    static void pattern21(int n){
        for(int i = 0; i<n; i++){
            for(int j=0; j<n; j++){
                if(j==0||i==0||i==n-1||j==n-1)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }
    
    static void pattern22(int n){
        for(int i=0; i<2*n-1; i++){
            for(int j=0; j<2*n-1; j++){
                int top = i, left = j, right = (2*n)-2-j, bottom = (2*n)-2-i;

                System.out.print(n-Math.min(Math.min(top, bottom), Math.min(right, left)));
            }   
            
            System.out.println();
        }
    }
    
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

        pattern22(4);

    }
}