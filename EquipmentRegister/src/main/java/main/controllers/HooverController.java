package main.controllers;
import main.model.Hoover;
import main.model.Smartphones;
import main.servises.HooverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Comparator;
import java.util.List;

@RestController
public class HooverController {

    private final HooverService hooverService;

    @Autowired
    public HooverController(HooverService hooverService) {
        this.hooverService = hooverService;
    }

    @PostMapping(value = "/hoovers")
    public ResponseEntity<?> create(@RequestBody Hoover hoover) {
        hooverService.create(hoover);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/hoovers")
    public ResponseEntity<List<Hoover>> read() {
        final List<Hoover> hoovers = hooverService.readAll();

        return hoovers != null &&  !hoovers.isEmpty()
                ? new ResponseEntity<>(hoovers, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/hoovers/{id}")
    public ResponseEntity<Hoover> read(@PathVariable(name = "id") int id) {
        final Hoover hoover = hooverService.read(id);

        return hoover != null
                ? new ResponseEntity<>(hoover, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/hoovers/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody Hoover hoover) {
        final Boolean updated = hooverService.update(hoover, id);
        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/hoovers/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        final Boolean deleted = hooverService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @GetMapping(value = "/hoovers/sortAbcAsc")
    public ResponseEntity<List<Hoover>> sortABCAsc() {
        final List<Hoover> hoover = hooverService.readAll();
        hoover.sort(Comparator.comparing(Hoover::getName));
        return hoover != null &&  !hoover.isEmpty()
                ? new ResponseEntity<>(hoover, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/hoovers/sortPriceAsc")
    public ResponseEntity<List<Hoover>> sortNumberAsc() {
        final List<Hoover> hoover = hooverService.readAll();
        hoover.sort(Comparator.comparing(Hoover::getPrice));
        return hoover != null &&  !hoover.isEmpty()
                ? new ResponseEntity<>(hoover, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/hoovers/sortAbcDesc")
    public ResponseEntity<List<Hoover>> sortABCDesc() {
        final List<Hoover> hoover = hooverService.readAll();
        hoover.sort(Comparator.comparing(Hoover::getName).reversed());
        return hoover != null &&  !hoover.isEmpty()
                ? new ResponseEntity<>(hoover, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/hoovers/sortPriceDesc")
    public ResponseEntity<List<Hoover>> sortNumberDesc() {
        final List<Hoover> hoover = hooverService.readAll();
        hoover.sort(Comparator.comparing(Hoover::getPrice).reversed());
        return hoover != null &&  !hoover.isEmpty()
                ? new ResponseEntity<>(hoover, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/hoovers/findName")
    public ResponseEntity<List<Hoover>> findName(@RequestParam String name) {
        final List<Hoover> hoover = hooverService.findName(name);

        return hoover != null &&  !hoover.isEmpty()
                ? new ResponseEntity<>(hoover, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/hoovers/findColor")
    public ResponseEntity<List<Hoover>> findColor(@RequestParam String color) {
        final List<Hoover> hoover = hooverService.findColor(color);

        return hoover != null &&  !hoover.isEmpty()
                ? new ResponseEntity<>(hoover, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/hoovers/DustContainerVolume")
    public ResponseEntity<List<Hoover>> findCatTV(@RequestParam Double volume) {
        final List<Hoover> hoover = hooverService.findVolume(volume);

        return hoover != null &&  !hoover.isEmpty()
                ? new ResponseEntity<>(hoover, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/hoovers/findPriceBefore")
    public ResponseEntity<?> getListTvPriceBefore(@RequestParam Double price) {
        final List<Hoover> hoovers = hooverService.getPriceBefore(price);
        return hoovers != null &&  !hoovers.isEmpty()
                ? new ResponseEntity<>(hoovers, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/hoovers/findPriceAfter")
    public ResponseEntity<?> getListTvPriceAfter(@RequestParam Double price) {
        final List<Hoover> hoover = hooverService.getPriceAfter(price);
        return hoover != null &&  !hoover.isEmpty()
                ? new ResponseEntity<>(hoover, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/hoovers/findPriceAfterToBefore")
    public ResponseEntity<?> getListTvPriceAfterToBefore(@RequestParam Double priceAfter, Double priceBefore) {
        final List<Hoover> hoover = hooverService.getPriceAfterBefore(priceAfter, priceBefore);
        return hoover != null &&  !hoover.isEmpty()
                ? new ResponseEntity<>(hoover, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
