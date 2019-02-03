package com.cdhorn.feignbees.Controllers;

import com.cdhorn.feignbees.Models.WeatherResponse;
import com.cdhorn.feignbees.Models.ZipCodeResponse;
import com.cdhorn.feignbees.Interfaces.FeignInterface;
import com.cdhorn.feignbees.Models.ApiInformation;
import feign.Feign;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.text.DecimalFormat;

@Controller
public class ResultController {
    /**
     *
     * @param zip
     *      path variable passed in from front end client
     * @param model
     *      model to pass back to front end with data to display
     * @return
     *      model and view
     * @throws Exception
     */
    @RequestMapping(value = "/springfeign/{zip}", method = RequestMethod.GET)
    public ModelAndView displayResults(@PathVariable("zip") String zip, Model model) throws Exception{
        // access to Api keys
        ApiInformation apiInfo = new ApiInformation();

        // request to get city via user input of zip code
        FeignInterface feignInterface = Feign.builder()
                .decoder(new GsonDecoder())
                .encoder(new GsonEncoder())
                .target(FeignInterface.class, "http://api.openweathermap.org");

        try {
            WeatherResponse response = feignInterface.getCity(zip, apiInfo.getAPPID());
            String city = response.getName();
            // request to get distance from user zip code to Washington, D.C.
            FeignInterface feignInterface1 = Feign.builder()
                    .decoder(new GsonDecoder())
                    .encoder(new GsonEncoder())
                    .target(FeignInterface.class, "https://www.zipcodeapi.com");

            ZipCodeResponse zipCodeResponse = feignInterface1.getDistance(apiInfo.getZC_APIKEY(),zip);
            DecimalFormat df = new DecimalFormat(zipCodeResponse.decimalFormatStr);
            String distance = df.format(zipCodeResponse.getDistance());

            model.addAttribute("distance", distance);
            model.addAttribute("city", city);
            ModelAndView modelAndView = new ModelAndView("results");

            return modelAndView;
        } catch (Exception e) {
            e.printStackTrace();

        }
        ModelAndView mav = new ModelAndView("home");
        model.addAttribute("error", "That doesn't seem to be a US zip code, please try again!");
        return mav;
    }

}
