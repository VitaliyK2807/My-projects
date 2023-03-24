package practice;

import net.sf.saxon.type.StringConverter;

import java.security.PublicKey;
import java.util.*;

public class Main {
    /*
    TODO:
     - реализовать методы класса CoolNumbers
     - посчитать время поиска введимого номера в консоль в каждой из структуры данных
     - проанализоровать полученные данные
     */



    public static void main(String[] args) {
        List<String> numbersList = CoolNumbers.generateCoolNumbers();
        HashSet<String> numbersSet = CoolNumbers.beautifulNumbersSet();
        TreeSet<String> numbersTreeSet = CoolNumbers.beautifulNumbersTreeSet();
        boolean search;
        long time = System.nanoTime();

        search = CoolNumbers.bruteForceSearchInList(numbersList, "Н636СВ03");
        time = System.nanoTime() - time;
        System.out.println(search ? "Поиск перебором: номер найден" + ", поиск занял  : " + time + " нс" :
                "Поиск перебором: не найден" + ", поиск занял  : " + time + " нс");

        Collections.sort(numbersList);
        time = System.nanoTime();
        search = CoolNumbers.bruteForceSearchInList(numbersList, "Н636СВ03");
        time = System.nanoTime() - time;
        System.out.println(search ? "Бинарный поиск: номер найден" + ", поиск занял  : " + time + " нс" :
                "Бинарный поиск: не найден" + ", поиск занял  : " + time + " нс");

        time = System.nanoTime();
        search = CoolNumbers.searchInHashSet(numbersSet, "Н636СВ13");
        time = System.nanoTime() - time;
        System.out.println(search ? "Поиск в HashSet: номер найден" + ", поиск занял  : " + time + " нс" :
                "Поиск в HashSet: не найден" + ", поиск занял  : " + time + " нс");

        time = System.nanoTime();
        search = CoolNumbers.searchInTreeSet(numbersTreeSet, "Н636СВ23");
        time = System.nanoTime() - time;
        System.out.println(search ? "Поиск в TreeSet: номер найден" + ", поиск занял  : " + time + " нс" :
                "Поиск в TreeSet: не найден" + ", поиск занял  : " + time + " нс");

    }

}
