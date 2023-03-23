import core.Line;
import core.Station;
import junit.framework.TestCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

@DisplayName("Тестирование корректности маршрутов")
class RouteTest extends TestCase {
    private String[] stationLine2 = {"Петроградская", "Горьковская", "Невский проспект", "Сенная площадь", "Технологический институт",
            "Фрунзенская"};
    private String[] stationLine4 = {"Спасская", "Достоевская", "Лиговский проспект", "Площадь Александра Невского",
            "Новочеркасская"};
    private String[] stationLine3 = {"Василеостровская", "Гостиный двор", "Маяковская"};

    private Line line2 = new Line(2, "Московско-Петроградская");
    private Line line3 = new Line(3, "Невско-Василеостровская");
    private Line line4 = new Line(4, "Правобережная");
    List<Station> routeOneConnection;
    List<Station> routeTwoConnection;
    List<Station> shortRoute;
    StationIndex stationIndex;
    ArrayList<Station >stations = new ArrayList<>();
    RouteCalculator calculator;

    @BeforeEach
    protected void setUp() {
        shortRoute = new ArrayList<>();
        routeOneConnection = new ArrayList<>();
        routeTwoConnection = new ArrayList<>();

        shortRoute.add(new Station("Новочеркасская", line4));
        shortRoute.add(new Station("Площадь Александра Невского", line4));
        shortRoute.add(new Station("Лиговский проспект", line4));

        routeOneConnection.add(new Station("Новочеркасская", line4));
        routeOneConnection.add(new Station("Площадь Александра Невского", line4));
        routeOneConnection.add(new Station("Лиговский проспект", line4));
        routeOneConnection.add(new Station("Достоевская", line4));
        routeOneConnection.add(new Station("Спасская", line4));
        routeOneConnection.add(new Station("Сенная площадь", line2));
        routeOneConnection.add(new Station("Невский проспект", line2));
        routeOneConnection.add(new Station("Горьковская", line2));
        routeOneConnection.add(new Station("Петроградская", line2));

        routeTwoConnection.add(new Station("Василеостровская", line3));
        routeTwoConnection.add(new Station("Гостиный двор", line3));
        routeTwoConnection.add(new Station("Невский проспект", line2));
        routeTwoConnection.add(new Station("Сенная площадь", line2));
        routeTwoConnection.add(new Station("Спасская", line4));
        routeTwoConnection.add(new Station("Достоевская", line4));
        routeTwoConnection.add(new Station("Лиговский проспект", line4));
        generateStatIonIndex ();
    }
    @Test
    @DisplayName("Тестирование корректности времени")
     void testCalculateDuration(){

        double actual = RouteCalculator.calculateDuration(routeOneConnection);
        double expected = 21;
        assertEquals(expected, actual);
    }
    @Test
    @DisplayName("Тестирование маршрута без пересадок")
    void testShorRoute () {
        Station from = fromStation("Новочеркасская");
        Station to = toStation("Лиговский проспект");

        List<Station> actual = calculator.getShortestRoute(from, to);
        List<Station> expected = shortRoute;
        assertEquals(expected, actual);

    }
    @Test
    @DisplayName("Тестирование маршрута с одной пересадкой")
    void testOneConnection () {
        Station from = fromStation("Новочеркасская");
        Station to = toStation("Петроградская");

        List<Station> actual = calculator.getShortestRoute(from, to);
        List<Station> expected = routeOneConnection;
        assertEquals(expected, actual);
    }
    @Test
    @DisplayName("Тестирование маршрта с двумя пересадками")
    void testTwoConnection () {
        Station from = fromStation("Василеостровская");
        Station to = toStation("Лиговский проспект");

        List<Station> actual = calculator.getShortestRoute(from, to);
        List<Station> expected = routeTwoConnection;
        assertEquals(expected, actual);
    }


    private Station fromStation (String name) {
        for (Station station: stations) {
            if (station.getName().equals(name)) {
                return station;
            }
        }
        return null;
    }
    private Station toStation (String name) {
        for (Station station: stations) {
            if (station.getName().equals(name)) {
                return station;
            }
        }
        return null;
    }

    private void connections () {
        List<Station> connect3 = new ArrayList<>();
        connect3.add(stationIndex.getStation("Сенная Площадь", 2));
        connect3.add(stationIndex.getStation("Спасская", 4));
        stationIndex.addConnection(connect3);

        List<Station> connect1 = new ArrayList<>();
        connect1.add(stationIndex.getStation("Невский проспект", 2));
        connect1.add(stationIndex.getStation("Гостиный двор", 3));
        stationIndex.addConnection(connect1);

    }
    private void generateStatIonIndex () {
        stationIndex = new StationIndex();
        ArrayList<Station >stationsLine2 = new ArrayList<>();
        ArrayList<Station >stationsLine3 = new ArrayList<>();
        ArrayList<Station >stationsLine4 = new ArrayList<>();

        for (String station : stationLine2) {
            stationsLine2.add(new Station(station, line2));
        }
        stationsLine2.stream().forEach(station -> line2.addStation(station));
        line2.getStations().stream().forEach(station -> stationIndex.addStation(station));

        for (String station : stationLine3) {
            stationsLine3.add(new Station(station, line3));
        }
        stationsLine3.stream().forEach(station -> line3.addStation(station));
        line3.getStations().stream().forEach(station -> stationIndex.addStation(station));

        for (String station : stationLine4) {
            stationsLine4.add(new Station(station, line4));
        }
        stationsLine4.stream().forEach(station -> line4.addStation(station));
        line4.getStations().stream().forEach(station -> stationIndex.addStation(station));

        stationsLine2.stream().forEach(station -> stations.add(station));
        stationsLine3.stream().forEach(station -> stations.add(station));
        stationsLine4.stream().forEach(station -> stations.add(station));

        calculator = new RouteCalculator(stationIndex);
        stationIndex.addLine(line2);
        stationIndex.addLine(line3);
        stationIndex.addLine(line4);

        connections();
    }
}
