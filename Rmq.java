import java.util.*;
import java.lang.Math;

/**
 * Range Maximum Query zzz
 * 
 * The problem description is: Given an array with n integers and m range
 * queries, each query need to return the maximum element between array[i...j].
 * 
 * time complexity for pre-preocess: O(NlogN) time complexity for each query:
 * O(logN) space comlexity: O(NlogN)
 * 
 * @author Dejian Tu
 */
public class Rmq {
    private int[][] d;
    private int[] intLog;

    /**
     * Constructor and pre-process the data. The pre-process takes O(NlogN)
     * time to finish.
     * 
     * @param data  integer data
     */
    public Rmq(int[] data) {
        int n = data.length;
        intLog = new int[n + 1];
        for (int i = 1, k = 0; i <= n; intLog[i++] = k - 1) {
            while ((1 << k) <= i)
                ++k;
        }
        d = new int[intLog[n] + 1][n];
        for (int i = 0; i < n; ++i) {
            d[0][i] = data[i];
        }
        for (int j = 1; (1 << j) <= n; ++j) {
            for (int i = 0; i + (1 << j) <= n; ++i) {
                d[j][i] = Math.max(d[j - 1][i], d[j - 1][i + (1 << (j - 1))]);
            }
        }
    }

    /**
     * Returns the maximum element (not index) in the range data[i...j].
     * Time complexity is O(logN)
     * 
     * @param i left index of the range
     * @param j right index of the range, inclusive
     * @return  the maximum element of range data[i...j]
     */
    public int query(int i, int j) {
        int k = intLog[j - i + 1];
        return Math.max(d[k][i], d[k][j - (1 << k) + 1]);
    }

    /**
     * Main function to test the class
     */
    public static void main(String[] args) {
        int n = 1000000;
        int[] data = new int[n];
        Random random = new Random();

        for (int i = 0; i < n; ++i) {
            data[i] = random.nextInt();
        }
        Rmq rmq = new Rmq(data);
        for (int i = 0; i < n; ++i) {
            int x = random.nextInt(n);
            int y = random.nextInt(n);
            if (x > y) {
                int t = x;
                x = y;
                y = t;
            }
            rmq.query(x, y);
        }
        System.out.println("Done");
    }
}
