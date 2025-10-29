public class RecursiveBinaryNumber1 {
    public static int countOnes(int n) {
        if (n == 0) {
            return 0;
        } else {
            return countOnes(n / 2) + (n % 2);
        }
    }
    public static void main(String[] args) {

        int number = 23; // Example number

        System.out.println("Number of 1s in binary representation of " + number + " is: " + countOnes(number));
    }
}
