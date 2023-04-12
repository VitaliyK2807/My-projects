package main.servises;
import main.model.CategoryTV;
import java.util.List;

public interface CatTVService {

    void create (CategoryTV category);

    List<CategoryTV> readAll();

    CategoryTV read(int id);

    Boolean update (CategoryTV category, int id);

    Boolean delete (int id);
}
