package main.servises;
import main.model.CategoryComputers;
import java.util.List;

public interface CatComputerService {

    void create (CategoryComputers categoryComputers);

    List<CategoryComputers> readAll();

    CategoryComputers read(int id);

    Boolean update (CategoryComputers categoryComputers, int id);

    Boolean delete (int id);
}
