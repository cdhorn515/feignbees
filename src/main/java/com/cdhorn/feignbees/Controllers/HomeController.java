package com.cdhorn.feignbees.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;

@Controller
public class HomeController {


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView displayHome() {
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


}
