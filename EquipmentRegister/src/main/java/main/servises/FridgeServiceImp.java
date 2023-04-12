package main.servises;
import main.model.Fridge;
import main.model.FridgeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FridgeServiceImp implements FridgeService{
    @Autowired
    private FridgeRepository fridgeRepository;

    @Override
    public void create(Fridge fridge) {
        fridgeRepository.save(fridge);
    }

    @Override
    public List<Fridge> readAll() {
        return fridgeRepository.findAll();
    }

    @Override
    public Fridge read(int id) {
        return fridgeRepository.getOne(id);
    }

    @Override
    public Boolean update(Fridge fridge, int id) {
        if (fridgeRepository.existsById(id)) {
            fridge.setId(id);
            fridgeRepository.save(fridge);
            return true;
        }
        return false;
    }

    @Override
    public Boolean delete(int id) {
        if (fridgeRepository.existsById(id)) {
            fridgeRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Fridge> findName(String name) {
        return fridgeRepository.findByNameIgnoreCase(name);
    }

    @Override
    public List<Fridge> findColor(String color) {
        return fridgeRepository.findByColor(color);
    }

    @Override
    public List<Fridge> findDoorsCount(Integer count) {
        return fridgeRepository.findByDoorsCount(count);
    }

    @Override
    public List<Fridge> getPriceBefore(double price) {
        return fridgeRepository.findByPriceBefore(price);
    }

    @Override
    public List<Fridge> getPriceAfter(double price) {
        return fridgeRepository.findByPriceAfter(price);
    }

        @Override
    public List<Fridge> getPriceAfterBefore(double priceAfter, double priceBefore) {
        return fridgeRepository.findBuPriceBeforeAfter(priceAfter, priceBefore);
    }
}
