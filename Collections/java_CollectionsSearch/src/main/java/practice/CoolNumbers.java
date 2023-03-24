package practice;

import java.util.*;

public class CoolNumbers {
    private static final String [] X = {"А", "В", "Е", "К", "М", "Н", "О", "Р", "С", "Т", "У", "Х"};
    private static final String [] Y = {"А", "В", "Е", "К", "М", "Н", "О", "Р", "С", "Т", "У", "Х"};
    private static final String [] Z = {"А", "В", "Е", "К", "М", "Н", "О", "Р", "С", "Т", "У", "Х"};
    public static List<String> generateCoolNumbers() {
        String [] numbers = numberGeneration();
        ArrayList<String> beautifulNumbers = new ArrayList<String>();
        for (int r = 1; r < 11; r++) {
            for (int x = 0; x < 12; x++) {
                for (int y = 0; y < 12; y++) {
                    for (int z = 0; z < 12; z++) {
                        for (int n = 0; n < 117; n++) {
                            if (r != 10) {
                                beautifulNumbers.add(X[x] + numbers[n] + Y[y] + Z[z] + "0" + r);
                            } else {
                                beautifulNumbers.add(X[x] + numbers[n] + Y[y] + Z[z] + r);
                            }
                        }
                    }
                }
            }
        }
        return beautifulNumbers;
    }

    public static boolean bruteForceSearchInList(List<String> list, String number) {
        Boolean search = list.contains(number);
        return search;
    }

    public static boolean binarySearchInList(List<String> sortedList, String number) {
        Boolean search;
        search = Collections.binarySearch(sortedList, number) >= 0 ? true : false;
        return search;
    }

    public static boolean searchInHashSet(HashSet<String> hashSet, String number) {
        Boolean search;
        for (String numberSearch:
             hashSet) {
            return search = numberSearch.contains(number);
        }
        return false;
    }

    public static boolean searchInTreeSet(TreeSet<String> treeSet, String number) {
        Boolean search;
        return search = treeSet.contains(number);


    }

    public static TreeSet<String> beautifulNumbersTreeSet () {
        String [] numbers = numberGeneration();
        TreeSet<String> beautifulNumbers = new TreeSet<String>();
        for (int r = 21; r < 31; r++) {
            for (int x = 0; x < 12; x++) {
                for (int y = 0; y < 12; y++) {
                    for (int z = 0; z < 12; z++) {
                        for (int n = 0; n < 117; n++) {
                            beautifulNumbers.add(X[x] + numbers[n] + Y[y] + Z[z] + r);
                        }
                    }
                }
            }
        }
        return beautifulNumbers;
    }
    public static HashSet<String> beautifulNumbersSet () {
        String [] numbers = numberGeneration();
        HashSet<String> beautifulNumbers = new HashSet<String>();
        for (int r = 11; r < 21; r++) {
            for (int x = 0; x < 12; x++) {
                for (int y = 0; y < 12; y++) {
                    for (int z = 0; z < 12; z++) {
                        for (int n = 0; n < 117; n++) {
                            beautifulNumbers.add(X[x] + numbers[n] + Y[y] + Z[z] + r);
                        }
                    }
                }
            }
        }
        return beautifulNumbers;
    }


    public static String [] numberGeneration() {
        String [] numbers = new String[117];
        int j;
        for (int i = 0; i < 9; i++) {
            numbers [i] = String.valueOf((i + 1) * 100);
        }
        j = 1;
        for (int i = 9; i < 18; i++) {
            numbers [i] = "0" + j++ + "0";
        }
        j = 1;
        for (int i = 18; i < 27; i++) {
            numbers [i] = "00" + j++;
        }
        j = 1;
        for (int i = 27; i < 117; i++) {
            if (i >= 27 & i < 36) {
                numbers [i] = j + "0" + j;
                j = (j == 9 ? 1 : j+1);
            }
            if (i >= 36 & i < 45) {
                numbers [i] = j + "1" + j;
                j = (j == 9 ? 1 : j+1);
            }
            if (i >= 45 & i < 54) {
                numbers [i] = j + "2" + j;
                j = (j == 9 ? 1 : j+1);
            }
            if (i >= 54 & i < 63) {
                numbers [i] = j + "3" + j;
                j = (j == 9 ? 1 : j+1);
            }
            if (i >= 63 & i < 72) {
                numbers [i] = j + "4" + j;
                j = (j == 9 ? 1 : j+1);
            }
            if (i >= 72 & i < 81) {
                numbers [i] = j + "5" + j;
                j = (j == 9 ? 1 : j+1);
            }
            if (i >= 81 & i < 90) {
                numbers [i] = j + "6" + j;
                j = (j == 9 ? 1 : j+1);
            }
            if (i >= 90 & i < 99) {
                numbers [i] = j + "7" + j;
                j = (j == 9 ? 1 : j+1);
            }
            if (i >= 99 & i < 108) {
                numbers [i] = j + "8" + j;
                j = (j == 9 ? 1 : j+1);
            }
            if (i >= 108 & i < 117) {
                numbers [i] = j + "9" + j;
                j = (j == 9 ? 1 : j+1);
            }
        }
        return numbers;
    }
}
