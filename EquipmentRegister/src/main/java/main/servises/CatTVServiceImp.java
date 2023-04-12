package main.servises;
import main.model.CategoryTV;
import main.model.CategoryTVRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CatTVServiceImp implements CatTVService{
    @Autowired
    private CategoryTVRepository categoryTVRepository;

    @Override
    public void create(CategoryTV categoryTV) {
        categoryTVRepository.save(categoryTV);
    }

    @Override
    public List<CategoryTV> readAll() {
        return categoryTVRepository.findAll();
    }

    @Override
    public CategoryTV read(int id) {
        return categoryTVRepository.getOne(id);
    }

    @Override
    public Boolean update(CategoryTV categoryTV, int id) {
        if (categoryTVRepository.existsById(id)) {
            categoryTV.setId(id);
            categoryTVRepository.save(categoryTV);
            return true;
        }
        return false;
    }

    @Override
    public Boolean delete(int id) {
        if (categoryTVRepository.existsById(id)) {
            categoryTVRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
