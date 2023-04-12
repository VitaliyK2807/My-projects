package main.servises;
import main.model.TV;
import main.model.TVRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TVServiceImp implements TVService {
    @Autowired
    private TVRepository tvRepository;

    @Override
    public void create(TV tv) {
        tvRepository.save(tv);
    }

    @Override
    public List<TV> readAll() {
        return tvRepository.findAll();
    }

    @Override
    public TV read(int id) {
        return tvRepository.getOne(id);
    }

    @Override
    public Boolean update(TV tv, int id) {
        if (tvRepository.existsById(id)) {
            tv.setId(id);
            tvRepository.save(tv);
            return true;
        }
        return false;
    }

    @Override
    public Boolean delete(int id) {
        if (tvRepository.existsById(id)) {
            tvRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<TV> findName (String name) {
        return tvRepository.findByNameIgnoreCase(name);
    }

    @Override
    public List<TV> findColor(String color) {
        return tvRepository.findByColor(color);
    }

    @Override
    public List<TV> findCatTV(String catTV) {
        return tvRepository.findByCatTV(catTV);
    }

    @Override
    public List<TV> getPriceBefore(double price) {
        return tvRepository.findByPriceBefore(price);
    }

    @Override
    public List<TV> getPriceAfter(double price) {
        return tvRepository.findByPriceAfter(price);
    }

    @Override
    public List<TV> getPriceAfterBefore(double priceAfter, double priceBefore) {
        return tvRepository.findBuPriceBeforeAfter(priceAfter, priceBefore);
    }
}
