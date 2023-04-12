package main.controllers;
import main.model.Smartphones;
import main.model.TV;
import main.servises.SmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Comparator;
import java.util.List;

@RestController
public class SmartphoneController {

    private final SmartphoneService smartphoneService;

    @Autowired
    public SmartphoneController(SmartphoneService smartphoneService) {
        this.smartphoneService = smartphoneService;
    }

    @PostMapping(value = "/smartphones")
    public ResponseEntity<?> create(@RequestBody Smartphones smartphones) {
        smartphoneService.create(smartphones);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/smartphones")
    public ResponseEntity<List<Smartphones>> read() {
        final List<Smartphones> hoovers = smartphoneService.readAll();

        return hoovers != null &&  !hoovers.isEmpty()
                ? new ResponseEntity<>(hoovers, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/smartphones/{id}")
    public ResponseEntity<Smartphones> read(@PathVariable(name = "id") int id) {
        final Smartphones smartphones = smartphoneService.read(id);

        return smartphones != null
                ? new ResponseEntity<>(smartphones, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/smartphones/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody Smartphones smartphones) {
        final Boolean updated = smartphoneService.update(smartphones, id);
        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/smartphones/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        final Boolean deleted = smartphoneService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @GetMapping(value = "/smartphones/sortAbcAsc")
    public ResponseEntity<List<Smartphones>> sortABCAsc() {
        final List<Smartphones> smartphones = smartphoneService.readAll();
        smartphones.sort(Comparator.comparing(Smartphones::getName));
        return smartphones != null &&  !smartphones.isEmpty()
                ? new ResponseEntity<>(smartphones, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/smartphones/sortPriceAsc")
    public ResponseEntity<List<Smartphones>> sortNumberAsc() {
        final List<Smartphones> smartphones = smartphoneService.readAll();
        smartphones.sort(Comparator.comparing(Smartphones::getPrice));
        return smartphones != null &&  !smartphones.isEmpty()
                ? new ResponseEntity<>(smartphones, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/smartphones/sortAbcDesc")
    public ResponseEntity<List<Smartphones>> sortABCDesc() {
        final List<Smartphones> smartphones = smartphoneService.readAll();
        smartphones.sort(Comparator.comparing(Smartphones::getName).reversed());
        return smartphones != null &&  !smartphones.isEmpty()
                ? new ResponseEntity<>(smartphones, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/smartphones/sortPriceDesc")
    public ResponseEntity<List<Smartphones>> sortNumberDesc() {
        final List<Smartphones> smartphones = smartphoneService.readAll();
        smartphones.sort(Comparator.comparing(Smartphones::getPrice).reversed());
        return smartphones != null &&  !smartphones.isEmpty()
                ? new ResponseEntity<>(smartphones, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/smartphones/findName")
    public ResponseEntity<List<Smartphones>> findName(@RequestParam String name) {
        final List<Smartphones> smartphones = smartphoneService.findName(name);

        return smartphones != null &&  !smartphones.isEmpty()
                ? new ResponseEntity<>(smartphones, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/smartphones/findColor")
    public ResponseEntity<List<Smartphones>> findColor(@RequestParam String color) {
        final List<Smartphones> smartphones = smartphoneService.findColor(color);

        return smartphones != null &&  !smartphones.isEmpty()
                ? new ResponseEntity<>(smartphones, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/smartphones/findMemory")
    public ResponseEntity<List<Smartphones>> findCatTV(@RequestParam String memory) {
        final List<Smartphones> smartphones = smartphoneService.findMemory(memory);

        return smartphones != null &&  !smartphones.isEmpty()
                ? new ResponseEntity<>(smartphones, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/smartphones/findPriceBefore")
    public ResponseEntity<?> getListTvPriceBefore(@RequestParam Double price) {
        final List<Smartphones> smartphones = smartphoneService.getPriceBefore(price);
        return smartphones != null &&  !smartphones.isEmpty()
                ? new ResponseEntity<>(smartphones, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/smartphones/findPriceAfter")
    public ResponseEntity<?> getListTvPriceAfter(@RequestParam Double price) {
        final List<Smartphones> smartphones = smartphoneService.getPriceAfter(price);
        return smartphones != null &&  !smartphones.isEmpty()
                ? new ResponseEntity<>(smartphones, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/smartphones/findPriceAfterToBefore")
    public ResponseEntity<?> getListTvPriceAfterToBefore(@RequestParam Double priceAfter, Double priceBefore) {
        final List<Smartphones> smartphones = smartphoneService.getPriceAfterBefore(priceAfter, priceBefore);
        return smartphones != null &&  !smartphones.isEmpty()
                ? new ResponseEntity<>(smartphones, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
