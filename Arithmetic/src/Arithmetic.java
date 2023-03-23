import java.security.PublicKey;

public class Arithmetic {

    private int variableOne;
    private int variableTwo;

    int maxNumbers;
    int minNumbers;

    boolean equalNumber = true;

    public Arithmetic (int variableOne, int variableTwo){
        this.variableOne = variableOne;
        this.variableTwo = variableTwo;
    }

    public int sum() {
        return variableOne + variableTwo;
    }

    public int product() {
        return variableOne * variableTwo;
    }

    public int maxNumber() {
        if (variableOne > variableTwo) {
            maxNumbers = variableOne;
        } else if (variableOne < variableTwo) {
            maxNumbers = variableTwo;
        }
        return maxNumbers;
    }

    public int minNumber() {
        if (variableOne > variableTwo) {
            minNumbers = variableTwo;
        } else if (variableOne < variableTwo) {
            minNumbers = variableOne;
        }
        return minNumbers;
    }

    public void print () {

        if (variableOne == variableTwo) {
            equalNumber = false;
        }
        System.out.println("Число 1 = " + variableOne + " ; " + "Число 2 = " + variableTwo);
        System.out.println("Сумма чисел: " + variableOne + " + " + variableTwo + " = " + sum());
        System.out.println("Произведение чисел: " + variableOne + " * " + variableTwo + " = " + product());
        if (equalNumber == true) {
            System.out.println("Максимальное число: " + maxNumber());
            System.out.println("Минимальное число: " + minNumber());
        } else  System.out.println("Числа равны!");


    }

}
