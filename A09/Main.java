import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 入力の読み取り
        int H = sc.nextInt();
        int W = sc.nextInt();
        int N = sc.nextInt();
        
        int[][] snow = new int[H + 1][W + 1];

        // 雪が降る情報の処理
        for (int i = 0; i < N; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            int C = sc.nextInt();
            int D = sc.nextInt();

            // 左上 (A, B) から右下 (C, D) までの領域の積雪を増やす
            snow[A][B]++;
            snow[C + 1][B]--;
            snow[A][D + 1]--;
            snow[C + 1][D + 1]++;
        }

        // 2次元累積和を計算する
        int[][] result = new int[H + 1][W + 1];

        for (int i = 1; i <= H; i++) {
            for (int j = 1; j <= W; j++) {
                result[i][j] = snow[i][j] + result[i - 1][j] + result[i][j - 1] - result[i - 1][j - 1];
            }
        }

        // 結果の出力
        for (int i = 1; i <= H; i++) {
            for (int j = 1; j <= W; j++) {
                System.out.print(result[i][j] + " ");
            }
        }

        sc.close();
    }
}
