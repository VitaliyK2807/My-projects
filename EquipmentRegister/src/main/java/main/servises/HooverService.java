package main.servises;
import main.model.Hoover;
import main.model.Smartphones;

import java.util.List;

public interface HooverService {
    void create (Hoover hoover);

    List<Hoover> readAll();

    Hoover read(int id);

    Boolean update (Hoover hover, int id);

    Boolean delete (int id);

    List<Hoover> findName (String name);

    List<Hoover> findColor (String color);

    List<Hoover> findVolume (Double volume);

    List<Hoover> getPriceBefore (double price);
    List<Hoover> getPriceAfter (double price);
    List<Hoover> getPriceAfterBefore (double priceAfter, double priceBefore);
}
