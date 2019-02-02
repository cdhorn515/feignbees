package com.cdhorn.feignbees.Controllers;

import com.cdhorn.feignbees.Classes.HelperFx;
import com.cdhorn.feignbees.Classes.WeatherResponse;
import com.cdhorn.feignbees.Models.Location;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HomeController {


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView home() {
        ModelAndView mav = new ModelAndView("home");
        return mav;
    }

//    @RequestMapping(value = "/springfeign")
//    public ResponseEntity<?> feignInfo(@RequestParam("zip") String zip, Model model) {
//        WeatherResponse response = feignInterface.weatherResponse();
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    }

    @RequestMapping(value = "/springfeign", method = RequestMethod.POST)
    public String spring(@RequestParam("zip") String zip, Model model) throws Exception{
        Location location = new Location();
        location.setZip(zip);
        model.addAttribute(zip);
        System.out.println("======================");
        System.out.println(Integer.parseInt(location.getZip()));

        HelperFx helperFx = new HelperFx();
//        WeatherAPI weatherAPI = new WeatherAPI();
        WeatherResponse response = helperFx.getZipCode(location.getZip());

//        String city = response.getName();
        float temperature = response.getMain().getTemperature();
        System.out.println(temperature);
        System.out.println(response.toString());
//        model.addAttribute("city", city);
        model.addAttribute("temperature", temperature);
        ModelAndView modelAndView = new ModelAndView("results");
//        modelAndView.addObject("city", city);
        modelAndView.addObject("temperature", temperature);
//        modelAndView.addObject("shelterName", shelterName);
//        modelAndView.addObject("shelterAddress", shelterAddress);

        return "results";
    }
}
