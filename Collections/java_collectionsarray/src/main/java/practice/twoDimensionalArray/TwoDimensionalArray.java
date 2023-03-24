package practice.twoDimensionalArray;

public class TwoDimensionalArray {

    public static final char SYMBOL = 'X';

    public static char[][] getTwoDimensionalArray(int size) {
        char [][] dimensionalArray = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == j) {
                   dimensionalArray[i][j] = 'X';
                } else {
                   dimensionalArray[i][j] = ' ';
                }
            }
        }
        int j = size-1;
        for (int i = 0; i < size; i++) {
            dimensionalArray[i][j-i] = 'X';
        }
        //TODO: Написать метод, который создаст двумерный массив char заданного размера.
        // массив должен содержать символ SYMBOL по диагоналям, пример для size = 3
        // [X,  , X]
        // [ , X,  ]
        // [X,  , X]

        return dimensionalArray;
    }
    public static String arrayToString (char [][] array) {
        String arrayReport = "";
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                arrayReport += String.valueOf(array [i][j]) + ",";
                if (j == array.length-1) {
                    arrayReport += "\n";
                }
            }
        }
        return arrayReport;
    }


    public static void main(String[] args) {
        char [][] newArray = getTwoDimensionalArray(7);
        System.out.println(arrayToString(newArray));

    }
}
