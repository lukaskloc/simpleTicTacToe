import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int[][] array = new int[length][length];

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                array[i][j] = Math.abs(-j + i);
            }
        }

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - 1; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println(array[i][length - 1]);
        }
    }
}