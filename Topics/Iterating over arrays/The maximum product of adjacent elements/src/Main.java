import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int max = 0;
        int length = scanner.nextInt();
        int[] array = new int[length];

        for (int i = 0; i < length; i++) {
            array[i] = scanner.nextInt();
        }

        for (int i = 0; i < length - 1; i++) {
            if (array[i] * array[i + 1] > max) {
                max = array[i] * array[i + 1];
            }
        }
        System.out.println(max);
    }
}