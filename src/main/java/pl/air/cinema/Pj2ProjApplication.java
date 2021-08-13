package pl.air.cinema;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.air.cinema.init.DataLoader;
import pl.air.cinema.system.CinemaSystem;


@SpringBootApplication
public class Pj2ProjApplication implements ApplicationRunner {
    public static void main(String[] args) {
        SpringApplication.run(Pj2ProjApplication.class, args);
    }

    @Qualifier("dataLoaderPL")
    @Autowired
    private DataLoader dataLoader;
    @Autowired private CinemaSystem cinemaSystem;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        dataLoader.insertData();
        cinemaSystem.run();
    }
}
