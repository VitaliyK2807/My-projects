package practice;

import java.util.*;

public class PhoneBook {
    int i = 0;
    Map<String, String> phoneBook = new HashMap<>();
    public void addContact(String phone, String name) {
        // проверьте корректность формата имени и телефона
        // (рекомедуется написать отдельные методы для проверки является строка именем/телефоном)
        // если такой номер уже есть в списке, то перезаписать имя абонента
        if ((!phone.equals("") && !name.equals("")) &
        !phone.equals(name)) {
            String key = "";
            String value = "";
             phoneBook.put(phone, name);


        }

    }


    public String getContactByPhone(String phone) {
        // формат одного контакта "Имя - Телефон"
        // если контакт не найдены - вернуть пустую строку
        String key = "";
        String value = "";
        for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
            key = entry.getKey(); // получения ключа
            value = entry.getValue(); // получения ключа
            if (phone.equals(key)) {
                return value + " - " + key;
            }
        }
        return "";
    }



    public Set<String> getContactByName(String name) {
        // формат одного контакта "Имя - Телефон"
        // если контакт не найден - вернуть пустой TreeSet
        String key = "";
        String value = "";
        TreeSet<String> listName = new TreeSet<>();
        for (Map.Entry<String, String> entry : phoneBook.entrySet()){
            key = entry.getKey(); // получения ключа
            value = entry.getValue(); // получения ключа
            if (value.equals(name)) {
                listName.add(value + " - " + key);
            }
        }

        return listName;
    }

    public Set<String> getAllContacts() {
        // формат одного контакта "Имя - Телефон"
        // если контактов нет в телефонной книге - вернуть пустой TreeSet
        String key = "";
        String value = "";
        String phones = "";
        String [] list = new String[phoneBook.size()];
        int i = 0;
        String name;
        TreeSet<String> listPhoneBook = new TreeSet<>();
        for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
            key = entry.getKey();
            value = entry.getValue();
            if (phoneBook.containsValue(value)) {
                list[i] = key;
                i++;
            }
        }
        for (int j = 0; j < phoneBook.size(); j++) {
            String namesfinal = phoneBook.get(list[j]);
            name = phoneBook.get(list[j]);
            int k = 0;
            int ii = j;
            phones = "";
            while (phoneBook.get(list[j]).equals(name)) {
                if (phoneBook.containsKey(list[ii])) {
                    ii++;
                    if (ii == phoneBook.size()) {
                        k++;
                        name = "";
                        if (ii - 1 > j) {
                            phones += ", ";
                        }
                        phones += list[ii - 1];
                        j = ii - 1;
                    } else {
                        phones += list[ii - 1];
                        name = phoneBook.get(list[ii]);
                    }
                }
            }
            listPhoneBook.add(namesfinal + " - " + phones);
        }
        return listPhoneBook;
    }


    // для обхода Map используйте получение пары ключ->значение Map.Entry<String,String>
    // это поможет вам найти все ключи (key) по значению (value)
    /*
        for (Map.Entry<String, String> entry : map.entrySet()){
            String key = entry.getKey(); // получения ключа
            String value = entry.getValue(); // получения ключа
        }
    */
    public String phoneTest(String phoneText) {
        String result = "";
        String regexPhone = "[^0-9]";
        String string = phoneText.replaceAll(regexPhone, "");
        if (string.length() == 11) {
            result = "";
            String[] words = string.split("", 11);
            if (words[0].equals("8")) {
                words[0] = words[0].replace("8", "7");
            }
            if (words[0].matches("[0-6?]") ||
                    words[0].matches("[9?]")) {
            } else {
                for (int i = 0; i < words.length; i++) {
                    result = result + words[i];
                }
            }
        } else if (string.length() == 10) {
            result = "7";
            String[] words = string.split("", 10);
            for (int i = 0; i < words.length; i++) {
                result = result + words[i];
            }
        } else {
            result = "";
        }

        return result;
    }
    public String nameTest(String nameText) {
        String result = "";
        String regexName = "[a-zA-Zа-яА-я]+";
        Boolean name = nameText.matches(regexName);
            if (name == true) {
                result = nameText;
            }


        return result;
    }

}