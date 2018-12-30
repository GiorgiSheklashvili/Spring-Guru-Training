package com.example.jokesapp.controllers;

import com.example.jokesapp.services.JokesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class JokesController {
    JokesService jokesService;

    @Autowired
    public JokesController(JokesService jokesService) {
        this.jokesService = jokesService;
    }

    @RequestMapping(value = {"/", ""},method = RequestMethod.GET)
    public String chuckJokes(Model model){
        model.addAttribute("joke", jokesService.getRandomJokes());
        return "chucknorris";
    }
}
