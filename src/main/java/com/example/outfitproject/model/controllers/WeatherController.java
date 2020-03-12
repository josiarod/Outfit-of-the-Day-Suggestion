package com.example.outfitproject.model.controllers;

import com.example.outfitproject.main.entity.Category;
import com.example.outfitproject.main.entity.Item;
import com.example.outfitproject.main.entity.User;
import com.example.outfitproject.main.entity.repositories.CategoryRepository;
import com.example.outfitproject.main.entity.repositories.ItemRepository;
import com.example.outfitproject.main.services.UserService;
import com.example.outfitproject.model.FormCityAttribute;
import com.example.outfitproject.model.Weather;
import com.example.outfitproject.model.WeatherUrl;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
//import com.spring.restapi.models.FormCityAttribute;
//import com.spring.restapi.models.Weather;
//import com.spring.restapi.models.WeatherUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@ComponentScan("com.spring.restapi.config")
@Controller
public class WeatherController {

    @Autowired
    RestTemplate restTemp;

    @Autowired
    private WeatherUrl weatherData;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    UserService userService;

    @RequestMapping(value = "/weather",method= RequestMethod.GET )
    public String CityForm(Model model) {

        model.addAttribute("city", new FormCityAttribute());
        return "formData";
    }

    @RequestMapping(value = "/weather",method= RequestMethod.POST )
    public String getWeather(Model model, @ModelAttribute FormCityAttribute city)
            throws JsonParseException, JsonMappingException, IOException {

        UriComponents uriComponents = UriComponentsBuilder
                .newInstance()
                .scheme("http")
                .host(weatherData.getUrl())
                .path("")
                .query("q={keyword}&appid={appid}")
                .buildAndExpand(city.getCity(),weatherData.getApiKey());

        String uri = uriComponents.toUriString();

        ResponseEntity<String> resp= restTemp.exchange(uri, HttpMethod.GET, null, String.class);

        ObjectMapper mapper = new ObjectMapper();
        Weather weather = mapper.readValue(resp.getBody(), Weather.class);
        model.addAttribute("weatherData", weather);
        //model.addAttribute("items", itemRepository.findAll());
        model.addAttribute("items", getOutfit(weather));
        return "weatherDetails";
    }

    private Set<Item> getOutfit(Weather weather) {

        Iterable<Category> categories = categoryRepository.findAll();
        double temperature = Double.valueOf(weather.getTemp());

        User user = userService.getUser();

        Set<Item> outfit = new HashSet<>();
        for (Category category : categories) {
            List<Item> list = new ArrayList<>();
            if (userService.isUser()) {
                list = itemRepository.findAllByCategoryAndUser(category, user);
            }
            if (userService.isAdmin()) {
                list = itemRepository.findAllByCategory(category);
            }
            if (!list.isEmpty()) {
                int randomid = (int) (Math.random() * list.size());
                outfit.add(list.get(randomid));
            }
        }
        return outfit;
    }

}