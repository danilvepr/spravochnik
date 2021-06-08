package ru.vsu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vsu.model.abonent;
import ru.vsu.Manager;

import java.util.List;

@RestController
@RequestMapping("/abonent")
public class AbonentController {
    private final Manager manager;

    @Autowired
    public AbonentController(Manager manager) {
        this.manager = manager;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)

    @PostMapping()
    public void createAbon(@RequestParam("surname") String surname, @RequestParam("name") String name,
                           @RequestParam("telefon1") String telefon1, @RequestParam("telefon2") String telefon2,
                           @RequestParam("telefon3") String telefon3  ) {
        abonent chelovec = new abonent(surname, name, telefon1, telefon2,telefon3);
        manager.add(chelovec);

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) {
        manager.delete(id);
    }

    @PutMapping("/{id}")
    public abonent updateAbon(@PathVariable("id") int id, @RequestParam("surname") String surname, @RequestParam("name") String name,
                           @RequestParam("telefon1") String telefon1, @RequestParam("telefon2") String telefon2,
                           @RequestParam("telefon3") String telefon3  ) {
        abonent chelovec = new abonent(surname, name, telefon1, telefon2,telefon3);
        chelovec.setId(id);
        manager.edit(id,chelovec);
        return chelovec;
    }

    @GetMapping()
//    public ResponseEntity<List<abonent>> showAbonen(){
    public List<abonent> showAbonen(){
//    public boolean showAbonen(){
        List<abonent> abon = manager.abonen();
        if(abon != null) return abon;
        else return null;
//        if(abon != null) return new ResponseEntity<>(abon, HttpStatus.OK);
//        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping("/{id}")
    public ResponseEntity<abonent> show(@PathVariable("id") int id) {
        return new ResponseEntity<>(manager.chel(id),HttpStatus.OK);
    }
}
