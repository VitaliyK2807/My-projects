public class Main {
    public static void main(String[] args) {
        Container container = new Container();
        container.addCount(5672);
        System.out.println(container.getCount());

        String letter1 = "";
        String letter2 = "";
        int number1 = 0;
        int number2 = 0;

        for (int i = 0; i <= 65536; i++) {
            char c = (char) i;
            if (c == 'ё') {
                letter1 = String.valueOf(c);
                number1 = i;
            }
            if (c == 'Ё') {
                letter2 = String.valueOf(c);
                number2 = i;
            }
        }
        System.out.println("Строчные буквы");
        for (char letter = 'а'; letter <= 'я'; letter++) {
            int number = letter;
            System.out.println(letter + " - " + number);
            if (letter == 'е') {
                System.out.println(letter1 + " - " + number1);
            }
        }
        System.out.println("Заглавные буквы");
        for (char letter = 'А'; letter <= 'Я'; letter++) {
            int number = letter;
            System.out.println(letter + " - " + number);
            if (letter == 'Е') {
                System.out.println(letter2 + " - " + number2);
            }
        }
        // TODO: ниже напишите код для выполнения задания:
        //  С помощью цикла и преобразования чисел в символы найдите все коды
        //  букв русского алфавита — заглавных и строчных, в том числе буквы Ё.

    }
}
