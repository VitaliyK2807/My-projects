package practice.reverseArray;

public class Main {

    // используя данный метод, вы можете использовать ваши методы, и проверить их работу на разных
    // значений для проверки и отладки
    public static void main(String[] args) {
        String line = "Каждый охотник желает знать, где сидит фазан";
        String [] testText = {"1", "2", "3", "4", "5", "6", "7", "aa", "bb", "ccc", "ddd", "eee", "fff", "ggg", "hhh"};
        String [] reverseText = ReverseArray.reverse(line.split("\\s"));
        for (int i = 0; i < reverseText.length; i++) {
            System.out.print(reverseText[i] + " ");
         }
        System.out.println();
        reverseText = ReverseArray.reverse(testText);
        for (int i = 0; i < reverseText.length; i++) {
            System.out.print(reverseText[i]);
        }
    }
}
