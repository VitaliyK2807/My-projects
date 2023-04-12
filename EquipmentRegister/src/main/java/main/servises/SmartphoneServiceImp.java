package main.servises;
import main.model.Smartphones;
import main.model.SmartphonesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SmartphoneServiceImp implements SmartphoneService {
    @Autowired
    private SmartphonesRepository smartphonesRepository;

    @Override
    public void create(Smartphones smartphones) {
        smartphonesRepository.save(smartphones);
    }

    @Override
    public List<Smartphones> readAll() {
        return smartphonesRepository.findAll();
    }

    @Override
    public Smartphones read(int id) {
        return smartphonesRepository.getOne(id);
    }

    @Override
    public Boolean update(Smartphones smartphones, int id) {
        if (smartphonesRepository.existsById(id)) {
            smartphones.setId(id);
            smartphonesRepository.save(smartphones);
            return true;
        }
        return false;
    }

    @Override
    public Boolean delete(int id) {
        if (smartphonesRepository.existsById(id)) {
            smartphonesRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Smartphones> findColor(String color) {
        return smartphonesRepository.findByColor(color);
    }

    @Override
    public List<Smartphones> findName(String name) {
        return smartphonesRepository.findByNameIgnoreCase(name);
    }

    @Override
    public List<Smartphones> findMemory(String memory) {
        return smartphonesRepository.findByMemory(memory);
    }

    @Override
    public List<Smartphones> getPriceBefore(double price) {
        return smartphonesRepository.findByPriceBefore(price);
    }

    @Override
    public List<Smartphones> getPriceAfter(double price) {
        return smartphonesRepository.findByPriceAfter(price);
    }

    @Override
    public List<Smartphones> getPriceAfterBefore(double priceAfter, double priceBefore) {
        return smartphonesRepository.findBuPriceBeforeAfter(priceAfter, priceBefore);
    }
}
