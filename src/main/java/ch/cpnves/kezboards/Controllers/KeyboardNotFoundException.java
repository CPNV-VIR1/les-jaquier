package ch.cpnves.kezboards.Controllers;

public class KeyboardNotFoundException extends RuntimeException{

    KeyboardNotFoundException(Long id){
        super("Could not find keyboard " + id);
    }
}
