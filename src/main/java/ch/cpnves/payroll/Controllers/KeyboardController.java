package ch.cpnves.payroll.Controllers;

import ch.cpnves.payroll.Repositories.KeyboardRepository;
import ch.cpnves.payroll.Entities.Keyboard;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class KeyboardController {

    private final KeyboardRepository repository;

    KeyboardController(KeyboardRepository repository){
        this.repository = repository;
    }

    /* curl sample :
    curl -i localhost:8080/keyboards
    */
    @GetMapping("/keyboards")
    List<Keyboard> all(){
        return repository.findAll();
    }

    /* curl sample :
    curl -i -X POST localhost:8080/keyboards \
    -H "Content-type:application/json" \
    -d "{\"name\": \"Russel George\", \"PCBFormat\": \"ANSI\", \"housing\": \"plastic\", \"numberOfKeycaps\": 87}"
    */
    @PostMapping("/keyboards")
    Keyboard newKeyboard(@RequestBody Keyboard newKeyboard){
        return repository.save(newKeyboard);
    }

    /* curl sample :
    curl -i localhost:8080/keyboards/1
    */
    @GetMapping("/keyboards/{id}")
    Keyboard one(@PathVariable Long id){
        return repository.findById(id)
                .orElseThrow(() -> new KeyboardNotFoundException(id));
    }

    /* curl sample :
    curl -i -X PUT localhost:8080/keyboards/2 ^
        -H "Content-type:application/json" ^
        -d "{\"name\": \"Russel George\", \"PCBFormat\": \"ANSI\", \"housing\": \"plastic\", \"numberOfKeycaps\": 87}"
     */
    @PutMapping("/keyboards/{id}")
    Keyboard replaceKeyboard(@RequestBody Keyboard newKeyboard, @PathVariable Long id) {
        return repository.findById(id)
                .map(keyboard -> {
                    keyboard.setName(newKeyboard.getName());
                    keyboard.setPCBFormat(newKeyboard.getPCBFormat());
                    keyboard.setHousing(newKeyboard.getHousing());
                    keyboard.setNumberOfKeycaps(newKeyboard.getNumberOfKeycaps());
                    return repository.save(keyboard);
                })
                .orElseGet(() -> {
                    newKeyboard.setId(id);
                    return repository.save(newKeyboard);
                });
    }

    /* curl sample :
    curl -i -X DELETE localhost:8080/keyboards/2
    */
    @DeleteMapping("/keyboards/{id}")
    void deleteKeyboard(@PathVariable Long id){
        repository.deleteById(id);
    }
}
