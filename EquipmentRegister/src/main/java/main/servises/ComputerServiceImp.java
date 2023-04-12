package main.servises;
import main.model.Computers;
import main.model.ComputersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ComputerServiceImp implements ComputerService{

    @Autowired
    private ComputersRepository computersRepository;

    @Override
    public void create(Computers computers) {
        computersRepository.save(computers);
    }

    @Override
    public List<Computers> readAll() {
        return computersRepository.findAll();
    }

    @Override
    public Computers read(int id) {
        return computersRepository.getOne(id);
    }

    @Override
    public Boolean update(Computers computers, int id) {
        if (computersRepository.existsById(id)) {
            computers.setId(id);
            computersRepository.save(computers);
            return true;
        }
        return false;
    }

    @Override
    public Boolean delete(int id) {
        if (computersRepository.existsById(id)) {
            computersRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Computers> findName(String name) {
        return computersRepository.findByNameIgnoreCase(name);
    }

    @Override
    public List<Computers> findColor(String color) {
        return computersRepository.findByColor(color);
    }

    @Override
    public List<Computers> findProcessorType(String type) {
        return computersRepository.findByProcessorType(type);
    }

    @Override
    public List<Computers> getPriceBefore(double price) {
        return computersRepository.findByPriceBefore(price);
    }

    @Override
    public List<Computers> getPriceAfter(double price) {
        return computersRepository.findByPriceAfter(price);
    }

    @Override
    public List<Computers> getPriceAfterBefore(double priceAfter, double priceBefore) {
        return computersRepository.findBuPriceBeforeAfter(priceAfter, priceBefore);
    }
}
