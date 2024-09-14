package co2103.hw1;

import co2103.hw1.domain.Bus;
import co2103.hw1.domain.Depot;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Hw1Application implements CommandLineRunner {
    public static List<Depot> depots = new ArrayList<>();

    public static void main(String[] args) {
        SpringApplication.run(Hw1Application.class, args);
    }

    @Override
    public void run(String... run) {
        Depot d1 = new Depot();
        d1.setId(10);
        d1.setLocation("UK");
        d1.setOwner("Victoria");

        List<Bus> buses = new ArrayList<>();

        Bus b1 = new Bus();
        b1.setManufacturer("MegaBus");
        b1.setDriver("Sarah");
        b1.setCity("Birmingham");
        b1.setRoute(11);
        buses.add(b1);

        Bus b2 = new Bus();
        b2.setManufacturer("NationalExpress");
        b2.setDriver("Pearl");
        b2.setCity("Leicester");
        b2.setRoute(12);
        buses.add(b2);

        d1.setBuses(buses);
        depots.add(d1);
    }

}