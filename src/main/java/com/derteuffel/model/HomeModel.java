package com.derteuffel.model;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by derteuffel on 08/09/2018.index
 */
@Controller
public class HomeModel {


    @GetMapping("/")
    public  String home(){
        return "index";
    }
}
