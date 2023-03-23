import FileSearch.DataWorking;
import ParsingWebSite.WebSiteParsing;

import java.io.IOException;

public class DataCollection {

    private String pathWebSite;
    private String pathFiles;

    private DataWorking data;
    private WebSiteParsing metroMoscow;

    public DataCollection(String pathWebSite, String pathFiles) throws IOException {
        this.pathWebSite = pathWebSite;
        this.pathFiles = pathFiles;
        data = new DataWorking(pathFiles);
        metroMoscow = new WebSiteParsing(pathWebSite);
    }

    public String getDataJsonCsvFiles () {
        data.connectMapsIsWebSite(metroMoscow.getMapStations(),
                metroMoscow.getMapLines(),
                metroMoscow.getMapTransitions());
        return data.toString();
    }

    public String getDataWebSite () {
        return metroMoscow.toString();
    }
}
