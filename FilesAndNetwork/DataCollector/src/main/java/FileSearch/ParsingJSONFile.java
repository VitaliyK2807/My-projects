package FileSearch;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ParsingJSONFile {

    private ArrayList<ArrayList<String>> searchList;
    private ArrayList<Path> path;
    private ArrayList<ArrayList<String>> memoryList;

    public ParsingJSONFile(ArrayList<Path> path) {
        this.path = path;
        searchList = new ArrayList<>();
        try {
            parsing();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void parsing (){
        JSONParser parser = new JSONParser();
        ArrayList<ArrayList<String>> memory = new ArrayList<>();
        path.forEach(pathFile -> {
            JSONArray jsonData = null;
            try {
                jsonData = (JSONArray) parser.parse(getJsonFile(pathFile));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            memory.addAll(parseName(jsonData));
                });
        searchList.addAll(matchTest(memory));
    }

    private ArrayList<ArrayList<String>> parseName(JSONArray linesArray) {
        ArrayList<ArrayList<String>> memory = new ArrayList<>();
        linesArray.forEach(lineObject -> {
            JSONObject lineJsonObject = (JSONObject) lineObject;
            memory.add(getStation(lineJsonObject));
        });
        return memory;
    }
    private ArrayList<ArrayList<String>> matchTest (ArrayList<ArrayList<String>> list) {
        memoryList = new ArrayList<>();
        for (ArrayList<String> stations : list) {
            if (!memoryList.isEmpty()) {
               getMinDepthStation(stations);
            } else {
                memoryList.add(stations);
            }
        }
        return memoryList;
    }

    private void getMinDepthStation (ArrayList<String> searchList) {
        int count = 1;
        String station = "";
        for (ArrayList<String> stationSearch : memoryList) {
            if (searchList.get(0).equals(stationSearch.get(0))) {
                if (searchList.get(1).equals("?")){
                    memoryList.add(getListStation(searchList.get(0), searchList.get(1)));
                    break;
                }
                if (Double.valueOf(stationSearch.get(1)) > Double.valueOf(searchList.get(1))) {
                    memoryList.remove(count-1);
                    memoryList.add(getListStation(searchList.get(0), searchList.get(1)));
                    break;
                } else {
                    break;
                }
            }
            if (memoryList.size() == count && station.isEmpty()) {
                memoryList.add(getListStation(searchList.get(0), searchList.get(1)));
                break;
            }
            count++;
        }
    }

    private ArrayList<String> getListStation (String name, String depth) {
        ArrayList<String> station = new ArrayList<>();
        station.add(name);
        station.add(depth);
        return station;
    }
    private ArrayList<String> getStation (JSONObject lineJsonObject) {
        ArrayList<String> station = new ArrayList<>();
        station.add(String.valueOf(lineJsonObject.get("station_name")));
        String depth = (String) lineJsonObject.get("depth");
        if (depth.equals("?")) {
            station.add(depth);
        } else {
            station.add(depth.replace(',', '.'));
        }
        return station;
    }
    private String getJsonFile (Path path) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        List<String> lines = Files.readAllLines(path);
        lines.forEach(line -> stringBuilder.append(line));
        return stringBuilder.toString();
    }

    public ArrayList<ArrayList<String>> getStations() {
        return new ArrayList<>(searchList);
    }



}
