package main.controllers;
import main.model.TV;
import main.servises.TVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Comparator;
import java.util.List;


@RestController
public class TVController {
    @Autowired
    private final TVService tvService;

    @Autowired
    public TVController(TVService tvService) {
        this.tvService = tvService;
    }

    @PostMapping(value = "/tvs")
    public ResponseEntity<?> create(@RequestBody TV tv) {
        tvService.create(tv);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/tvs")
    public ResponseEntity<List<TV>> read() {
        final List<TV> tvs = tvService.readAll();

        return tvs != null &&  !tvs.isEmpty()
                ? new ResponseEntity<>(tvs, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/tvs/{id}")
    public ResponseEntity<TV> read(@PathVariable(name = "id") int id) {
        final TV tv = tvService.read(id);

        return tv != null
                ? new ResponseEntity<>(tv, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/tvs/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody TV tv) {
        final Boolean updated = tvService.update(tv, id);
        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/tvs/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        final Boolean deleted = tvService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @GetMapping(value = "/tvs/sortAbcAsc")
    public ResponseEntity<List<TV>> sortABCAsc() {
        final List<TV> tvs = tvService.readAll();
        tvs.sort(Comparator.comparing(TV::getName));
        return tvs != null &&  !tvs.isEmpty()
                ? new ResponseEntity<>(tvs, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/tvs/sortPriceAsc")
    public ResponseEntity<List<TV>> sortNumberAsc() {
        final List<TV> tvs = tvService.readAll();
        tvs.sort(Comparator.comparing(TV::getPrice));
        return tvs != null &&  !tvs.isEmpty()
                ? new ResponseEntity<>(tvs, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/tvs/sortAbcDesc")
    public ResponseEntity<List<TV>> sortABCDesc() {
        final List<TV> tvs = tvService.readAll();
        tvs.sort(Comparator.comparing(TV::getName).reversed());
        return tvs != null &&  !tvs.isEmpty()
                ? new ResponseEntity<>(tvs, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/tvs/sortPriceDesc")
    public ResponseEntity<List<TV>> sortNumberDesc() {
        final List<TV> tvs = tvService.readAll();
        tvs.sort(Comparator.comparing(TV::getPrice).reversed());
        return tvs != null &&  !tvs.isEmpty()
                ? new ResponseEntity<>(tvs, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/tvs/findName")
    public ResponseEntity<List<TV>> findName(@RequestParam String name) {
        final List<TV> tvs = tvService.findName(name);

        return tvs != null &&  !tvs.isEmpty()
                ? new ResponseEntity<>(tvs, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/tvs/findColor")
    public ResponseEntity<List<TV>> findColor(@RequestParam String color) {
        final List<TV> tvs = tvService.findColor(color);

        return tvs != null &&  !tvs.isEmpty()
                ? new ResponseEntity<>(tvs, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/tvs/findCatTV")
    public ResponseEntity<List<TV>> findCatTV(@RequestParam String catTV) {
        final List<TV> tvs = tvService.findCatTV(catTV);

        return tvs != null &&  !tvs.isEmpty()
                ? new ResponseEntity<>(tvs, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/tvs/findPriceBefore")
    public ResponseEntity<?> getListTvPriceBefore(@RequestParam Double price) {
        final List<TV> tvs = tvService.getPriceBefore(price);
        return tvs != null &&  !tvs.isEmpty()
                ? new ResponseEntity<>(tvs, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/tvs/findPriceAfter")
    public ResponseEntity<?> getListTvPriceAfter(@RequestParam Double price) {
        final List<TV> tvs = tvService.getPriceAfter(price);
        return tvs != null &&  !tvs.isEmpty()
                ? new ResponseEntity<>(tvs, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/tvs/findPriceAfterToBefore")
    public ResponseEntity<?> getListTvPriceAfterToBefore(@RequestParam Double priceAfter, Double priceBefore) {
        final List<TV> tvs = tvService.getPriceAfterBefore(priceAfter, priceBefore);
        return tvs != null &&  !tvs.isEmpty()
                ? new ResponseEntity<>(tvs, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
