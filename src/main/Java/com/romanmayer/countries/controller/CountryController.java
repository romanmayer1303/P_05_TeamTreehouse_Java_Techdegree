package com.romanmayer.countries.controller;

import com.romanmayer.countries.data.CountryRepository;
import com.romanmayer.countries.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Controller
public class CountryController {

    @Autowired
    private CountryRepository countryRepository;

    @RequestMapping("/")
    public String listCountries(ModelMap modelMap) {
        List<Country> allCountries = countryRepository.getAllCountries();
        modelMap.put("countries", allCountries);
        return "index";
    }

    @RequestMapping("/country/{name}")
    public String countryDetails(@PathVariable String name, ModelMap modelMap) {
        Country country = countryRepository.findByName(name);
        modelMap.put("country", country);
        return "country-details";
    }

    @RequestMapping("/countries/sortByNames")
    public String sortByNames(ModelMap modelMap) {
        List<Country> allCountries = countryRepository.getAllCountries();
        Collections.sort(allCountries, (c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        modelMap.put("countries", allCountries);
        return "index";
    }

    @RequestMapping("/countries/sortByPopulation")
    public String sortByPopulation(ModelMap modelMap) {
        List<Country> allCountries = countryRepository.getAllCountries();
        Collections.sort(allCountries, (c1, c2) -> c2.getPopulation() - c1.getPopulation());
        modelMap.put("countries", allCountries);
        return "index";
    }




}
