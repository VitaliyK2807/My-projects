package main.servises;
import main.model.Hoover;
import main.model.HooverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class HoverServiceImp implements HooverService {

    @Autowired
    private HooverRepository hooverRepository;

    @Override
    public void create(Hoover hoover) {
        hooverRepository.save(hoover);
    }

    @Override
    public List<Hoover> readAll() {
        return hooverRepository.findAll();
    }

    @Override
    public Hoover read(int id) {
        return hooverRepository.getOne(id);
    }

    @Override
    public Boolean update(Hoover hover, int id) {
        if (hooverRepository.existsById(id)) {
            hover.setId(id);
            hooverRepository.save(hover);
            return true;
        }
        return false;
    }

    @Override
    public Boolean delete(int id) {
        if (hooverRepository.existsById(id)) {
            hooverRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Hoover> findName(String name) {
        return hooverRepository.findByNameIgnoreCase(name);
    }

    @Override
    public List<Hoover> findColor(String color) {
        return hooverRepository.findByColor(color);
    }

    @Override
    public List<Hoover> findVolume(Double volume) {
        return hooverRepository.findByDustContainerVolume(volume);
    }

    @Override
    public List<Hoover> getPriceBefore(double price) {
        return hooverRepository.findByPriceBefore(price);
    }

    @Override
    public List<Hoover> getPriceAfter(double price) {
        return hooverRepository.findByPriceAfter(price);
    }

    @Override
    public List<Hoover> getPriceAfterBefore(double priceAfter, double priceBefore) {
        return hooverRepository.findBuPriceBeforeAfter(priceAfter, priceBefore);
    }
}
