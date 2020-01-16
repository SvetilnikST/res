package com.svetilnik.res.controller;

import com.svetilnik.res.entity.City;
import com.svetilnik.res.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AppController {

    @Autowired
    private CityService service;

    @RequestMapping("/")
    public String viewHomePage(Model model) {
        List<City> listCities = service.listAll();
        model.addAttribute("listCities", listCities);

        return "index";
    }

    @RequestMapping("/new")
    public String showNewCityPage(Model model) {
        City city = new City();
        model.addAttribute("city", city);

        return "new_city";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveCity(@ModelAttribute("city") City city) {
        service.save(city);

        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditCityPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("edit_city");
        City city = service.get(id);
        mav.addObject("city", city);

        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deleteCity(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "redirect:/";

    }
}
