package ch.cpnves.payroll.Controllers;

public class KeyboardNotFoundException extends RuntimeException{

    KeyboardNotFoundException(Long id){
        super("Could not find keyboard " + id);
    }
}
