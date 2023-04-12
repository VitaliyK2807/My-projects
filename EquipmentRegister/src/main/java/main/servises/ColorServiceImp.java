package main.servises;
import main.model.ColorRepository;
import main.model.ColorsBD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ColorServiceImp implements ColorService {

    @Autowired
    private ColorRepository colorRepository;


    @Override
    public void create(ColorsBD color) {
        colorRepository.save(color);
    }

    @Override
    public List<ColorsBD> readAll() {
        return colorRepository.findAll();
    }

    @Override
    public ColorsBD read(int id) {
        return colorRepository.getOne(id);
    }

    @Override
    public Boolean update(ColorsBD color, int id) {
        if (colorRepository.existsById(id)) {
            color.setId(id);
            colorRepository.save(color);
            return true;
        }
        return false;
    }

    @Override
    public Boolean delete(int id) {
        if (colorRepository.existsById(id)) {
            colorRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
