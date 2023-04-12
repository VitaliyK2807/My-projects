package main.servises;
import main.model.Smartphones;
import main.model.TV;

import java.util.List;

public interface SmartphoneService {

    void create (Smartphones smartphones);

    List<Smartphones> readAll();

    Smartphones read(int id);

    Boolean update (Smartphones smartphones, int id);

    Boolean delete (int id);

    List<Smartphones> findColor (String color);

    List<Smartphones> findName (String name);

    List<Smartphones> findMemory (String memory);

    List<Smartphones> getPriceBefore (double price);
    List<Smartphones> getPriceAfter (double price);
    List<Smartphones> getPriceAfterBefore (double priceAfter, double priceBefore);
}
