package co2103.hw1.controller;

import co2103.hw1.Hw1Application;
import co2103.hw1.domain.Bus;
import co2103.hw1.domain.Depot;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BusController {
    @InitBinder
    public void InitBinder(WebDataBinder binder ) {
        binder.addValidators(new BusValidator());
    }
    @GetMapping("/buses")
    public String showBus(@RequestParam("depot") int depot, Model model) {
        Depot currentDepot = findDepot(depot);
        if (currentDepot != null) {
            model.addAttribute("buses", currentDepot.getBuses());
            model.addAttribute("depot", depot);
            return "buses/list";
        } else {
            return "error";
        }
    }

    @RequestMapping("/newBus")
    public String newBus(@RequestParam("depot") int depot, Model model) {
        Bus newBus = new Bus();
        model.addAttribute("bus", newBus);
        model.addAttribute("depot", depot);
        return "buses/form";
    }

    @PostMapping("/addBus")
    public String addBus(@Valid @ModelAttribute Bus bus, BindingResult result, @RequestParam("depot") int depot, Model model) {
        model.addAttribute("depot", depot);
        if (result.hasErrors()) {
            return "buses/form";
        }
        Depot addDepot = findDepot(depot);
        if (addDepot != null) {
            List<Bus> buses = addDepot.getBuses();
            buses.add(bus);
            return "redirect:/depots";
        }
        else {
            return "error";
        }

    }

    private Depot findDepot(int depot) {
        for (Depot currentDepot : Hw1Application.depots) {
            if (currentDepot.getId() == depot) {
                return currentDepot;
            }
        }
        return null;
    }
}




