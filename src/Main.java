public class Main {
    public static void main(String[] args) {

        System.out.println( new Solution().myPow(1.0000000000001,-2147483648));

    }
}
// leetcode binary exponentiation. eye roll....
class Solution {
    private double binaryExp(double x, long n) {
        // Base case, to stop recursive calls.
        if (n == 0) {
            return 1;
        }

        // Handle case where, n < 0.
        if (n < 0) {
            return 1.0 / binaryExp(x, -1 * n);
        }

        // Perform Binary Exponentiation.
        // If 'n' is odd we perform Binary Exponentiation on 'n - 1' and multiply result with 'x'.
        if (n % 2 == 1) {
            return x * binaryExp(x * x, (n - 1) / 2);
        }
        // Otherwise we calculate result by performing Binary Exponentiation on 'n'.
        else {
            return binaryExp(x * x, n / 2);
        }
    }

    public double myPow(double x, int n) {
        return binaryExp(x, (long) n);
    }
}

// passes 304/306. just chasing dumb edge cases.
class Solution {
    public double myPow(double x, int n) {
        if(n == 0){
            return 1;
        }
        if(x == 1 || x == -1){
            return x;
        }

        if(n < 0){
            x = 1/x;
        }
        double stored = x;
        if(n > 0){
            n *= -1;
        }

        while(n != -1){
            n++;
            x *=stored;
        }

        return (double) x;
    }
}