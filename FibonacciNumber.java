
/**
 *  @author Monish Kumar Muthuvijayan, Keerthi Bala Sundram
 *  @date 02/19/2016
 *
 *  @FibonacciNumber.java The Fibonacci Class contains two implementations of Fibonacci Number
 *
 *  @Description
 *      Contains FibonacciOn and FibonacciOLogN that are used to find the n'th Fibonacci Number
 */


public class FibonacciNumber {

    static long p = 999953;

    /**
     * A method that uses simple iterative addition to find the nth Fibonacci Number.
     * Running Time - O(n)
     *
     * @param number
     * @return FibonacciNumber
     */
    public static long FibonacciOn(long number) {
        long a = 0, b = 1, temp;
        if(number == 0)
            return 0;
        for(long i=2; i<=number; i++) {
            temp = (a + b) % p;
            a = b % p;
            b = temp % p;
        }
        long fibonacciNumber = b;
        return fibonacciNumber;
    }

    /**
     * A method that uses identity matrix multiplication to find the nth Fibonacci Number.
     * Running Time - O(log n)
     *
     * @param number
     * @return FibonacciNumber
     */
    public static long FibonacciOLogN(long number) {
        long matrix[][] = {{1,1},{1,0}};
        if( number==0 )
            return 0;
        powerOf(matrix, number-1);
        return matrix[0][0];
    }

    /**
     * A method that is used to multiply the number with a identity matrix and calls it iteratively.
     *
     * @param number
     * @param matrix
     */
    public static void powerOf(long matrix[][], long number) {
        if( number == 0 | number == 1 )
            return;
        long identityMatrix[][] = {{1,1},{1,0}};

        powerOf(matrix, number/2);
        MatrixMultiplication(matrix, matrix);

        if(number%2 != 0)
            MatrixMultiplication(matrix, identityMatrix);
    }

    /**
     * A method that is used to multiply two matrices.
     *
     * @param matrix
     * @param identityMatrix
     */
    public static void MatrixMultiplication(long matrix[][], long identityMatrix[][]) {
        long a = matrix[0][0]*identityMatrix[0][0] + matrix[0][1]*identityMatrix[1][0];
        long b = matrix[0][0]*identityMatrix[0][1] + matrix[0][1]*identityMatrix[1][1];
        long c = matrix[1][0]*identityMatrix[0][0] + matrix[1][1]*identityMatrix[1][0];
        long d = matrix[1][0]*identityMatrix[0][1] + matrix[1][1]*identityMatrix[1][1];

        matrix[0][0] = a % p;
        matrix[0][1] = b % p;
        matrix[1][0] = c % p;
        matrix[1][1] = d % p;
    }
}