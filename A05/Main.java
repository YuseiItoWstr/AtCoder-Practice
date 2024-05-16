import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        
        System.out.println(countWays(N, K));
    }

    public static int countWays(int N, int K) {
        int count = 0;
        // 3重ループで全ての組み合わせをチェック
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                int remaining = K - i - j;
                // remainingが1以上N以下の範囲内かを確認
                if (remaining >= 1 && remaining <= N) {
                    count++;
                }
            }
        }        
        return count;
    }
}