import java.util.HashMap;
import java.util.Map;

public class CustomerStorage {
    private final Map<String, Customer> storage;

    public CustomerStorage() {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) {
        final int INDEX_NAME = 0;
        final int INDEX_SURNAME = 1;
        final int INDEX_EMAIL = 2;
        final int INDEX_PHONE = 3;

        inputValidation(data);
        String[] components = data.split("\\s+");
        String name = components[INDEX_NAME] + " " + components[INDEX_SURNAME];
        storage.put(name, new Customer(name, components[INDEX_PHONE], components[INDEX_EMAIL]));
    }

    public void listCustomers() {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name) throws ArrayIndexOutOfBoundsException {
        String[] components = name.split("\\s+", 2);
        if (nameTest(components[0], components[1])) {
            storage.remove(name);
        }

    }

    public Customer getCustomer(String name) {
        return storage.get(name);
    }

    public int getCount() {
        return storage.size();
    }

    public void inputValidation (String data) {
        final int INDEX_NAME = 0;
        final int INDEX_SURNAME = 1;
        final int INDEX_EMAIL = 2;
        final int INDEX_PHONE = 3;

        String regex = "^[A-Za-z0-9_.-]+[@][a-z-]+[.][a-z]{2,3}";

        String[] components = data.split("\\s+");

        if (components.length != 4){
            throw new IllegalArgumentException("Не верный формат! Требуемый формат: \n" +
                    "add Василий Петров vasily.petrov@gmail.com +79215637722");
        }
        if (!nameTest(components[INDEX_NAME], components[INDEX_SURNAME])) {
            throw new IllegalArgumentException("Не корректный ввод Имени Фамилии! Пример формата: \n" +
                    "Василий Петров");
        }
        if (!components[INDEX_EMAIL].matches(regex)) {
            throw new IllegalArgumentException("Не верный формат Email! Пример формата: \n" +
                    "vasily.petrov@gmail.com");
        }
        if (!phoneTest(components[INDEX_PHONE])) {
            throw new IllegalArgumentException("Не верный формат номера телефона! Пример формата: \n" +
                    "+79215637722");
        }
    }

    public Boolean nameTest(String name, String surname) {
        String regex = "[а-яА-я]+";
        if (name.matches(regex) && surname.matches(regex)) {
            return true;
        }
        return false;
    }
    public Boolean phoneTest(String phoneText) {
        String regex = "\\+[7][0-9]{10}";
        if (phoneText.matches(regex)) {
            return true;
        }
        return false;
    }
}