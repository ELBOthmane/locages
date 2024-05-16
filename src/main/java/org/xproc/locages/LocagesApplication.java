package org.xproc.locages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.xproc.locages.dao.entities.Car;
import org.xproc.locages.dao.repositories.CarRepository;
import org.xproc.locages.metier.CarManager;

@SpringBootApplication
public class LocagesApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(LocagesApplication.class, args);
    }

    @Autowired
    private CarRepository carRepository;

    @Override
    public void run(String... args) throws Exception {
        Car car1 = new Car(null, "nbrPlate1", 12, "color1", 12.0, 5, "type1", true, "cmodel1", "make1", 12000, 12000, null);
        Car car2 = new Car(null, "nbrPlate2", 12, "color2", 12.0, 5, "type2", true, "cmodel2", "make2", 12000, 12000, null);
        Car car3 = new Car(null, "nbrPlate3", 12, "color3", 12.0, 5, "type3", true, "cmodel3", "make3", 12000, 12000, null);

        carRepository.save(car1);
        carRepository.save(car2);
        carRepository.save(car3);
    }

}
