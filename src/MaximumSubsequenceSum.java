public class MaximumSubsequenceSum {
    public static int maxSubsequenceSum(int[] arr){
        int sumSoFar = 0 , maxSum = 0;
        for (int num : arr){
            sumSoFar += num;

            if (sumSoFar > maxSum){
                maxSum = sumSoFar;
            } else if (sumSoFar < 0){
                sumSoFar = 0;
            }

        }
        return maxSum;
    }
    public static void main(String[] args) {
        int[] arr = {-2, 11, -4, 13, -5, -2};
        System.out.println("Maximum Subsequence Sum is: " + maxSubsequenceSum(arr));
    }
}
