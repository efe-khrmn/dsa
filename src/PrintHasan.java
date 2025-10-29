public class PrintHasan {
    public static void main(String[] args) {
        printHasan();
    }

    public static void printHasan() {
        for (int j = 0; j < 5; j++) {
            for (int i = 0; i < 20; i++) {
                if (j == 0) {
                    if (i == 0 || i == 3 || i == 4 || i == 5 || i == 6 || i == 7 || i == 8 || i == 9 || i == 10 || i == 11
                            || i == 12 || i == 13 || i == 14 || i == 15 || i == 16 || i == 19) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                } else if (j == 1) {
                    if (i == 0 || i == 3 || i == 4 || i == 7 || i == 8
                            || i == 12 || i == 15 || i == 16 || i == 17 || i == 19) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                } else if (j == 2) {
                    if (i == 0 || i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i == 6 || i == 7 || i == 8 || i == 9 || i == 10 || i == 11
                            || i == 12 || i == 13 || i == 14 || i == 15 || i == 16 || i == 18 || i == 19) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                } else if (j == 3) {
                    if (i == 0 || i == 3 || i == 4 || i == 7 || i == 11
                            || i == 12 || i == 15 || i == 16 || i == 18 || i == 19) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                } else if (j == 4) {
                    if (i == 0 || i == 3 || i == 4 || i == 7 || i == 8 || i == 9 || i == 10 || i == 11
                            || i == 12 || i == 15 || i == 16 || i == 19) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                }
            }
            System.out.println();
        }
    }
}
