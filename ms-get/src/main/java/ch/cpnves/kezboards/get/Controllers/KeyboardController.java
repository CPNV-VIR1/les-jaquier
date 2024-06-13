package ch.cpnves.kezboards.get.Controllers;

import ch.cpnves.kezboards.get.Repositories.KeyboardRepository;
import ch.cpnves.kezboards.get.Entities.Keyboard;
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
    curl -i localhost:8080/keyboards/1
    */
    @GetMapping("/keyboards/{id}")
    Keyboard one(@PathVariable Long id){
        return repository.findById(id)
                .orElseThrow(() -> new KeyboardNotFoundException(id));
    }
}
