import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        // 入力(N, X, A[])
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int X = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        // System.out.println(N + ", " + X);
        // System.out.println(Arrays.toString(A));

        // ロジック
        int count = 0;
        for (int i = 0; i < N; i++) {
            if (X == A[i]) {
                count ++;
            }
        }

        if (count > 0) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}