package com.romanmayer.countries.model;

import java.util.Set;

/**
 * Created by romanmayer on 14/03/2017.
 */
public class Country {

    private String name;
    private int population;
    private Set<String> languages;
    private String capital;

    public Country(String name, int population, Set<String> languages, String capital) {
        this.name = name;
        this.population = population;
        this.languages = languages;
        this.capital = capital;
    }

    public String getName() {
        return name;
    }

    public int getPopulation() {
        return population;
    }

    public Set<String> getLanguages() {
        return languages;
    }

    public String getCapital() {
        return capital;
    }
}
