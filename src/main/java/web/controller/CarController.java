package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.models.Car;
import web.service.CarService;
import web.service.CarServiceImpl;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarController {

	@GetMapping()
	public String showCars(@RequestParam(name = "count",required = false) Integer count,
							   ModelMap model) {
		CarService carService = new CarServiceImpl();
		if(count != null) {
			model.addAttribute("cars", carService.getCars(count));
		}
		else {
			model.addAttribute("cars", carService.getCars());
		}

		return "cars";
	}
	
}