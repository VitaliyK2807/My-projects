package main.servises;
import main.model.Computers;
import main.model.Fridge;

import java.util.List;

public interface ComputerService {

    void create (Computers computers);

    List<Computers> readAll();

    Computers read(int id);

    Boolean update (Computers computers, int id);

    Boolean delete (int id);

    List<Computers> findName (String name);

    List<Computers> findColor (String color);

    List<Computers> findProcessorType (String type);

    List<Computers> getPriceBefore (double price);
    List<Computers> getPriceAfter (double price);
    List<Computers> getPriceAfterBefore (double priceAfter, double priceBefore);
}
