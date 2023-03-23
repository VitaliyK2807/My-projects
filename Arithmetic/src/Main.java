import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Введите два числа:");

        int variableOne = new Scanner(System.in).nextInt();
        int variableTwo = new Scanner(System.in).nextInt();

        Arithmetic twoOne = new Arithmetic (variableOne, variableTwo);

        twoOne.print();


    }

}
