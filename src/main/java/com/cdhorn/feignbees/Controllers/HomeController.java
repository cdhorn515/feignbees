package com.cdhorn.feignbees.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView displayHome() {
        ModelAndView mav = new ModelAndView("home");
        return mav;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String addZip(@RequestParam("zip") String zip, Model model) throws Exception {

        try{
            // check that string is not empty and has at least 5 digits
            if ((zip != null) && (zip.length() >= 5) && (zip.matches("-?\\d+(.\\d+)?"))) {
                String zipTrimmed = zip.substring(0, 5);

                return "redirect:/springfeign/" +zipTrimmed;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("error", "Make sure you enter a valid zip code");
        return "home";
    }

}
