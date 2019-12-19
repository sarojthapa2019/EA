package cs544.controller;

import cs544.domain.Car;
import cs544.service.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class CarController {

    private CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/cars", method = RequestMethod.GET)
    public String getAll(Model model) {
        model.addAttribute("cars", carService.getAll());
        return "carList";
    }

    @RequestMapping(value = "/addCar", method = RequestMethod.GET)
    public String addCar(@ModelAttribute("car") Car car) {
        return "addCar";
    }

    @RequestMapping(value = "/addCar", method = RequestMethod.POST)
    public String add(@Valid Car car, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        System.out.println(bindingResult.hasErrors() + "------------");
        if (bindingResult.hasErrors()) {
            return "addCar";
        } else {
            carService.add(car);
            return "redirect:/cars";
        }
    }

    @RequestMapping(value = "/cars/{id}", method = RequestMethod.GET)
    public String get(@PathVariable Long id, Model model) {
        model.addAttribute("car", carService.get(id).get());
        return "carDetail";
    }

    @RequestMapping(value = "/cars/{id}", method = RequestMethod.POST)
    public String update(@Valid Car car, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            // car.id already set by binding
            return "carDetail";
        } else {
            carService.update(car);
            return "redirect:/cars";
        }

    }

    @RequestMapping(value = "/cars/delete", method = RequestMethod.POST)
    public String delete(Long carId) {
        carService.delete(carId);
        return "redirect:/cars";
    }

}
