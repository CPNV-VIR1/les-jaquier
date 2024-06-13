package ch.cpnves.kezboards.Controllers;

import ch.cpnves.kezboards.Repositories.KeyboardRepository;
import ch.cpnves.kezboards.Entities.Keyboard;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class KeyboardController {

    private final KeyboardRepository repository;

    KeyboardController(KeyboardRepository repository){
        this.repository = repository;
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
}
