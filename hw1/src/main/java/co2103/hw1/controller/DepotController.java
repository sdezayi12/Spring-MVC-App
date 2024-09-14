package co2103.hw1.controller;

import co2103.hw1.Hw1Application;
import co2103.hw1.domain.Depot;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@Controller
public class DepotController {
    @InitBinder
    public void InitBinder(WebDataBinder binder ) {
        binder.addValidators(new DepotValidator());
    }
    @GetMapping("/depots")
    public String showDepot(Model model) {
        model.addAttribute("depots", Hw1Application.depots);
        return "depots/list";
    }

    @RequestMapping("/newDepot")
    public String newDepot(Model model) {
        model.addAttribute("depot", new Depot());
        return "depots/form";
    }

    @PostMapping("/addDepot")
    public String addDepot(@Valid @ModelAttribute Depot depot, BindingResult result) {
        if (result.hasErrors()) {
            return "depots/form";
        }
        Hw1Application.depots.add(depot);
        return "redirect:/depots";

    }
}