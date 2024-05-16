import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[] digitList = toArray(N);
        int anwser = toDecimal(digitList);
        System.out.println(anwser);
    }

    public static int[] toArray(int i) {
        return String.valueOf(i).chars().map(e -> e - 48).toArray();
    }

    public static int toDecimal(int[] array) {
        int decimal = 0;
        for (int i = 0; i < array.length; i++) {
            decimal += array[i] * Math.pow(2, array.length - i - 1);
        }
        return decimal;
    }
}
