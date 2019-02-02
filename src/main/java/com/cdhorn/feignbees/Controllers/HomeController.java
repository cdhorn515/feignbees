package com.cdhorn.feignbees.Controllers;

import com.cdhorn.feignbees.Classes.Main;
import com.cdhorn.feignbees.Classes.WeatherResponse;
import com.cdhorn.feignbees.Interfaces.FeignInterface;
import com.cdhorn.feignbees.Models.Location;
import com.cdhorn.feignbees.Models.WeatherAPI;
import feign.Feign;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;

@RestController
public class HomeController {


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView home() {
        ModelAndView mav = new ModelAndView("home");
        return mav;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String addZip(@RequestParam("zip") String zip, HttpServletResponse httpServletResponse) throws Exception {
        System.out.println("POST FROM FORM");
        System.out.println(zip);
        if (zip != null) {
            httpServletResponse.sendRedirect("/springfeign/" + zip);
            return null;
        }
        return "hello, you didn't enter a zip code did you?";

    }

    @RequestMapping(value = "/springfeign/{zip}", method = RequestMethod.GET)
    public ModelAndView spring(@PathVariable("zip") String zip, Model model) throws Exception{
        Location location = new Location();
        location.setZip(zip);
        System.out.println("CONTROLLER");
        System.out.println(zip);

        model.addAttribute(zip);

        WeatherAPI weatherAPI = new WeatherAPI();
        FeignInterface feignInterface = Feign.builder()
                .decoder(new GsonDecoder())
                .encoder(new GsonEncoder())
                .target(FeignInterface.class, "http://api.openweathermap.org/data/2.5");

        WeatherResponse response = feignInterface.weatherResponse(weatherAPI.getAPPID());

        Main response2 = feignInterface.mainResponse(zip, weatherAPI.getAPPID());
        String city = response.getName();
        float temperature = response2.getTemperature();
        System.out.println(temperature);
        System.out.println(city);
        System.out.println(response.toString());
        model.addAttribute("temperature", temperature);
        ModelAndView modelAndView = new ModelAndView("results");
        modelAndView.addObject("city", city);
        modelAndView.addObject("temperature", temperature);

        return modelAndView;
    }
}
