package ch.cpnves.kezboards.post.Repositories;

import ch.cpnves.kezboards.post.Entities.Keyboard;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(KeyboardRepository repository){
        return args -> {
            log.info("Preloading " + repository.save(new Keyboard("El CYPE", "ANSI", "aluminum", 68)));
            log.info("Preloading " + repository.save(new Keyboard("Frodo Baggins", "ANSI", "plastic", 104)));
            log.info("Preloading " + repository.save(new Keyboard("Gandalf the Grey", "ISO", "wood", 87)));
            log.info("Preloading " + repository.save(new Keyboard("Samwise Gamgee", "ISO", "aluminum", 87)));
            log.info("Preloading " + repository.save(new Keyboard("Aragorn", "ANSI", "steel", 104)));
        };
    }
}
