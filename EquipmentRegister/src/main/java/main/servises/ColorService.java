package main.servises;
import main.model.ColorsBD;
import java.util.List;

public interface ColorService {

    void create (ColorsBD color);

    List<ColorsBD> readAll();

    ColorsBD read(int id);

    Boolean update (ColorsBD color, int id);

    Boolean delete (int id);
}
