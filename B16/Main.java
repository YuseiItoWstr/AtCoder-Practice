import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[] h = new int[N];
        for (int i = 0; i < N; i++) {
            h[i] = scanner.nextInt();
        }

        int[] dp = new int[N];
        dp[0] = 0;

        for (int i = 1; i < N; i++) {
            // 一つ前の足場からジャンプする場合のコスト
            int cost1 = dp[i - 1] + Math.abs(h[i] - h[i - 1]);

            if (i > 1) {
                // 二つ前の足場からジャンプする場合のコスト
                int cost2 = dp[i - 2] + Math.abs(h[i] - h[i - 2]);
                dp[i] = Math.min(cost1, cost2);
            } else {
                dp[i] = cost1;
            }
        }

        System.out.println(dp[N - 1]);

        scanner.close();
    }
}
