package practice.reverseArray;

public class ReverseArray {

    public static String[] reverse(String[] strings) {
        //TODO: Напишите код, который меняет порядок расположения элементов внутри массива на обратный.
        String reverseText = "";
        String [] reversArray = new String[strings.length];
        int j = 0;
        for (int i = strings.length - 1; i >= 0; i--) {
            j = (strings.length-1) - i;
            if (j < strings.length) {
               reversArray[j] = strings [i];
            }
        }
        for (int i = 0; i < reversArray.length; i++) {
            strings [i] = reversArray [i];
        }
        //TODO: Первый код, у которого не проходит тест. Хотя результат тот же. И сам код короче.
//        for (int i = strings.length - 1; i >= 0; i--) {
//            reverseText = reverseText + strings[i] + " ";
//        }
//        strings = reverseText.split("\\s+");

        return strings;
    }


}