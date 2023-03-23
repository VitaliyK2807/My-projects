package FileSearch;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DataWorking {
    private ParsingJSONFile jsonFile;
    private ParsingCSVFiles csvFiles;
    private String pathFiles;
    private Map<Integer, ArrayList<String>> stationsWeb;
    private Map<Integer, ArrayList<String>> linesWeb;
    private ArrayList<Map<String,String>> transitionsWeb;

    public DataWorking (String pathFiles){
        this.pathFiles = pathFiles;
        creatFile();
    }

    private void creatFile (){
        FileSearch fileSearch = new FileSearch();
        try {
            Files.walkFileTree(Paths.get(pathFiles), fileSearch);
            jsonFile = new ParsingJSONFile(fileSearch.getPathFilesJSON());
            csvFiles = new ParsingCSVFiles(fileSearch.getPathFilesCSV());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
    public void connectMapsIsWebSite (Map<Integer, ArrayList<String>> stationsWeb,
                                      Map<Integer, ArrayList<String>> linesWeb,
                                      ArrayList<Map<String,String>> transitionsWeb) {
        this.stationsWeb = stationsWeb;
        this.linesWeb = linesWeb;
        this.transitionsWeb = transitionsWeb;
    }

    public String toString () {
        StringBuilder maps = new StringBuilder();
        maps.append("{" + "\n");
        maps.append("\t" + "\"stations\": " + "[" + "\n");
        int count = 0;
        for (Map.Entry<Integer, ArrayList<String>> stationsList
                : getReadyList().entrySet()) {
            ArrayList<String> list = stationsList.getValue();
            if (++count != getReadyList().entrySet().size()) {
                maps.append("\t\t" + "{" + "\n");
                maps.append("\t\t\t" + list.get(0) + "," + "\n");
                if (!list.get(1).isEmpty()) {
                    maps.append("\t\t\t" + list.get(1) + "," + "\n");
                }
                maps.append("\t\t\t" + list.get(2) + "," + "\n");
                maps.append("\t\t\t" + list.get(3) + "," + "\n");
                maps.append("\t\t\t" + list.get(4) + "\n");
                maps.append("\t\t" + "}," + "\n");
            } else {
                maps.append("\t\t" + "{" + "\n");
                maps.append("\t\t\t" + list.get(0) + "," + "\n");
                if (!list.get(1).isEmpty()) {
                    maps.append("\t\t\t" + list.get(1) + "," + "\n");
                }
                maps.append("\t\t\t" + list.get(2) + "," + "\n");
                maps.append("\t\t\t" + list.get(3) + "," + "\n");
                maps.append("\t\t\t" + list.get(4) + "\n");
                maps.append("\t\t" + "}" + "\n");
            }

        }
        maps.append("\t" + "]");
        maps.append("}" + "\n");
        return maps.toString();
    }

    private Map<Integer,ArrayList<String>> getReadyList () {
        Map<Integer,ArrayList<String>> readyList = new HashMap<>();
        int count = 0;
        for (ArrayList<String> listCSV: csvFiles.getStations()) {
            readyList.put(++count, getListStations(listCSV));
        }
        return readyList;
    }

    private ArrayList<String> getListStations (ArrayList<String> station) {
        ArrayList<String> readyStations = new ArrayList<>();
        for (ArrayList<String> listJSON: jsonFile.getStations()) {
            if (station.get(0).equals(listJSON.get(0))) {
                readyStations.add("\"name\": " + "\"" + station.get(0) + "\"");
                if (getNameLine(station.get(0)).isEmpty()) {
                    readyStations.add("");
                } else {
                    readyStations.add("\"line\": " + "\"" + getNameLine(station.get(0)) + "\"");
                }
                readyStations.add("\"date\": " + "\"" + station.get(1) + "\"");
                readyStations.add("\"depth\": " + "\"" + listJSON.get(1) + "\"");
                readyStations.add("\"hasConnection\": " + "\"" + getTransition(station.get(0)) + "\"");
                break;
            }
        }
        return readyStations;
    }
    private String getNameLine (String nameStation) {
        String nameLine = "";
        for (Map.Entry<Integer, ArrayList<String>> stations: stationsWeb.entrySet()) {
            int key = stations.getKey();
            ArrayList<String> listStations = stations.getValue();
            for (String listStationName: listStations) {
                if (listStationName.toLowerCase().contains(nameStation.toLowerCase())) {
                    nameLine = getName(key);
                }
            }
        }
        return nameLine;
    }
    private String getName (int keyName) {
        String name = "";
        for (Map.Entry<Integer, ArrayList<String>> lines: linesWeb.entrySet()) {
            int key = lines.getKey();
            ArrayList<String> linesName = lines.getValue();
            if (key == keyName) {
                name = linesName.get(1);
            }
        }
            return name;
    }

    private Boolean getTransition (String name) {
        for (Map<String, String> line: transitionsWeb){
            for (Map.Entry<String, String> lineStation: line.entrySet()) {
                String nameStation = lineStation.getValue();
                if (nameStation.contains(name)) {
                    return true;
                }
            }
        }
        return false;
    }
}
