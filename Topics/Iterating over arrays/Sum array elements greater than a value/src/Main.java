import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int[] array = new int[length];
        int sum = 0;

        for (int i = 0; i < length; i++) {
            array[i] = scanner.nextInt();
        }

        int n = scanner.nextInt();

        for (int i = 0; i < length; i++) {
            if (array[i] > n) {
                sum += array[i];
            }
        }

        System.out.println(sum);
    }
}