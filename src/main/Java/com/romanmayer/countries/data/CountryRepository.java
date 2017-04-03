package com.romanmayer.countries.data;

import com.romanmayer.countries.model.Country;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CountryRepository {

    private static final List<Country> ALL_COUNTRIES = Arrays.asList(
            new Country("Norway", 5252166, new HashSet<>(Arrays.asList("Norwegian", "Sami")), "Oslo"),
            new Country("Sweden", 10019400, new HashSet<>(Arrays.asList("Swedish")), "Stockholm"),
            new Country("Finland", 5488543, new HashSet<>(Arrays.asList("Finnish", "Swedish")), "Helsinki"),
            new Country("Denmark", 5748769, new HashSet<>(Arrays.asList("Danish", "German")), "Copenhagen"),
            new Country("Iceland", 332529, new HashSet<>(Arrays.asList("Icelandic")), "Reykjavik")
    );

    public static List<Country> getAllCountries() {
        return new ArrayList<>(ALL_COUNTRIES);
    }

    public Country findByName(String name) {
        return ALL_COUNTRIES
                .stream()
                .filter(e -> e.getName().equals(name))
                .findFirst().orElse(null);
    }


}
