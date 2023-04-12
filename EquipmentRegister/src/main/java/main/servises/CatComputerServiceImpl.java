package main.servises;
import main.model.CategoryComputers;
import main.model.CategoryComputersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatComputerServiceImpl implements CatComputerService{

    @Autowired
    private CategoryComputersRepository categoryComputersRepository;

    @Override
    public void create(CategoryComputers categoryComputers) {
        categoryComputersRepository.save(categoryComputers);
    }

    @Override
    public List<CategoryComputers> readAll() {
        return categoryComputersRepository.findAll();
    }

    @Override
    public CategoryComputers read(int id) {
        return categoryComputersRepository.getOne(id);
    }

    @Override
    public Boolean update(CategoryComputers computers, int id) {
        if (categoryComputersRepository.existsById(id)) {
            computers.setId(id);
            categoryComputersRepository.save(computers);
            return true;
        }
        return false;
    }

    @Override
    public Boolean delete(int id) {
        if (categoryComputersRepository.existsById(id)) {
            categoryComputersRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
