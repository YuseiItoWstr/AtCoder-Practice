import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // 入力(H, W, X[][], Q, ABCD[][])
        Scanner sc = new Scanner(System.in);
        int H = sc.nextInt();
        int W = sc.nextInt();
        int[][] X = new int[H][W];
        for(int i = 0; i < H; i++) {
            for(int j = 0; j < W; j++) {
                X[i][j] = sc.nextInt();
            }
        }

        int Q = sc.nextInt();
        int[][] ABCD = new int[Q][4];
        for(int i = 0; i < Q; i++) {
            for(int j = 0; j < 4; j++) {
                ABCD[i][j] = sc.nextInt();
            }
        }

        // System.out.println("----------------------------------------------");
        // System.out.println("H: " + H + ", " + "W: " + W);
        // System.out.println("X: " + Arrays.deepToString(X));
        // System.out.println("Q: " + Q);
        // System.out.println("ABCD: " + Arrays.deepToString(ABCD));
        // System.out.println("----------------------------------------------");
        // System.out.println("Answer: ");

        int[][] prefixSum = new int[H + 1][W + 1];
        for (int i = 1; i <= H; i++) {
            for (int j = 1; j <= W; j++) {
                prefixSum[i][j] = X[i - 1][j - 1] + prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1];
            }
        }

        int[] sumList = new int[Q];
        for (int i = 0; i < Q; i++) {
            int A = ABCD[i][0];
            int B = ABCD[i][1];
            int C = ABCD[i][2];
            int D = ABCD[i][3];

            sumList[i] = prefixSum[C][D] - prefixSum[A - 1][D] - prefixSum[C][B - 1] + prefixSum[A - 1][B - 1];
        }

        // 結果の出力
        for (int sum : sumList) {
            System.out.println(sum);
        }
    }
}
