import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 入力例の読み取り
        int N = scanner.nextInt();
        int X = scanner.nextInt();
        
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }
        
        int position = binarySearch(A, X);
        
        System.out.println(position);
    }
    
    // 二分探索法を実装
    public static int binarySearch(int[] A, int X) {
        int left = 0;
        int right = A.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            // X が見つかった場合
            if (A[mid] == X) {
                return mid + 1; // インデックスは0から始まるので、1を足して1始まりの位置に変換
            }
            
            // X が中央の値よりも小さい場合
            if (A[mid] > X) {
                right = mid - 1;
            }
            // X が中央の値よりも大きい場合
            else {
                left = mid + 1;
            }
        }
        
        // X が配列内に存在しない場合
        return -1;
    }
}