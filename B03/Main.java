import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }

        List<int[]> combinations = getCombinations(A, 3);
        
        int[] sumArray = getSum(combinations);
        int count = countSame(sumArray);
        if (count > 0) {
            System.out.println("Yes");    
        }
        else {
            System.out.println("No");
        }
    }

    public static List<int[]> getCombinations(int[] array, int r) {
        List<int[]> combinations = new ArrayList<>();
        int[] combination = new int[r];
        combine(array, combinations, combination, 0, 0, r);
        return combinations;
    }

    public static void combine(int[] array, List<int[]> combinations, int[] combination, int start, int index, int r) {
        if (index == r) {
            combinations.add(combination.clone());
            return;
        }

        for (int i = start; i <= array.length - r + index; i++) {
            combination[index] = array[i];
            combine(array, combinations, combination, i + 1, index + 1, r);
        }
    }

    public static int[] getSum(List<int[]> array) {
        int[] sumArray = new int[array.size()];
        for (int i = 0; i < array.size(); i++) {
            int sum = 0;
            sum += array.get(i)[0] + array.get(i)[1] + array.get(i)[2];
            sumArray[i] = sum;
        }
        return sumArray;
    }

    public static int countSame(int[] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1000) {
                count++;
            }
        }
        return count;
    }

}
