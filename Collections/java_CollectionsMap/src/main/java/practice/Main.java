package practice;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        Scanner scanner = new Scanner(System.in);
        String phone = "";
        String name = "";
        while (true) {
            System.out.println("Введите номер, имя или команду:");
            String input = scanner.nextLine();
            if (input.equals("0")) {
                scanner.close();
                break;
            }
            if (input.equals("LIST")) {
                System.out.println(phoneBook.getAllContacts());
                /*ArrayList<String> phoneList = new ArrayList<>();
                phoneList.addAll(phoneBook.getAllContacts());
                for (String text:phoneList) {
                    System.out.println(text);
                }*/

            } else {
                String testPhone = phoneBook.phoneTest(input);
                String testName = phoneBook.nameTest(input);
                if (!testPhone.equals("")) {
                    if (phoneBook.getContactByPhone(testPhone).equals("")) {
                        System.out.println("Такого номера нет в телефонной книге.");
                        System.out.println("Введите имя абонента для номера “" + testPhone + "”:");
                        input = scanner.nextLine();
                        testName = phoneBook.nameTest(input);
                        phoneBook.addContact(testPhone, testName);
                        System.out.println("Контакт сохранен!");
                        continue;
                    } else {
                        System.out.println(phoneBook.getContactByPhone(testPhone));
                    }
                }
                if (!testName.equals("")) {
                    if (phoneBook.getContactByName(testName).equals("")) {
                        System.out.println("Такого имени в телефонной книге нет.");
                        System.out.println("Введите номер телефона для абонента “" + testName + "”:");
                        input = scanner.nextLine();
                        testPhone = phoneBook.phoneTest(input);
                        phoneBook.addContact(testPhone, testName);
                        System.out.println("Контакт сохранен!");
                        continue;
                    }
                } else {
                    System.out.println(phoneBook.getContactByName(testName));
                }
                if (testPhone.equals("") & testName.equals("")){
                    System.out.println("Неверный формат ввода");
                };
            }


        }
    }

}
