package main.servises;
import main.model.TV;
import java.util.List;

public interface TVService {

    void create (TV tv);

    List<TV> readAll();

    TV read(int id);

    Boolean update (TV tv, int id);

    Boolean delete (int id);

    List<TV> findName (String name);

    List<TV> findColor (String color);

    List<TV> findCatTV (String catTV);

    List<TV> getPriceBefore (double price);
    List<TV> getPriceAfter (double price);
    List<TV> getPriceAfterBefore (double priceAfter, double priceBefore);

}
