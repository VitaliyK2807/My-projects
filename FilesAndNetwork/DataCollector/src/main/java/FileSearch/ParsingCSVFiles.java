package FileSearch;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ParsingCSVFiles {
    private ArrayList<ArrayList<String>> stations;
    private ArrayList<Path> path;

    public ParsingCSVFiles(ArrayList<Path> path) {
        this.path = path;
        stations = new ArrayList<>();
        scanFiles();
    }

    private void scanFiles () {
        path.forEach(pathFile -> parsing(pathFile));
    }

    private void parsing (Path path) {
        ArrayList<ArrayList<String>> memory = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(path);
            for (String line: lines) {
                String[] fragment = line.split(",");
                if (fragment.length != 2) {
                    System.out.println("length != 2");
                    continue;
                }
                if (fragment[0].equals("name")) {
                    continue;
                }
                memory.add(getListStation(fragment[0], fragment[1]));
            }
          stations.addAll(matchTest(memory));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    private ArrayList<String> getListStation (String name, String date) {
        ArrayList<String> station = new ArrayList<>();
        station.add(name);
        station.add(date);
        return station;
    }

    private ArrayList<ArrayList<String>> matchTest (ArrayList<ArrayList<String>> list) {
        ArrayList<ArrayList<String>> memoryCSV = new ArrayList<>();
        for (ArrayList<String> station : list) {
            if (!memoryCSV.isEmpty()) {
                int count = 1;
                for (ArrayList<String> stationSearch : memoryCSV) {
                    if (station.get(0).contains(stationSearch.get(0))
                            && station.get(1).equals(stationSearch.get(1))) {
                        break;
                    }
                    if (memoryCSV.size() == count++) {
                        memoryCSV.add(station);
                        break;
                    }
                }
            } else {
                memoryCSV.add(station);
            }
        }
        return memoryCSV;
    }
    public ArrayList<ArrayList<String>> getStations () {
        return new ArrayList<>(stations);
    }
}
