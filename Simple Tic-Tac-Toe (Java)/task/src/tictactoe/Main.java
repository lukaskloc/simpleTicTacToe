package tictactoe;

import java.util.Scanner;

public class Main {

    public static boolean isNumeric(String number) {
        boolean isANumber = true;

        if (number == null) { isANumber = false; }

        try {
            int n = Integer.parseInt(number);
        } catch (NumberFormatException e) {
            isANumber = false;
        }
        return isANumber;
    }

    public static boolean isGameFinished(char[][] array) {
        boolean xWins = array[1][2] == 'X' && array[1][4] == 'X' && array[1][6] == 'X' ||
                array[2][2] == 'X' && array[2][4] == 'X' && array[2][6] == 'X' ||
                array[3][2] == 'X' && array[3][4] == 'X' && array[3][6] == 'X' ||
                array[1][2] == 'X' && array[2][4] == 'X' && array[3][6] == 'X' ||
                array[1][6] == 'X' && array[2][4] == 'X' && array[3][2] == 'X' ||
                array[1][2] == 'X' && array[2][2] == 'X' && array[3][2] == 'X' ||
                array[1][4] == 'X' && array[2][4] == 'X' && array[3][4] == 'X' ||
                array[1][6] == 'X' && array[2][6] == 'X' && array[3][6] == 'X';

        boolean oWins = array[1][2] == 'O' && array[1][4] == 'O' && array[1][6] == 'O' ||
                array[2][2] == 'O' && array[2][4] == 'O' && array[2][6] == 'O' ||
                array[3][2] == 'O' && array[3][4] == 'O' && array[3][6] == 'O' ||
                array[1][2] == 'O' && array[2][4] == 'O' && array[3][6] == 'O' ||
                array[1][6] == 'O' && array[2][4] == 'O' && array[3][2] == 'O' ||
                array[1][2] == 'O' && array[2][2] == 'O' && array[3][2] == 'O' ||
                array[1][4] == 'O' && array[2][4] == 'O' && array[3][4] == 'O' ||
                array[1][6] == 'O' && array[2][6] == 'O' && array[3][6] == 'O';

        boolean hasEmpty = false;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j] == '_') {
                    hasEmpty = true;
                }
            }
        }


        if (xWins) {
            System.out.println("X wins");
            return true;
        } else if (oWins) {
            System.out.println("O wins");
            return true;
        } else if (!hasEmpty) {
            System.out.println("Draw");
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        int xCounter = 0;
        int oCounter = 0;
        boolean hasEmpty = false;
        //int coordOne;
        //int coordTwo;
        int counter = 0;

        char[][] array = new char[5][9];



        //filling array
        for (int i = 0; i < 9; i++) {
            array[0][i] = '-';
            array[4][i] = '-';
        }
        for (int i = 1; i < 4; i++) {
            array[i][0] = '|';
            array[i][1] = ' ';
            array[i][3] = ' ';
            array[i][5] = ' ';
            array[i][7] = ' ';
            array[i][8] = '|';
        }
        for (int i = 1; i <= 3; i++) {
            for (int j = 2; j <= 6; j += 2) {
                array[i][j] = '_';
            }
        }
        //manually entering game state
        /*String input = scanner.nextLine();
        array[1][2] = input.charAt(0);  //1.1
        array[1][4] = input.charAt(1);  //1.2
        array[1][6] = input.charAt(2);  //1.3
        array[2][2] = input.charAt(3);  //2.1
        array[2][4] = input.charAt(4);  //2.2
        array[2][6] = input.charAt(5);  //2.3
        array[3][2] = input.charAt(6);  //3.1
        array[3][4] = input.charAt(7);  //3.2
        array[3][6] = input.charAt(8);  //3.3

        //counting Xs and Os
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'X') {
                xCounter++;
            }
            if (input.charAt(i) == 'O') {
                oCounter++;
            }
            if (input.charAt(i) == '_') {
                hasEmpty = true;
            }
        }*/

        //printing array
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(array[i][j]);
            }
            System.out.println();
        }

        //providing coordinates
        while (true) {
            Scanner scannerTwo = new Scanner(System.in);
            String coordOne = scannerTwo.next();
            if (isNumeric(coordOne)) {
                String coordTwo = scannerTwo.next();
                if (isNumeric(coordTwo) ) {
                    int coordOneInt = Integer.parseInt(coordOne);
                    int coordTwoInt = Integer.parseInt(coordTwo);
                    if (coordOneInt > 0 && coordOneInt < 4 && coordTwoInt > 0 && coordTwoInt < 4) {
                        if (!(array[coordOneInt][coordTwoInt * 2] == '_')) {
                            System.out.println("This cell is occupied! Choose another one!");
                        } else {
                            if (counter % 2 == 0) {
                                array[coordOneInt][coordTwoInt * 2] = 'X';
                            } else {
                                array[coordOneInt][coordTwoInt * 2] = 'O';
                            }
                            counter++;
                            //printing array
                            for (int i = 0; i < 5; i++) {
                                for (int j = 0; j < 9; j++) {
                                    System.out.print(array[i][j]);
                                }
                                System.out.println();
                            }
                            //checking ig game finished
                            if (isGameFinished(array)) {
                                break;
                            }
                        }
                    } else {
                        System.out.println("Coordinates should be from 1 to 3!");
                    }
                } else {
                    //scanner.next();
                    System.out.println("You should enter numbers!");
                    }
            } else {
                //scanner.next();
                System.out.println("You should enter numbers!");
            }
        }


        //boolean impossible = (Math.abs(xCounter - oCounter) > 1);

        /*if (xWins && !oWins && !impossible) {
            System.out.println("X wins");
        } else if (oWins && !xWins && !impossible) {
            System.out.println("O wins");
        } else if (!xWins && !oWins & !impossible && hasEmpty) {
            System.out.println("Game not finished");
        } else if (!xWins && !oWins && !impossible && !hasEmpty) {
            System.out.println("Draw");
        } else if (impossible || (xWins && oWins)) {
            System.out.println("Impossible");
        }*/
    }
}
