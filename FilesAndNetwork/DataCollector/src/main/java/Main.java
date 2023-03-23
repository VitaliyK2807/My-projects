import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

import java.nio.file.Paths;

public class Main {
    private static final String PATH_SITE = "https://skillbox-java.github.io/";
    private static final String PATH_SEARCH_FILE = "data";
    private static final String PATH_RESULT_METRO_MAP = "src/Main/JsonFiles/";
    private static final String METRO_MOSCOW_MAP = "mapMetroMoscow.json";

    private static final String METRO_JSON_CSV_MAP = "mapIsJsonCsvFiles.json";
    public static void main(String[] args)  {
        try {
            DataCollection work = new DataCollection(PATH_SITE, PATH_SEARCH_FILE);
            writeInFileMapMetroMoscow(work.getDataWebSite());
            writeInFileMapJsonAndCsvFiles(work.getDataJsonCsvFiles());
            System.out.println("Парсинг завершен!");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }


    private static void writeInFileMapMetroMoscow (String string) {
        byte[] bytes = string.getBytes(StandardCharsets.UTF_8);
        try {
            if (!Files.exists(Paths.get(PATH_RESULT_METRO_MAP + METRO_MOSCOW_MAP))) {
                Files.write(Paths.get(PATH_RESULT_METRO_MAP + METRO_MOSCOW_MAP), bytes);
                System.out.println("Создан файл: " + PATH_RESULT_METRO_MAP + METRO_MOSCOW_MAP);
            } else {
                Files.delete(Paths.get(PATH_RESULT_METRO_MAP + METRO_MOSCOW_MAP));
                Files.write(Paths.get(PATH_RESULT_METRO_MAP + METRO_MOSCOW_MAP), bytes);
                System.out.println("Файл перезаписан: " + PATH_RESULT_METRO_MAP + METRO_MOSCOW_MAP);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void writeInFileMapJsonAndCsvFiles (String string) {
        byte[] bytes = string.getBytes(StandardCharsets.UTF_8);
        try {
            if (!Files.exists(Paths.get(PATH_RESULT_METRO_MAP + METRO_JSON_CSV_MAP))) {
                Files.write(Paths.get(PATH_RESULT_METRO_MAP + METRO_JSON_CSV_MAP), bytes);
                System.out.println("Создан файл: " + PATH_RESULT_METRO_MAP + METRO_JSON_CSV_MAP);
            } else {
                Files.delete(Paths.get(PATH_RESULT_METRO_MAP + METRO_JSON_CSV_MAP));
                Files.write(Paths.get(PATH_RESULT_METRO_MAP + METRO_JSON_CSV_MAP), bytes);
                System.out.println("Файл перезаписан: " + PATH_RESULT_METRO_MAP + METRO_JSON_CSV_MAP);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

