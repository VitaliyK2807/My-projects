package practice;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static final String WRONG_EMAIL_ANSWER = "Неверный формат email";

    /* TODO:
        Пример вывода списка Email, после ввода команды LIST в консоль:
        test@test.com
        hello@mail.ru
        - каждый адрес с новой строки
        - список должен быть отсортирован по алфавиту
        - email в разных регистрах считается одинаковыми
           hello@skillbox.ru == HeLLO@SKILLbox.RU
        - вывод на печать должен быть в нижнем регистре
           hello@skillbox.ru
        Пример вывода сообщения об ошибке при неверном формате Email:
        "Неверный формат email"
    */


    public static void main(String[] args) {

         EmailList emailList = new EmailList();
        Scanner scanner = new Scanner(System.in);
        String eMailCommand = "";
        String eMailText = "";
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("0")) {
                break;
            }
           eMailCommand = commandWord(input);
           eMailText = finishedText(input);
            //TODO: write code here
            switch (eMailCommand) {
                case "ADD" -> {
                    emailList.add(eMailText);
                }
                case "LIST" -> {

                    ArrayList<String> newList = new ArrayList<>();
                    newList.addAll(emailList.getSortedEmails());
                    for (String list: newList) {
                        System.out.println(list);
                    }
                }
                default -> System.out.println("Не корректный ввод команды");
            }
        }
    }
    public static String commandWord (String text) {
        int commandSpace = text.indexOf(" ");
        if (commandSpace == -1) {
            return text;
        }
        String commandWord = text.substring(0, commandSpace);
        return commandWord;
    }
    public static String finishedText (String text) {
        int commandSpace = text.indexOf(" ");
        if (commandSpace == -1) {
            return "";
        }
        int numberStart = -1;
        int index = 0;
        if (commandSpace+1 >= text.length()) {
            return "";
        }
        String resultText = text.substring(commandSpace+1, text.length());

        return resultText;
    }

}
