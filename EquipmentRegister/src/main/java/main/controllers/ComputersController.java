package main.controllers;
import main.model.Computers;
import main.model.Fridge;
import main.servises.ComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

@RestController
public class ComputersController {

    private final ComputerService computerService;

    @Autowired
    public ComputersController(ComputerService computerService) {
        this.computerService = computerService;
    }

    @PostMapping(value = "/computers")
    public ResponseEntity<?> create(@RequestBody Computers computers) {
        computerService.create(computers);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/computers")
    public ResponseEntity<List<Computers>> read() {
        final List<Computers> computers = computerService.readAll();

        return computers != null &&  !computers.isEmpty()
                ? new ResponseEntity<>(computers, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/computers/{id}")
    public ResponseEntity<Computers> read(@PathVariable(name = "id") int id) {
        final Computers computers = computerService.read(id);

        return computers != null
                ? new ResponseEntity<>(computers, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/computers/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody Computers computers) {
        final Boolean updated = computerService.update(computers, id);
        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/computers/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        final Boolean deleted = computerService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @GetMapping(value = "/computers/sortAbcAsc")
    public ResponseEntity<List<Computers>> sortABCAsc() {
        final List<Computers> computers = computerService.readAll();
        computers.sort(Comparator.comparing(Computers::getName));
        return computers != null &&  !computers.isEmpty()
                ? new ResponseEntity<>(computers, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/computers/sortPriceAsc")
    public ResponseEntity<List<Computers>> sortNumberAsc() {
        final List<Computers> computers = computerService.readAll();
        computers.sort(Comparator.comparing(Computers::getPrice));
        return computers != null &&  !computers.isEmpty()
                ? new ResponseEntity<>(computers, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/computers/sortAbcDesc")
    public ResponseEntity<List<Computers>> sortABCDesc() {
        final List<Computers> computers = computerService.readAll();
        computers.sort(Comparator.comparing(Computers::getName).reversed());
        return computers != null &&  !computers.isEmpty()
                ? new ResponseEntity<>(computers, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/computers/sortPriceDesc")
    public ResponseEntity<List<Computers>> sortNumberDesc() {
        final List<Computers> computers = computerService.readAll();
        computers.sort(Comparator.comparing(Computers::getPrice).reversed());
        return computers != null &&  !computers.isEmpty()
                ? new ResponseEntity<>(computers, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/computers/findName")
    public ResponseEntity<List<Computers>> findName(@RequestParam String name) {
        final List<Computers> computers = computerService.findName(name);

        return computers != null &&  !computers.isEmpty()
                ? new ResponseEntity<>(computers, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/computers/findColor")
    public ResponseEntity<List<Computers>> findColor(@RequestParam String color) {
        final List<Computers> computers = computerService.findColor(color);

        return computers != null &&  !computers.isEmpty()
                ? new ResponseEntity<>(computers, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/computers/processorType")
    public ResponseEntity<List<Computers>> findCatTV(@RequestParam String type) {
        final List<Computers> computers = computerService.findProcessorType(type);

        return computers != null &&  !computers.isEmpty()
                ? new ResponseEntity<>(computers, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/computers/findPriceBefore")
    public ResponseEntity<?> getListTvPriceBefore(@RequestParam Double price) {
        final List<Computers> computers = computerService.getPriceBefore(price);
        return computers != null &&  !computers.isEmpty()
                ? new ResponseEntity<>(computers, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/computers/findPriceAfter")
    public ResponseEntity<?> getListTvPriceAfter(@RequestParam Double price) {
        final List<Computers> computers = computerService.getPriceAfter(price);
        return computers != null &&  !computers.isEmpty()
                ? new ResponseEntity<>(computers, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/computers/findPriceAfterToBefore")
    public ResponseEntity<?> getListTvPriceAfterToBefore(@RequestParam Double priceAfter, Double priceBefore) {
        final List<Computers> computers = computerService.getPriceAfterBefore(priceAfter, priceBefore);
        return computers != null &&  !computers.isEmpty()
                ? new ResponseEntity<>(computers, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
