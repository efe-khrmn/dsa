public class Permutation {
    public void permute(String str){
        char[] chars = str.toCharArray();
        permute(chars, 0, chars.length - 1);
    }
    private void permute(char[] str, int left, int right){
        if (left == right){
            System.out.println(new String(str));
        } else {
            for (int i = left; i <= right; i++){
                swap(str, left, i);
                permute(str, left + 1, right);
                swap(str, left, i); // backtrack
            }
        }
    }
    private void swap(char[] str, int i, int j){
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }
    public static void main(String[] args) {
        Permutation p = new Permutation();
        String str = "ABC";
        System.out.println("All permutations of " + str + " are:");
        p.permute(str);
    }

}
