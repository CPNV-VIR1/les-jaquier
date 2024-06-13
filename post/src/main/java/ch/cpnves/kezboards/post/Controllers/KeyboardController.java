package ch.cpnves.kezboards.post.Controllers;

import ch.cpnves.kezboards.post.Repositories.KeyboardRepository;
import ch.cpnves.kezboards.post.Entities.Keyboard;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class KeyboardController {

    private final KeyboardRepository repository;

    KeyboardController(KeyboardRepository repository){
        this.repository = repository;
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
}
