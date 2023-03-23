import com.skillbox.airport.Aircraft;
import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import com.skillbox.airport.Terminal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Airport airport = Airport.getInstance();
        List<Flight> flight = findPlanesLeavingInTheNextTwoHours(airport);
        flight.stream()
                .forEach(System.out::println);
    }

    public static List<Flight> findPlanesLeavingInTheNextTwoHours(Airport airport) {
        //TODO Метод должден вернуть список рейсов вылетающих в ближайшие два часа.
        LocalDateTime currentTime = LocalDateTime.now();
        List<Terminal> terminal = airport.getTerminals();
        List<Flight> listOfFlights = terminal.stream()
                .flatMap(flight ->
                        flight.getFlights().stream()
                                .filter(type -> type.getType().equals(Flight.Type.DEPARTURE))
                                .filter(time -> {
                                    int hour = time.getDate().getHours();
                                    if (hour >= currentTime.getHour() &&
                                            hour <= currentTime.getHour() + 2) {
                                        return true;
                                    }
                                    return false;
                                })
                        )
                .collect(Collectors.toList());

        return listOfFlights;
    }

}