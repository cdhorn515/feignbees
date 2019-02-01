package com.cdhorn.feignbees.Controllers;

import com.cdhorn.feignbees.Classes.HelperFx;
import com.cdhorn.feignbees.Classes.WeatherResponse;
import com.cdhorn.feignbees.Models.Location;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView home() {
        ModelAndView mav = new ModelAndView("home");
        return mav;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ModelAndView spring(@RequestParam("zip") String zip, Model model) throws Exception{
        Location location = new Location();
        location.setZip(zip);
        model.addAttribute(zip);
        System.out.println("======================");
        System.out.println(Integer.parseInt(location.getZip()));

//        ShelterService shelterService = Feign.builder()
//                .encoder(new GsonEncoder())
//                .decoder(new GsonDecoder())
//                .target(ShelterService.class, "http://api.petfinder.com");
//        ShelterAPI shelterAPI = new ShelterAPI();
//        ShelterResponse response = shelterService.shelterResponse(location.getZip(), shelterAPI.getAPIKEY());
//        System.out.println(response);
//        String shelterName = response.getShelters().get(0).getShelterName();
//        String shelterAddress = response.getShelters().get(0).getShelterAddress();
//        String shelterName = response.getShelterName();
//        String shelterAddress = response.getShelterAddress();
//        model.addAttribute("shelterName", shelterName);
//        model.addAttribute("shelterAddress", shelterAddress);
        HelperFx helperFx = new HelperFx();
//        WeatherAPI weatherAPI = new WeatherAPI();
        WeatherResponse response = helperFx.getZipCode(location.getZip());

        String city = response.getName();
        int temperature = Math.round(response.getMain().getTemperature());

        model.addAttribute("city", city);
        model.addAttribute("temperature", temperature);
        ModelAndView modelAndView = new ModelAndView("results");
        modelAndView.addObject("city", city);
        modelAndView.addObject("temperature", temperature);
//        modelAndView.addObject("shelterName", shelterName);
//        modelAndView.addObject("shelterAddress", shelterAddress);

        return modelAndView;
    }
}
