package main.controllers;
import main.model.ColorsBD;
import main.servises.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class ColorController {

    private final ColorService colorService;

    @Autowired
    public ColorController(ColorService colorService) {
        this.colorService = colorService;
    }

    @PostMapping(value = "/colors")
    public ResponseEntity<?> create(@RequestBody ColorsBD color) {
        colorService.create(color);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/colors")
    public ResponseEntity<List<ColorsBD>> read() {
        final List<ColorsBD> colors = colorService.readAll();

        return colors != null &&  !colors.isEmpty()
                ? new ResponseEntity<>(colors, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/colors/{id}")
    public ResponseEntity<ColorsBD> read(@PathVariable(name = "id") int id) {
        final ColorsBD color = colorService.read(id);

        return color != null
                ? new ResponseEntity<>(color, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/colors/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody ColorsBD color) {
        final Boolean updated = colorService.update(color, id);
        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/colors/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        final Boolean deleted = colorService.delete(id);
        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
