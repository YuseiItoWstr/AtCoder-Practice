import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 入力の読み取り
        int N = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        int D = sc.nextInt();
        int[][] LR = new int[D][2];
        for(int i = 0; i < D; i++) {
            for(int j = 0; j < 2; j++) {
                LR[i][j] = sc.nextInt();
            }
        }

        // System.out.println("----------------------------------------------");
        // System.out.println("N: " + N);
        // System.out.println("A: " + Arrays.toString(A));
        // System.out.println("D: " + D);
        // System.out.println("LR: " + Arrays.deepToString(LR));
        // System.out.println("----------------------------------------------");
        // System.out.println("Answer: ");

        int[] lFrom = new int[N];
        int[] rFrom = new int[N];
        lFrom[0] = A[0];
        rFrom[N - 1] = A[N - 1];

        for (int i = 1; i < N; i++) {
            lFrom[i] = Math.max(lFrom[i - 1], A[i]);
        }

        for (int i = N - 2; i >= 0; i--) {
            rFrom[i] = Math.max(rFrom[i + 1], A[i]);
        }

        // System.out.println("lFrom: " + Arrays.toString(lFrom));
        // System.out.println("rFrom: " + Arrays.toString(rFrom));

        int[] maxRoom = new int[D];

        // 各クエリに対する処理
        for (int i = 0; i < D; i++) {
            int l = LR[i][0] - 1;
            int r = LR[i][1] - 1;
            int lMax = lFrom[l - 1];
            int rMax = rFrom[r + 1];
            maxRoom[i] = Math.max(lMax, rMax);
        }

        for (int room : maxRoom) {
            System.out.println(room);
        }
    }
}
