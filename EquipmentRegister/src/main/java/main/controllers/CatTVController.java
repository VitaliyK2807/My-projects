package main.controllers;
import main.model.CategoryTV;
import main.servises.CatTVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class CatTVController {

    private final CatTVService catTVService;

    @Autowired
    public CatTVController(CatTVService catTVService) {
        this.catTVService = catTVService;
    }

    @PostMapping(value = "/categoryTVs")
    public ResponseEntity<?> create(@RequestBody CategoryTV category) {
        catTVService.create(category);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/categoryTVs")
    public ResponseEntity<List<CategoryTV>> read() {
        final List<CategoryTV> category = catTVService.readAll();

        return category != null &&  !category.isEmpty()
                ? new ResponseEntity<>(category, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/categoryTVs/{id}")
    public ResponseEntity<CategoryTV> read(@PathVariable(name = "id") int id) {
        final CategoryTV category = catTVService.read(id);

        return category != null
                ? new ResponseEntity<>(category, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/categoryTVs/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id,
                                    @RequestBody CategoryTV category) {
        final Boolean updated = catTVService.update(category, id);
        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/categoryTVs/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        final Boolean deleted = catTVService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
