package org.xproc.locages.web;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.xproc.locages.dao.entities.Car;
import org.xproc.locages.metier.CarManagerMetier;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller

public class CarController {

    private final CarManagerMetier carManager;

    @Autowired
    public CarController(CarManagerMetier carManager) {
        this.carManager = carManager;
    }

    @GetMapping("index")
    public String start(Model model) {
        List<Car> cars = carManager.getAllCarsNoPage();
        model.addAttribute("cars", cars);
        return "index";
    }

    @GetMapping("/ajouterCar")
    public String ajouterCar(Model model) {
        model.addAttribute("car", new Car());
        return "ajouterCar";
    }

    @PostMapping("/ajouterOnce")
    public String ajouterCar(Model model,
                             @Valid Car car,
                             BindingResult bindingResult) {
        carManager.addCar(car);
        return "redirect:index";
    }

    @GetMapping("/deleteCar")
    public String deleteCar(Model model, @RequestParam(name = "id") Integer id) {
        if (carManager.deleteCar(id)) {
            return "redirect:/index";

        } else {
            return "error";
        }
    }

    @GetMapping("/editCar")
    public String editCar(Model model, @RequestParam(name = "id") Integer id) {
        Car car = carManager.getCarById(id);
        if (car != null) {
            model.addAttribute("carTobeUpdated", car);
            return "updateCar";
        } else {
            return "error";
        }
    }
    @PostMapping("/ajouter")
    public String ajouterCarAction(Model model,
                             @Valid Car car,
                             BindingResult bindingResult) {
        carManager.addCar(car);
        return "redirect:index";
    }
}
//    @PostMapping("/ajouterOnce")
//    public String addCar(@ModelAttribute("car") Car car,
//                         BindingResult bindingResult,
//                         RedirectAttributes redirectAttributes) {
//        if (bindingResult.hasErrors()) {
//            // If there are validation errors, return to the form
//            return "ajouterCar";
//        }
//
//        // Add the car using the car manager
//        carManager.addCar(car);
//
//        // Redirect to the "Car List" page after successfully adding the car
//        redirectAttributes.addFlashAttribute("message", "Car added successfully");
//        return "redirect:/index";
//    }



//    @PostMapping("/ajouter")
//    public String ajouterCarAction(@RequestParam(name = "NbrPlate") String nbrPlate,
//                                   @RequestParam(name = "KmDriven") int kmDriven,
//                                   @RequestParam(name = "Color") String color,
//                                   @RequestParam(name = "RentPrice") Double rentPrice,
//                                   @RequestParam(name = "NbrSeats") int nbrSeats,
//                                   @RequestParam(name = "Type") String type,
//                                   @RequestParam(name = "Availability") boolean availability,
//                                   @RequestParam(name = "Cmodel") String cmodel,
//                                   @RequestParam(name = "Make") String make,
//                                   @RequestParam(name = "CarPrice") double carPrice,
//                                   @RequestParam(name = "CarGains") double carGains) {
//        Car car = new Car(null, nbrPlate, kmDriven, color, rentPrice, nbrSeats, type, availability, cmodel, make, carPrice, carGains, null);
//        carManager.addCar(car);
//        return "redirect:/indexpage";
//    }
//
//    @PostMapping("/ajouterOnce")
//    public String ajouterCar(@Valid Car car,
//                             BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            return "ajouterCar";
//        }
//        carManager.addCar(car);
//        return "redirect:/index";
//    }
//
//    @GetMapping("/ajouterCar")
//    public String ajouterCar(Model model) {
//        model.addAttribute("car", new Car());
//        return "ajouterCar";
//    }

//    @GetMapping("/index")
//    public String listCars(Model model,
//                           @RequestParam(name = "page", defaultValue = "0") int page,
//                           @RequestParam(name = "taille", defaultValue = "6") int taille,
//                           @RequestParam(name = "search", defaultValue = "") String keyword) {
//        Page<Car> cars = carManager.searchCar(keyword, page, taille);
//        model.addAttribute("listCars", cars.getContent());
//        int[] pages = new int[cars.getTotalPages()];
//        model.addAttribute("pages", pages);
//        model.addAttribute("keyword", keyword);
//        model.addAttribute("page", page);
//        return "indexlayout";
//    }

//    @PostMapping("/indexpage")
//    public String handleIndexPagePost(Model model) {
//        // Add logic to handle form submission or any other action
//        return "redirect:/index";
//    }

//    @GetMapping("/deleteCar")
//    public String deleteCar(@RequestParam(name = "id") Integer id) {
//        if (carManager.deleteCar(id)) {
//            return "redirect:/index";
//        } else {
//            return "redirect:/error";
//        }
//    }
//
//    @GetMapping("/editCar")
//    public String editCar(Model model, @RequestParam(name = "id") Integer id) {
//        Car car = carManager.getCarById(id);
//        if (car != null) {
//            model.addAttribute("CarToBeUpdated", car);
//            return "updateCar";
//        } else {
//            return "redirect:/index";
//        }
//    }

