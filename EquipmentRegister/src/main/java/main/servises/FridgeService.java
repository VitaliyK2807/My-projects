package main.servises;
import main.model.Fridge;
import main.model.Hoover;

import java.util.List;

public interface FridgeService {

    void create (Fridge fridge);

    List<Fridge> readAll();

    Fridge read(int id);

    Boolean update (Fridge fridge, int id);

    Boolean delete (int id);

    List<Fridge> findName (String name);

    List<Fridge> findColor (String color);

    List<Fridge> findDoorsCount (Integer count);

    List<Fridge> getPriceBefore (double price);
    List<Fridge> getPriceAfter (double price);
    List<Fridge> getPriceAfterBefore (double priceAfter, double priceBefore);
}
