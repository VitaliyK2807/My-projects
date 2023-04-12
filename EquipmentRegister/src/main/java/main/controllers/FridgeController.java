package main.controllers;
import main.model.Fridge;
import main.model.Hoover;
import main.servises.FridgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Comparator;
import java.util.List;

@RestController
public class FridgeController {

    private final FridgeService fridgeService;

    @Autowired
    public FridgeController(FridgeService fridgeService) {
        this.fridgeService = fridgeService;
    }

    @PostMapping(value = "/fridges")
    public ResponseEntity<?> create(@RequestBody Fridge fridge) {
        fridgeService.create(fridge);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/fridges")
    public ResponseEntity<List<Fridge>> read() {
        final List<Fridge> fridges = fridgeService.readAll();

        return fridges != null &&  !fridges.isEmpty()
                ? new ResponseEntity<>(fridges, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/fridges/{id}")
    public ResponseEntity<Fridge> read(@PathVariable(name = "id") int id) {
        final Fridge fridge = fridgeService.read(id);

        return fridge != null
                ? new ResponseEntity<>(fridge, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/fridges/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id,
                                    @RequestBody Fridge fridge) {
        final Boolean updated = fridgeService.update(fridge, id);
        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/fridges/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        final Boolean deleted = fridgeService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @GetMapping(value = "/fridges/sortAbcAsc")
    public ResponseEntity<List<Fridge>> sortABCAsc() {
        final List<Fridge> fridge = fridgeService.readAll();
        fridge.sort(Comparator.comparing(Fridge::getName));
        return fridge != null &&  !fridge.isEmpty()
                ? new ResponseEntity<>(fridge, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/fridges/sortPriceAsc")
    public ResponseEntity<List<Fridge>> sortNumberAsc() {
        final List<Fridge> fridge = fridgeService.readAll();
        fridge.sort(Comparator.comparing(Fridge::getPrice));
        return fridge != null &&  !fridge.isEmpty()
                ? new ResponseEntity<>(fridge, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/fridges/sortAbcDesc")
    public ResponseEntity<List<Fridge>> sortABCDesc() {
        final List<Fridge> fridge = fridgeService.readAll();
        fridge.sort(Comparator.comparing(Fridge::getName).reversed());
        return fridge != null &&  !fridge.isEmpty()
                ? new ResponseEntity<>(fridge, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/fridges/sortPriceDesc")
    public ResponseEntity<List<Fridge>> sortNumberDesc() {
        final List<Fridge> fridge = fridgeService.readAll();
        fridge.sort(Comparator.comparing(Fridge::getPrice).reversed());
        return fridge != null &&  !fridge.isEmpty()
                ? new ResponseEntity<>(fridge, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/fridges/findName")
    public ResponseEntity<List<Fridge>> findName(@RequestParam String name) {
        final List<Fridge> fridge = fridgeService.findName(name);

        return fridge != null &&  !fridge.isEmpty()
                ? new ResponseEntity<>(fridge, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/fridges/findColor")
    public ResponseEntity<List<Fridge>> findColor(@RequestParam String color) {
        final List<Fridge> fridge = fridgeService.findColor(color);

        return fridge != null &&  !fridge.isEmpty()
                ? new ResponseEntity<>(fridge, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/fridges/findCountDoors")
    public ResponseEntity<List<Fridge>> findCatTV(@RequestParam Integer count) {
        final List<Fridge> fridge = fridgeService.findDoorsCount(count);

        return fridge != null &&  !fridge.isEmpty()
                ? new ResponseEntity<>(fridge, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/fridges/findPriceBefore")
    public ResponseEntity<?> getListTvPriceBefore(@RequestParam Double price) {
        final List<Fridge> fridge = fridgeService.getPriceBefore(price);
        return fridge != null &&  !fridge.isEmpty()
                ? new ResponseEntity<>(fridge, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/fridges/findPriceAfter")
    public ResponseEntity<?> getListTvPriceAfter(@RequestParam Double price) {
        final List<Fridge> fridge = fridgeService.getPriceAfter(price);
        return fridge != null &&  !fridge.isEmpty()
                ? new ResponseEntity<>(fridge, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/fridges/findPriceAfterToBefore")
    public ResponseEntity<?> getListTvPriceAfterToBefore(@RequestParam Double priceAfter, Double priceBefore) {
        final List<Fridge> fridge = fridgeService.getPriceAfterBefore(priceAfter, priceBefore);
        return fridge != null &&  !fridge.isEmpty()
                ? new ResponseEntity<>(fridge, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
