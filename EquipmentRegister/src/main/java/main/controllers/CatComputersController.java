package main.controllers;
import main.model.CategoryComputers;
import main.servises.CatComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class CatComputersController {

    private final CatComputerService catComputerService;

    @Autowired
    public CatComputersController(CatComputerService catComputerService) {
        this.catComputerService = catComputerService;
    }

    @PostMapping(value = "/catComputers")
    public ResponseEntity<?> create(@RequestBody CategoryComputers categoryComputers) {
        catComputerService.create(categoryComputers);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/catComputers")
    public ResponseEntity<List<CategoryComputers>> read() {
        final List<CategoryComputers> category = catComputerService.readAll();

        return category != null &&  !category.isEmpty()
                ? new ResponseEntity<>(category, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/catComputers/{id}")
    public ResponseEntity<CategoryComputers> read(@PathVariable(name = "id") int id) {
        final CategoryComputers category = catComputerService.read(id);

        return category != null
                ? new ResponseEntity<>(category, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/catComputers/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id,
                                    @RequestBody CategoryComputers category) {
        final Boolean updated = catComputerService.update(category, id);
        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/catComputers/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        final Boolean deleted = catComputerService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
