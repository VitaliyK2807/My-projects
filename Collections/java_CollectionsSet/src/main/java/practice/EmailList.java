package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class EmailList {
public TreeSet<String> eMailSet = new TreeSet<>();
    public void add(String email) {
        // TODO: валидный формат email добавляется, email это строка, она быть может любой
        // принять решение добавлять аргумент email или нет должен этот метод
        String regex = "^[A-Za-z0-9_.-]+[@][a-z-]+[.][a-z]{2,3}";
        if (email.matches(regex)) {
            eMailSet.add(email.toLowerCase());
        }

    }

    public List<String> getSortedEmails() {
        // TODO: возвращается сортированный список электронных адресов в алфавитном порядке
        ArrayList <String> eMailList = new ArrayList<>();
        eMailList.addAll(eMailSet);
        return eMailList;
    }

}
