import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int D = sc.nextInt();
        int N = sc.nextInt();
        int[][] LR = new int[N][2];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < 2; j++) {
                LR[i][j] = sc.nextInt();
            }
        }
        // System.out.println("----------------------------------------------");
        // System.out.println("D: " + D + ", " + "N: " + N);
        // System.out.println("LR: " + Arrays.deepToString(LR));
        // System.out.println("----------------------------------------------");
        // List<Integer> allDay = convertAllDay(D, LR);
        // System.out.println("allDay: " + allDay);
        // System.out.println("----------------------------------------------");
        // System.out.println("Answer: ");
        int[] uqCnt = uqCnt(D, LR);
        for (int i = 0; i < uqCnt.length; i++) {
            System.out.println(uqCnt[i]);
        }
    }

    public static List<Integer> convertAllDay(int D, int[][] LR) {
        List<Integer> allDay = new ArrayList<>();
        for (int[] pair : LR) {
            for (int num = pair[0]; num <= pair[1]; num++) {
                allDay.add(num);
            }
        }
        return allDay;
    }

    public static int[] uqCnt(int D, int[][] LR) {
        int[] counts = new int[D];
        for (int[] range : LR) {
            int start = range[0];
            int end = range[1];
            for (int i = start - 1; i < end; i++) {
                counts[i]++;
            }
        }
        return counts;
    }
}
