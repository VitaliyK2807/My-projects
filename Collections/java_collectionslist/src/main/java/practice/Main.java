package practice;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

import static java.lang.String.*;

public class Main {
    private static TodoList todoList = new TodoList();

    public static void main(String[] args) {
        // TODO: написать консольное приложение для работы со списком дел todoList

        while (true) {
            System.out.print("Ввод команды: ");
            String scanner = new Scanner(System.in).nextLine();
            String command = commandWord(valueOf(scanner));
            String text = finishedText(valueOf(scanner));
            int numberLine = lineNumber(valueOf(scanner));
            switch (command) {
                case "ADD" -> {
                    if (numberLine == -1) {
                        todoList.add(text);
                        System.out.println("Добавлено дело " + "\"" + text + "\"");
                    } else {
                        todoList.add(numberLine, text);
                        System.out.println("Добавлено дело " + "\"" + text + "\"");
                    }
                }
                case "EDIT" -> {
                    todoList.edit(numberLine, text);
                }
                case "LIST" -> {
                    String todoListText = "";
                    ArrayList<String> list = todoList.getTodos();
                    for (int i = 0; i < list.size(); i++)
                        if (i == list.size()-1) {
                            todoListText +=  i + " - " + list.get(i);
                        } else {
                            todoListText += i + " - " + list.get(i) + "\n";
                        }
                    System.out.println(todoListText);
                }
                case "DELETE" -> {
                    todoList.delete(numberLine);
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
        index = text.indexOf(' ',  commandSpace+ 1);
        if (index != -1) {
            if (Character.isDigit(text.charAt(commandSpace + 1))) {
                numberStart = commandSpace + 1;
            }
            if (numberStart > 0 &&
                    Character.isDigit(text.charAt(index - 1))) {
                resultText = text.substring(index + 1, text.length());
            }
        }
        return resultText;
    }
    public static int lineNumber (String text) {
        int commandSpace = text.indexOf(" ");
        int number = -1;
        int numberStart = -1;
        int index = 0;
        if (commandSpace == -1) {
            return number;
        }
        index = text.indexOf(' ',  commandSpace + 1);
        if (index != -1) {
            if (Character.isDigit(text.charAt(commandSpace+1))) {
                numberStart = commandSpace + 1;
            }
            if (numberStart > 0 &&
                    Character.isDigit(text.charAt(index - 1))) {
                number = Integer.parseInt(text.substring(numberStart, index));

            }
        } else if (Character.isDigit(text.charAt(commandSpace+1))) {
            number = Integer.parseInt(text.substring(commandSpace+1, text.length()));
        } else {
            number = -1;
        }

        return number;
    }

}
