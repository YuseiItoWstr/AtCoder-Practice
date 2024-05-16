import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Object[] input = input();
        int[] sumArray = getSumArray((int[])input[0], (int[][])input[1], (int)input[2]);
        for (int i = 0; i < sumArray.length; i++) {
            System.out.println(sumArray[i]);
        }
    }

    public static Object[] input() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int Q = sc.nextInt();
        int[] A = new int[N];
        int[][] lr = new int[Q][2];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        for(int i = 0; i < Q; i++) {
            for(int j = 0; j < 2; j++) {
                lr[i][j] = sc.nextInt();
            }
        }
        Object[] result = {A, lr, Q};
        System.out.println("N: " + N + ", " + "Q: " + Q);
        System.out.println("A: " + Arrays.toString(A));
        System.out.println("lr: " + Arrays.deepToString(lr));
        System.out.println(Arrays.deepToString(result));
        return result;
    }

    public static int[] getSumArray(int[] A, int[][] lr, int Q) {
        int N = A.length;
        int[] prefixSum = new int[N + 1];

        // 累積和の計算
        for (int i = 1; i <= N; i++) {
            prefixSum[i] = prefixSum[i - 1] + A[i - 1];
        }

        int[] sumArray = new int[Q];
        for (int i = 0; i < Q; i++) {
            int l = lr[i][0];
            int r = lr[i][1];
            sumArray[i] = prefixSum[r] - prefixSum[l - 1];
        }

        return sumArray;
    }
}
