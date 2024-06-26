package ch.cpnves.kezboards.delete.Controllers;

import ch.cpnves.kezboards.delete.Repositories.KeyboardRepository;
import ch.cpnves.kezboards.delete.Entities.Keyboard;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class KeyboardController {

    private final KeyboardRepository repository;

    KeyboardController(KeyboardRepository repository){
        this.repository = repository;
    }

    /* curl sample :
    curl -i -X DELETE localhost:8080/keyboards/2
    */
    @DeleteMapping("/keyboards/{id}")
    void deleteKeyboard(@PathVariable Long id){
        repository.deleteById(id);
    }
}
